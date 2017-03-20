package cookbook

case class Recipe(ingredients: Map[String, Mass], directions: List[String])

abstract class Mass {
  def amount: Double
  def toGrams: Grams
}

case class Grams(amount: Double) extends Mass {
  override def toGrams: Grams = this
  override def toString: String = amount + "g"
}

case class Milligrams(amount: Double) extends Mass {
  override def toGrams: Grams = new Grams(amount / 1000)
  override def toString: String = amount + "mg"
}

case class Kilograms(amount: Double) extends Mass {
  override def toGrams: Grams = new Grams(amount * 1000)
  override def toString: String = amount + "kg"
}

object Cookbook {
  val pbj = Recipe(
    Map("peanut butter" -> new Grams(10),
      "jelly" -> new Kilograms(0.5),
      "bread" -> new Grams(250)),
    List("just do it"))
  val pancakes = Recipe(
    Map("bacon" -> new Kilograms(1),
      "pancakes" -> new Miligrams(10)),
    List("just do it NOW!"))
}