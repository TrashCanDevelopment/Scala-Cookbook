package cookbook

class Recipe(val ingredients: List[String], val directions: List[String])

object Recipe {
  def apply(
      ingredients: List[String] = List.empty,
      directions: List[String] = List.empty): Recipe = {
    new Recipe (ingredients, directions)
  }
  def unapply(recipe: Recipe): Option[(List[String], List[String])] =
    Some((recipe.ingredients, recipe.directions))
}

object Cookbook {
  val pbj = Recipe(
    List("peanut butter", "jelly", "bread"),
    List("just do it"))
  val pancakes = Recipe(
    List("water", "milk", "some else"),
    List("just do it NOW!"))
}