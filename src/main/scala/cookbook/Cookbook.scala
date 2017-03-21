package cookbook

case class Recipe(ingredients: Map[String, Mass], directions: List[String]) {
  def shoppingList(kitchen: Map[String, Mass]): List[String] =
    for {
      (name, need) <- ingredients.toList
      have = kitchen.getOrElse(name, Grams(0))
      if have < need
    } yield name
}
trait Measured {
  def amount: Double
  def symbol: String
  override def toString: String = amount+symbol
}
sealed abstract class Mass extends Ordered[Mass] with Measured {
  def toGrams: Grams
  def compare(that: Mass): Int = (this.toGrams.amount - that.toGrams.amount).toInt
}

case class Grams(amount: Double) extends Mass {
  def toGrams = this
  val symbol = "g"
}

case class Milligrams(amount: Double) extends Mass {
  def toGrams = Grams(amount / 1000)
  val symbol = "mg"
}

case class Kilograms(amount: Double) extends Mass {
  def toGrams = Grams(amount * 1000)
  val symbol = "kg"
}

object Cookbook {
  val pbj = Recipe(
    Map("peanut butter" -> Grams(10),
      "jelly" -> Kilograms(0.5),
      "bread" -> Grams(250)),
    List("just do it"))
  val pancakes = Recipe(
    Map("bacon" -> Kilograms(1),
      "pancakes" -> Milligrams(10)),
    List("just do it NOW!"))
}