package cookbook

class Recipe private (
    val ingredients: List[String] = List.empty,
    val directions: List[String] = List.empty) {
  println("Ingredients: " + ingredients.mkString(", "))
  println("Directions: " + directions.mkString(", "))
}

object Recipe {
  def make(ingredients: List[String], directions: List[String]): Recipe = {
    new Recipe (ingredients, directions)
  }
}

object Cookbook {
  val pbj = Recipe.make(
    List("peanut butter", "jelly", "bread"),
    List("just do it"))
  val pankakes = Recipe.make(
    List("water", "milk", "some else"),
    List("just do it NOW!"))
}