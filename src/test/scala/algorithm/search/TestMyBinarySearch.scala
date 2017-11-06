package algorithm.search

import algorithm.search.MyBinarySearch.search
import algorithm.search.MyBinarySearch.searchRecursively
import org.scalatest.FlatSpec

class TestMyBinarySearch extends FlatSpec{

  val arr = Array(1, 5, 7, 9, 25, 26, 30, 42, 96)
  "A search(loop)" should "find the values that exist in the array" in {
    for (br <- arr) assert(search(arr, br))
  }

  it should "not find the values that are not in the array" in {
    assert(!search(arr, 8))
  }

  val arr1 = Array(1, 5, 7, 9, 25, 26, 30, 42, 96)
  "A search(recursion)" should "find the values that exist in the array" in {
    for (br <- arr1) assert(searchRecursively(arr1, br))
  }

  it should "not find the values that are not in the array" in {
    assert(!searchRecursively(arr1, 8))
  }

}
