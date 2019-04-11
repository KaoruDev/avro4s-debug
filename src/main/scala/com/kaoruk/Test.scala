package com.kaoruk

import java.io.File
import java.nio.file.{Files, Paths}

import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream, AvroSchema}

sealed trait Ingredient

//case class Artichoke(vegan: Boolean) extends Ingredient
case class Mushroom(vegan: Boolean) extends Ingredient
case class Peperoni(vegan: Boolean, organic: Boolean) extends Ingredient

sealed trait CrustType

//case object HandTossed extends CrustType
case object Pan extends CrustType
case object Thin extends CrustType


import scala.util.{Failure, Success, Try}

object Settings {
  val VERSION = 1

  val SCHEMA_PATH = s"avro-tmp/schemas/pizza-schema-$VERSION.avcs"
  val MESSAGE_PATH = s"avro-tmp/messages/pizza-$VERSION"
}

case class Pizza(name: String, ingredient: Seq[Ingredient], crustType: CrustType)

class Runner {
  val schema = AvroSchema[Pizza]

  def write(): Unit ={
    val pizza = Pizza("Pep", Seq(Peperoni(vegan = false, organic = false)), Pan)

    val os = AvroOutputStream.binary[Pizza].to(new File(Settings.MESSAGE_PATH)).build(schema)
    os.write(pizza)
    os.flush()
    os.close()
  }

  def read(): Unit = {
    val is = AvroInputStream.binary[Pizza].from(new File(Settings.MESSAGE_PATH)).build(schema)
    val pizzas = is.iterator.toSet
    is.close()

    println(pizzas.mkString("\n"))
  }

  def writeSchema(): Unit = {
    Try(Files.newBufferedWriter(Paths.get(Settings.SCHEMA_PATH))) match {
      case Success(writer) =>
        writer.write(schema.toString(true))
        Try(writer.close())
      case Failure(exception) =>
        println(s"Failed to write")
        println(exception)
    }
  }
}

object Test extends App {
  val runner = new Runner()

  runner.writeSchema()
  runner.write()
//  runner.read()
}
