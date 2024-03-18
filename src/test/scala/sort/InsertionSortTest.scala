package sort

import munit.FunSuite

class InsertionSortTest extends FunSuite {
  test("InsertionSort should return correct value") {
    implicit val ordering: Ordering.Int.type = Ordering.Int
    val list = Seq(3, 1, 5, 2, 0, 4)

    assertEquals(InsertionSort(list), Seq(0, 1, 2, 3, 4, 5))
  }
}
