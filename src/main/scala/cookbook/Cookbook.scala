package cookbook

case class Recipe(ingredients: Map[String, Mass], directions: List[String]) {
  def shoppingList(kitchen: Map[String, Mass]): List[String] =
    for {
      (name, need) <- ingredients.toList
      have = kitchen.getOrElse(name, Grams(0))
      if have < need
    } yield name
}

sealed abstract class Mass extends Ordered[Mass] {
  def amount: Double
  def toGrams: Grams
  def compare(that: Mass): Int = (this.toGrams.amount - that.toGrams.amount).toInt
}

case class Grams(amount: Double) extends Mass {
  override def toGrams: Grams = this
  override def toString: String = amount + "g"
}

case class Milligrams(amount: Double) extends Mass {
  override def toGrams: Grams = Grams(amount / 1000)
  override def toString: String = amount + "mg"
}

case class Kilograms(amount: Double) extends Mass {
  override def toGrams: Grams = Grams(amount * 1000)
  override def toString: String = amount + "kg"
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