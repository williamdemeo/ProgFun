// import java.util.NoSuchElementException
package week4

// Lecture 3.3 -- Polymorphism
trait List[T] {
	def isEmpty: Boolean  // method what kind of list: Empty or Cons
	def head: T           // the first element of the list
	def tail: List[T]     // the remaining list
	

}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
	// Recall: val is evaluated once; def is evaluated each time it is referenced.
	def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new java.util.NoSuchElementException("Nil.head")
  def tail: Nothing = throw new java.util.NoSuchElementException("Nil.tail")

  
}

