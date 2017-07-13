package javatrack.strings

import scala.collection.mutable

object Anagram {
  def isAnagram(a: String, b: String): Boolean = {
    if (a.length != b.length)
      false
    else {
      val occurrences = mutable.Map[Char, Int]()

      def merge(c: Char, v: Int) = occurrences += c.toLower -> (occurrences.getOrElse(c, 0) + v)

      (0 until a.length).foreach(i => {
        merge(a(i), 1);
        merge(b(i), -1)
      })

      occurrences.forall { case (_, value) => value == 0 }
    }
  }

  def main(args: Array[String]) {
    if (isAnagram("anagram", "margana"))
      println("Anagrams")
    else
      println("Not Anagrams")
  }
}
