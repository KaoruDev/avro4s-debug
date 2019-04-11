package com.kaoruk

import java.io.File
import java.nio.file.{Files, Paths}

import com.sksamuel.avro4s.{AvroInputStream, AvroOutputStream, AvroSchema}

import scala.util.{Failure, Success, Try}

object Settings {
  val VERSION = 4
}

case class Pizza(name: String, ingredient: Seq[Ingredient], vegetarian: Boolean, vegan: Boolean, calories: Int)

class Runner {
  val schema = AvroSchema[Pizza]

  def write(): Unit ={
    val pizza = Pizza( "Pep", Seq(Peperoni("peperoni", Foo)), false, false, 1000 )

    val os = AvroOutputStream.binary[Pizza].to(new File(s"pizzas-${Settings.VERSION}.avro")).build(schema)
    os.write(pizza)
    os.flush()
    os.close()
  }

  def read(): Unit = {
    val is = AvroInputStream.binary[Pizza].from(new File(s"pizzas-${Settings.VERSION}.avro")).build(schema)
    val pizzas = is.iterator.toSet
    is.close()

    println(pizzas.mkString("\n"))
  }

  def writeSchema(): Unit = {
    Try(Files.newBufferedWriter(Paths.get(s"pizza-avro-schema-${Settings.VERSION}.avcs"))) match {
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
  runner.write()
//  runner.read()
}
