package sort

import scala.annotation.tailrec
import scala.reflect.ClassTag

case object BubbleSort {
  def apply[A: ClassTag](iterable: Iterable[A])(implicit ordering: Ordering[A]): Iterable[A] = {
    val array = iterable.toArray
    sortArray(array)
    array
  }

  private def sortArray[A](arr: Array[A])(implicit ordering: Ordering[A]): Unit = {
    val n = arr.length
    for (i <- 0 until n - 1; j <- 0 until n - i - 1) {
      if (ordering.compare(arr(j), arr(j + 1)) > 0) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
  }
}