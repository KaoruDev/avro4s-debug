package com.kaoruk

import java.io.File
import java.nio.file.{Files, Paths}

import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream, AvroSchema}

sealed trait Ingredient

case class Artichoke(foobar: Boolean, count: Int) extends Ingredient
case class Mushroom(vegan: Boolean, count: Int) extends Ingredient
case class Peperoni(vegan: Boolean, organic: String) extends Ingredient

sealed trait CrustType

case object HandTossed extends CrustType
case object Pan extends CrustType
case object Thin extends CrustType


import scala.util.{Failure, Success, Try}

object Settings {
  val VERSION = 2

  val SCHEMA_PATH = s"avro-out/schemas/pizza-schema-$VERSION.avcs"
  val BASE_MESSAGE_PATH = "avro-out/messages/pizza"
  val MESSAGE_PATH = s"$BASE_MESSAGE_PATH-$VERSION"
}

case class Pizza(name: String, ingredient: Seq[Ingredient], crustType: CrustType)

class Runner {
  val schema = AvroSchema[Pizza]

  def write(): Unit ={
    val os = AvroOutputStream.binary[Pizza].to(new File(Settings.MESSAGE_PATH)).build(schema)

//    val pepPizza = Pizza("Pep", Seq(Peperoni(vegan = false, organic = "No Anitbiotics")), Pan)
//    os.write(pepPizza)

    val mushPizza = Pizza("Mush", Seq(Mushroom(vegan = true, count = 5)), Pan)
    os.write(mushPizza)

    os.flush()
    os.close()
  }

  def read(version: Int): Unit = {
    val is = AvroInputStream.binary[Pizza].from(new File(s"${Settings.BASE_MESSAGE_PATH}-$version")).build(schema)
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

//  runner.writeSchema()
//  runner.write()
  runner.read(version = 1)
}
