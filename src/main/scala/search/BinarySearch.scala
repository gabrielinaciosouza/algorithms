package search

case object BinarySearch {

  def apply[A](iterable: Iterable[A], element: A)(implicit ordering: Ordering[A]): Option[A] = {
    val seq = iterable.toSeq
    var low = 0
    var high = seq.length - 1

    while (low <= high) {
      val mid = (low + high) / 2
      val value = seq(mid)

      val comp = ordering.compare(value, element)

      comp match {
        case x if x < 0 => low = mid + 1
        case x if x > 0 => high = mid - 1
        case _ => return Some(value)
      }
    }
    None
  }

}

