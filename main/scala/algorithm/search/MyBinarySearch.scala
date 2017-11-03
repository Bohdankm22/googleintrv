package algorithm.search

object MyBinarySearch {

  def search(arr: Array[Int], i: Int): Boolean = {
    if (arr.length == 0 || (arr.length == 1 && arr(0) != i)) false
    else if(arr(arr.length / 2) == i) true
    else if(arr(arr.length / 2) > i) search(arr.slice(0, arr.length / 2), i)
    else search(arr.slice(arr.length / 2, arr.length), i)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 5 , 7, 9, 25, 26, 30, 42, 96)
    for (br <- arr) println("Returned search value : " + search(arr, br))
    println("Returned search value : " + search(arr, 8))
  }

}
