package somepackage

import cookbook.Cookbook

object SomethingWithMain {
  def main(args: Array[String]): Unit = {
    println("main invoked")
    println(args.mkString(" "))
    val x = new Cookbook
    println(x)
  }
}