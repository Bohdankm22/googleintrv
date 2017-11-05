package algorithm.search

import scala.annotation.tailrec

object MyBinarySearch {

  /**
    * Binary search with recursion and passing part of the array.
    * @param arr
    * @param i
    * @return
    */
  @tailrec
  def searchRecursively(arr: Array[Int], i: Int): Boolean = {
    if (arr.length == 0 || (arr.length == 1 && arr(0) != i)) false
    else if(arr(arr.length / 2) == i) true
    else if(arr(arr.length / 2) > i) searchRecursively(arr.slice(0, arr.length / 2), i)
    else searchRecursively(arr.slice(arr.length / 2, arr.length), i)
  }

  /**
    * Binary search with 2 pointers.
    */
  def search(arr: Array[Int], i: Int, min: Int, max: Int): Boolean = {
    while (min < max) {
      if (arr(min + (min + max) / 2) >= i) {

      }
    }
    arr(min) == i
  }

  /**
    * Overloaded search method
    */
  def search(arr: Array[Int], i: Int): Boolean = {
    search(arr, i, 0, arr.length)
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 5 , 7, 9, 25, 26, 30, 42, 96)
    for (br <- arr) println("Returned search value : " + searchRecursively(arr, br))
    println("Returned search value : " + searchRecursively(arr, 8))
  }

}
