package search

case object LinearSearch {

  def apply[A](iterable: Iterable[A], condition: A => Boolean): Option[A] = {
    val iterator = iterable.iterator

    while (iterator.hasNext) {
      val value = iterator.next()
      if (condition(value)) return Some(value)
    }
    None
  }
}
