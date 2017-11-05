package algorithm.search

import scala.annotation.tailrec

object MyBinarySearch {

  /**
    * Binary search overloaded method to simplify arguments.
    */
  def searchRecursively(arr: Array[Int], i: Int): Boolean = {
    searchRecursively(arr, i, 0, arr.length)
  }

  /**
    * Binary search with pointers to min and max values at the array.
    */
  @tailrec
  def searchRecursively(arr: Array[Int], i: Int, min: Int, max: Int): Boolean = {
    if (arr.length == 0 || (min == max && arr(min) != i)) false
    else if (arr(min + (max - min) / 2) == i) true
    else if (arr(min + (max - min) / 2) > i) searchRecursively(arr, i, min, min + (max - min) / 2)
    else searchRecursively(arr, i, min + (max - min) / 2 + 1, max)
  }

  /**
    * Binary search with 2 pointers and while loop.
    */
  def search(arr: Array[Int], i: Int, min: Int, max: Int): Boolean = {
    if (arr.length == 0) return false
    var minPointer = min
    var maxPointer = max
    while (minPointer < maxPointer) {
      if (arr(minPointer + (maxPointer - minPointer) / 2) == i) return true
      else if (arr(minPointer + (maxPointer - minPointer) / 2) > i) maxPointer = minPointer + (maxPointer - minPointer) / 2
      else minPointer += (maxPointer - minPointer) / 2 + 1
    }
    arr(minPointer) == i
  }

  /**
    * Overloaded search method
    */
  def search(arr: Array[Int], i: Int): Boolean = {
    search(arr, i, 0, arr.length)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 5, 7, 9, 25, 26, 30, 42, 96)
    for (br <- arr) println("Returned search value : " + search(arr, br))
    println("Returned search value : " + search(arr, 8))
  }

}
