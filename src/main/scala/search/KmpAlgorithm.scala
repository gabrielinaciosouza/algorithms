package search

import scala.annotation.tailrec

case object KmpAlgorithm {

  def apply(str1: String, str2: String): Int = {
    if (str1 == str2) {
      return 0
    }
    val n = str1.length
    val m = str2.length

    if (m == n || m == 0 || n == 0) return -1
    val lps = getLpsArr(str2)

    @tailrec
    def helper(j: Int, i: Int): (Int, Int) = {
      if (i >= n || j >= m) {
        (j, i)
      } else {
        if (str1.charAt(i) == str2.charAt(j)) {
          helper(j + 1, i + 1)
        } else if (j > 0) {
          helper(lps(j - 1), i)
        } else {
          helper(j, i + 1)
        }
      }
    }

    val (j, i) = helper(0, 0)
    if (j < m) return -1
    i - j
  }

  private def getLpsArr(str: String): Array[Int] = {

    @tailrec
    def helper(length: Int, i: Int, lps: Array[Int]): Array[Int] = {
      if (i >= str.length) {
        lps
      } else {
        if (str.charAt(i) == str.charAt(length)) {
          lps(i) = length + 1
          helper(length + 1, i + 1, lps)
        } else if (length > 0) {
          helper(lps(length - 1), i, lps)
        } else {
          lps(i) = 0
          helper(length, i + 1, lps)
        }
      }

    }

    helper(0, 1, new Array[Int](str.length))
  }
}
