package somepackage

import cookbook._

object SomethingWithMain {
  def main(args: Array[String]): Unit = {
    for (i: Int <- 1 to 30) print("_")
    for (i: Int <- 1 to 3) println(" ")

    println("Arguments: "+args.mkString(" "))
    println(Cookbook)

    // неявно вызывает unapply
    Cookbook.pbj match {
      case Recipe(ingredients, directions) =>
        println(ingredients)
        println(directions)
    }

    // неявно вызывает unapply
    def isSimple(recipe: Recipe): Boolean = recipe match {
      case Recipe(_, List(_)) => true // проверяет на предмет инструкций «только из одной строки»
      case _ => false
    }
    println(isSimple(Cookbook.pbj)) //true
    println(isSimple(Cookbook.pancakes)) //true

    // еще пример
    object Even {
      def unapply(n: Int): Option[Int] =
        if (n % 2 == 0) {
          Some(n / 2)
        } else None
    }
    println(Even.unapply(4)) // Some (2)
    println(Even.unapply(3)) // None
    println(4 match {
      case Even(half) => half
    }) // 2
    println(
      3 match {
        case Even(half) => half
      }) // scala.MatchError

    for (i: Int <- 1 to 3) println(" ")
  }
}