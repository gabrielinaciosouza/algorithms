package search

import scala.annotation.tailrec

case object BinarySearch {

  def apply[A](iterable: Iterable[A], element: A)(implicit ordering: Ordering[A]): Option[A] = {
    val seq = iterable.toSeq

    @tailrec
    def helper(low: Int, high: Int, result: Option[A]): Option[A] = {
      if (low > high) {
        result
      } else {
        val mid = (low + high) / 2
        val value = seq(mid)

        val comp = ordering.compare(value, element)

        comp match {
          case x if x < 0 => helper(mid + 1, high, result)
          case x if x > 0 => helper(low, mid - 1, result)
          case _ => Some(value)
        }
      }
    }

    helper(0, seq.length - 1, None)
  }

}

