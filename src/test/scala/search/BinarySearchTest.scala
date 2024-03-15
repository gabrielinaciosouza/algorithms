package search

import munit.FunSuite

class BinarySearchTest extends FunSuite {
  test("BinarySearch should return correct value") {
    val list = Seq(0, 1, 2, 3, 4, 5)

    assertEquals(BinarySearch(list, 0)(Ordering.Int), Some(0))
    assertEquals(BinarySearch(list, 1)(Ordering.Int), Some(1))
    assertEquals(BinarySearch(list, 2)(Ordering.Int), Some(2))
    assertEquals(BinarySearch(list, 3)(Ordering.Int), Some(3))
    assertEquals(BinarySearch(list, 4)(Ordering.Int), Some(4))
    assertEquals(BinarySearch(list, 5)(Ordering.Int), Some(5))
  }

  test("BinarySearch should return None if no match") {
    val list = Seq(0, 1, 2, 3, 4, 5)

    assertEquals(BinarySearch(list, 10)(Ordering.Int), None)
  }
}
