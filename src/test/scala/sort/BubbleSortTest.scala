package sort

import munit.FunSuite

class BubbleSortTest extends FunSuite {
  test("BubbleSort should return correct value") {
    implicit val ordering: Ordering.Int.type = Ordering.Int
    val list = Seq(3, 1, 5, 2, 0, 4)

    assertEquals(BubbleSort(list), Seq(0, 1, 2, 3, 4, 5))
  }
}
