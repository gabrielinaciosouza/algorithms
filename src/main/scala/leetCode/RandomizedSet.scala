package leetCode

import scala.collection.mutable
import scala.util.Random

// https: //leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
final class RandomizedSet {
  private type T = Int
  private type Index = Int

  private val array: mutable.ArrayBuffer[T] = mutable.ArrayBuffer.empty
  private val map: mutable.HashMap[T, Index] = mutable.HashMap.empty
  private val random: Random = new Random()

  def insert(value: Int): Boolean =
    if (map.contains(value)) {
      false
    } else {
      map.update(value, array.length)
      array.append(value)
      true
    }

  def remove(value: Int): Boolean =
    map.remove(value) match {
      case Some(index) =>
        val last = array.remove(array.length - 1)

        if (index != array.length) {
          array(index) = last
          map.update(last, index)
        }

        true

      case None =>
        false
    }

  def getRandom: Int =
    array(random.nextInt(array.length))
}
