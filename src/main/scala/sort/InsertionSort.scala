package sort

import scala.annotation.tailrec

case object InsertionSort {
  def apply[A](iterable: Iterable[A])(implicit ordering: Ordering[A]): Iterable[A] = {
    helper(1, iterable.toSeq)
  }

  @tailrec
  def helper[A](i: Int, seq: Seq[A])(implicit ordering: Ordering[A]): Iterable[A] = {
    if (i >= seq.length) {
      seq
    } else {
      ordering.compare(seq(i), seq(i - 1)) match {
        case value if value < 0 => helper(i + 1, sort(i, seq))
        case _ => helper(i + 1, seq)
      }
    }
  }

  @tailrec
  def sort[A](index: Int, seq: Seq[A])(implicit ordering: Ordering[A]): Seq[A] = {
    if (index <= 0) {
      seq
    } else {
      ordering.compare(seq(index), seq(index - 1)) match
        case value if value < 0 => sort(index - 1, seq.updated(index, seq(index - 1)).updated(index - 1, seq(index)))
        case _ => seq
    }
  }
}
