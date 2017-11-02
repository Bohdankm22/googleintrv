package sandbox

object Sand {

  def main(args: Array[String]): Unit = {
    println("Returned added value : " + addInt(5, 7))
    println("Returned multiplied value : " + multiplyInt(5, 7))
  }

  def addInt(a: Int, b: Int): Int = a + b

  def multiplyInt(a: Int, b: Int): Int = a * b

}
