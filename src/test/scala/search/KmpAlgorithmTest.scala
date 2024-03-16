package search

import munit.FunSuite

class KmpAlgorithmTest extends FunSuite {

  test("KmpAlgorithm should return correct the index") {
    val str1 = "abcxabsabcxabmnabcxabmnabckm"
    val str2 = "abcxabmnabck"

    assertEquals(KmpAlgorithm(str1, str2), 15)
  }

  test("KmpAlgorithm should return 0") {
    val str1 = "abcxabmnabck"
    val str2 = "abcxabmnabck"

    assertEquals(KmpAlgorithm(str1, str2), 0)
  }

  test("KmpAlgorithm should return -1") {
    val str1 = "abcxabmnabck"
    val str2 = "abcxabmnabca"

    assertEquals(KmpAlgorithm(str1, str2), -1)
    assertEquals(KmpAlgorithm(str1, ""), -1)
    assertEquals(KmpAlgorithm("", str2), -1)
  }

}
