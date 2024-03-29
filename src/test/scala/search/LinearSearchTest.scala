package search

import munit.FunSuite

class LinearSearchTest extends FunSuite {
  test("LinearSearch should return correct value") {
    val list = Seq("a", "b", "c")

    assertEquals(LinearSearch(list, "b"), Some("b"))
  }

  test("LinearSearch should return None if no match") {
    val list = Seq("a", "b", "c")

    assertEquals(LinearSearch(list, "d"), None)
  }
}
