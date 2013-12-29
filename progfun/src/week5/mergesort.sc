package week5

// Lecture 5.2 -- Pairs and Tuples
//
// merge sort is more efficient than insertion sort
// If a list constists of zero or one elements, it is already sorted.
// Otherwise, split the list in two, sort the parts, then merge them.
// Here's a first attempt at merge sort:
object mergesort {

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length/2
		if (n == 0) xs
		else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] =
			(xs, ys) match {
				case (Nil, ys) => ys
				case (xs, Nil) => xs
				case (x :: xst, y :: yst) =>
					if (x < y) x :: merge(xst, ys)
					else y :: merge(xs, yst)
			}
			val (first, second) = xs splitAt n
			merge(msort(first), msort(second))
		}
	}                                         //> msort: (xs: List[Int])List[Int]

	val x = List(5, 2, 4, 9, 7)               //> x  : List[Int] = List(5, 2, 4, 9, 7)
	msort(x)                                  //> res0: List[Int] = List(2, 4, 5, 7, 9)
}