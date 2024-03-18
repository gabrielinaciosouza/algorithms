package sort

import scala.annotation.tailrec
import scala.reflect.ClassTag

case object InsertionSort {
  def apply[A: ClassTag](iterable: Iterable[A])(implicit ordering: Ordering[A]): Iterable[A] = {
    val array = iterable.toArray[A]
    sortArray(array)
    array
  }

  @tailrec
  private def sortArray[A](arr: Array[A], i: Int = 1)(implicit ordering: Ordering[A]): Unit = {
    if (i < arr.length) {
      var j = i
      while (j > 0 && ordering.compare(arr(j - 1), arr(j)) > 0) {
        val temp = arr(j)
        arr(j) = arr(j - 1)
        arr(j - 1) = temp
        j -= 1
      }
      sortArray(arr, i + 1)
    }
  }
}
