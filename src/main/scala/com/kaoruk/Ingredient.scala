package com.kaoruk

sealed trait Ingredient

case class Peperoni(name: String, bam: Bam) extends Ingredient
case class Mushroom(name: String) extends Ingredient
case class Artichoke(name: String) extends Ingredient
case class Abaloni(name: String) extends Ingredient

//object IngredientSerializers {
//  implicit val peperoniWriter: OutputStream => AvroOutputStream[Peperoni] = os => AvroOutputStream.binary[Peperoni].to(os).build(SchemaFor[Peperoni].schema)
//  implicit val peperoniReader: Array[Byte] => AvroInputStream[Peperoni] = os => AvroInputStream.binary[Peperoni].from(os).build(SchemaFor[Peperoni].schema)
//
//  implicit val mushroomWriter: OutputStream => AvroOutputStream[Mushroom] = os => AvroOutputStream.binary[Mushroom].to(os).build(SchemaFor[Mushroom].schema)
//  implicit val mushroomReader: Array[Byte] => AvroInputStream[Mushroom] = os => AvroInputStream.binary[Mushroom].from(os).build(SchemaFor[Mushroom].schema)
//
//  implicit val appleWriter: OutputStream => AvroOutputStream[Artichoke] = os => AvroOutputStream.binary[Artichoke].to(os).build(SchemaFor[Artichoke].schema)
//  implicit val appleReader: Array[Byte] => AvroInputStream[Artichoke] = os => AvroInputStream.binary[Artichoke].from(os).build(SchemaFor[Artichoke].schema)
//
//  implicit val albaloniWriter: OutputStream => AvroOutputStream[Abaloni] = os => AvroOutputStream.binary[Abaloni].to(os).build(SchemaFor[Abaloni].schema)
//  implicit val albaloniReader: Array[Byte] => AvroInputStream[Abaloni] = os => AvroInputStream.binary[Abaloni].from(os).build(SchemaFor[Abaloni].schema)
//}
