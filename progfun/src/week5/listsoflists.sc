package week5review

object listfun {
  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)
  
  nums filter (x => x>0)                          //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  // do both in a single traversal
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  
  nums takeWhile (x => x>0)                       //> res3: List[Int] = List(2)
  nums dropWhile (x => x>0)                       //> res4: List[Int] = List(-4, 5, 7, 1)
  // do both in a single traversal
  nums span (x => x>0)                            //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
  
  // Exercise: Lecture 5.4 at 10'45"
  //
  // Write a function that packs lists like this one:
  //    List("a", "a", "a", "b", "c", "c", "a")
  // and returns the list
  //    List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  //
 	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
 	 	case y :: ys =>
 	 		val (xs1, xs2) = xs span (x => (x==y))
 	 		xs1 :: pack(xs2)
 	}                                         //> pack: [T](xs: List[T])List[List[T]]
 	 
 	 // Test it:
 	 val mylist = List("a", "a", "a", "b", "c", "c", "c", "c", "a")
                                                  //> mylist  : List[String] = List(a, a, a, b, c, c, c, c, a)
 	 
 	 val myPlist = pack(mylist)               //> myPlist  : List[List[String]] = List(List(a, a, a), List(b), List(c, c, c, c
                                                  //| ), List(a))
  // Exercise: Lecture 5.4 at 12'45"
  //
  // Write a function that produces a runlength encoding of a list:
  // Input:
  //    List("a", "a", "a", "b", "c", "c", "a")
  // Output:
  //    List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  //
 	def encode[T](xs: List[T]): List[(T, Int)] = xs match {
 		case Nil => Nil
 		case y :: ys => {
 			val (xs1, xs2) = xs span (x => (x==y))
 			(y, xs1.length) :: encode(xs2)
 		}
 		
 	}                                         //> encode: [T](xs: List[T])List[(T, Int)]
 	
 	encode(mylist)                            //> res6: List[(String, Int)] = List((a,3), (b,1), (c,4), (a,1))
 	

	def max2 (x: Int, y: Int): Int = if (x > y) x else y
                                                  //> max2: (x: Int, y: Int)Int
 	def maxn (xs: List[Int]): Int = xs match {
	 	case Nil => throw new Error("maxx called on Nil list")
	 	case List(x) => x
	 	case y :: ys => max2(y, maxn(ys))
 	}                                         //> maxn: (xs: List[Int])Int
 
 	maxn(nums)                                //> res7: Int = 7
 	
 	def maxLen[T](xs: List[T], ys: List[T]): Int = if (xs.length > ys.length) xs.length else ys.length
                                                  //> maxLen: [T](xs: List[T], ys: List[T])Int
                                                  
	def maxLens[T](xs: List[List[T]]): Int = xs match {
		case Nil => throw new Error("maxLens called on Nil list")
		case List(t) => t.length
		case y :: ys => max2(y.length, maxLens(ys))
	}                                         //> maxLens: [T](xs: List[List[T]])Int



	maxLens(myPlist)                          //> res8: Int = 4
	

	// Take a list of lists and return the index of the shortest one
	def minLenIdx[T](xs: List[List[T]]): Int = {
		xs.zipWithIndex.minBy(_._1.length)._2
	}                                         //> minLenIdx: [T](xs: List[List[T]])Int

	// Take a list of lists and return the length of the shortest one
	def minLen[T](xs: List[List[T]]): Int = {
		(xs map(x => x.length)).min
	}                                         //> minLen: [T](xs: List[List[T]])Int
	

	// append a to the n-th list in a list of lists
	def pushAt[T](xs: List[List[T]], a: T, n: Int): List[List[T]] = {
		if (n==0) (xs.head ::: List(a)) :: xs.tail else xs.head :: pushAt(xs.tail, a, n-1)
	}                                         //> pushAt: [T](xs: List[List[T]], a: T, n: Int)List[List[T]]
	
	// concatenate two lists (complexity: n)
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case z :: zs => z :: concat(zs, ys)
	}                                         //> concat: [T](xs: List[T], ys: List[T])List[T]



	def pushAtShortest[T](xs: List[List[T]], a: T): List[List[T]] =	pushAt(xs, a, minLenIdx(xs))
                                                  //> pushAtShortest: [T](xs: List[List[T]], a: T)List[List[T]]
	
                                                  
	// Add a new row when the number of rows is less than the length of the shortest list
	// Add a new row with a single entry t
	def newRow[T](xs: List[List[T]], a: T): List[List[T]] = {
		if (xs == Nil) List(List(a)) else xs ::: List(List(a))
	}                                         //> newRow: [T](xs: List[List[T]], a: T)List[List[T]]
	
  // TESTS
	val mynewlist = List(List("a", "a", "a"), List("c", "c", "c"), List("q", "q", "q"))
                                                  //> mynewlist  : List[List[String]] = List(List(a, a, a), List(c, c, c), List(q
                                                  //| , q, q))
  minLen(mynewlist)                               //> res9: Int = 3
  minLenIdx(mynewlist)                            //> res10: Int = 0
	pushAt(mynewlist, "d", 2)                 //> res11: List[List[String]] = List(List(a, a, a), List(c, c, c), List(q, q, q
                                                  //| , d))
	pushAtShortest(mynewlist, "d")            //> res12: List[List[String]] = List(List(a, a, a, d), List(c, c, c), List(q, q
                                                  //| , q))

	newRow(mynewlist, "f")                    //> res13: List[List[String]] = List(List(a, a, a), List(c, c, c), List(q, q, q
                                                  //| ), List(f))
	newRow(pushAtShortest(mynewlist, "d"), "f")
                                                  //> res14: List[List[String]] = List(List(a, a, a, d), List(c, c, c), List(q, q
                                                  //| , q), List(f))

	pushAtShortest(newRow(mynewlist, "f"), "d")
                                                  //> res15: List[List[String]] = List(List(a, a, a), List(c, c, c), List(q, q, q
                                                  //| ), List(f, d))

	                                                   
}