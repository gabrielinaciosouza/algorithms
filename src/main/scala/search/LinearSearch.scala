package search

case object LinearSearch {

  def apply[A](iterable: Iterable[A], element: A): Option[A] = {
    val iterator = iterable.iterator

    while (iterator.hasNext) {
      val value = iterator.next()
      if (element == value) return Some(value)
    }
    None
  }
}
