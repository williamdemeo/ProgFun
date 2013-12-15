package week3

// Lecture 3.1 Class Hierarchies
// In this lecture, we implement sets as binary trees.

object intsets {
	val t1 = new NonEmpty(3, new Empty, new Empty)
                                                  //> t1  : week3.NonEmpty = {.3.}
	val t2 = t1.incl(4)                       //> t2  : week3.IntSet = {.3{.4.}}
}

// IntSet is the superclass of Empty and NonEmpty classes (defined below)
abstract class IntSet {

	// Returns True if the element x is contained in the set.
	def contains(x: Int): Boolean

  // Insert the element x into the set.
	// (Actually, create a new set starting with the old and adding x.)
	def incl(x: Int): IntSet
	// (Shouldn't we call this `insert`)

}

// Class Extensions
// Empty and NonEmpty will be subclasses of IntSet

class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	override def toString = "."
}
// Persistent data structures: the old version of the data structure
// is maintained; instead of changing it, a new one is created.

// Notice that empty, left, right are fields of the class.
// Fields need not be explicitly declared.
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

	// check if x is somewhere in the tree
	def contains(x: Int): Boolean =
		if (x < elem) left contains x  // same as this.left.contains(x)
		else if (x > elem) right contains x
		else true

	// Insert x into the set.  (Perhaps clearer to call this method insert.)
	def incl(x: Int): IntSet =
		// Instead of modifying the original object, we create a new one.
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	override def toString = "{" + left + elem + right + "}"
	
	// But what if x is already in the set, but not equal to elem?
	// Won't there then be two occurrences of x in the set? Multiset?
}