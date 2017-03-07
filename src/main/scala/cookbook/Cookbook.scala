package cookbook

class Recipe(val ingredients: List[String], val directions: List[String]) {

}

class Cookbook(val recipes: Map[String, Recipe])