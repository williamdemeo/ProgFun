package week5


// Lecture 5.4: Higher Order List Functions (application: run-length encoding)
// Lecture 5.5: Reduction of Lists
//
object listfun {
	val nums = List(2, -4, 5, 7, 1)           //> nums  : List[Int] = List(2, -4, 5, 7, 1)
	val fruits = List("apple", "pineapple", "orange", "banana")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banana)

	nums filter (x => x > 0)                  //> res0: List[Int] = List(2, 5, 7, 1)
	nums filterNot (x => x > 0)               //> res1: List[Int] = List(-4)
	nums partition (x => x > 0)               //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

	// Longest prefix of the list for which predicate is true
	nums takeWhile (x => x > 0)               //> res3: List[Int] = List(2)
	nums dropWhile (x => x > 0)               //> res4: List[Int] = List(-4, 5, 7, 1)
	nums span (x => x > 0)                    //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
	
	val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xt =>
			val (first, rest) = xs span (y => y == x)
			first :: pack(rest)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	pack(data)                                //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
	def encode[T](xs: List[T]): List[(T, Int)] =
		pack(xs) map (ys => (ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
		
	encode(data)                              //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
	
	def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
                                                  //> sum: (xs: List[Int])Int
	def product(xs: List[Int]) = (1 :: xs) reduceLeft ((x, y) => x * y)
                                                  //> product: (xs: List[Int])Int
	// The n-th underscore is shorthand for the n-th parameter
	def sum2(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sum2: (xs: List[Int])Int
	def product2(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product2: (xs: List[Int])Int
	def sum3(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum3: (xs: List[Int])Int
	def product3(xs: List[Int]) = (xs foldLeft 1) (_ * _)
                                                  //> product3: (xs: List[Int])Int

	def concat[T](xs: List[T], ys: List[T]): List[T] = (xs foldRight ys)(_ :: _)
                                                  //> concat: [T](xs: List[T], ys: List[T])List[T]

	sum(nums)                                 //> res8: Int = 11
	sum2(nums)                                //> res9: Int = 11
	sum3(nums)                                //> res10: Int = 11
	product(nums)                             //> res11: Int = -280
	product2(nums)                            //> res12: Int = -280
	product3(nums)                            //> res13: Int = -280
	
	concat(fruits, data)                      //> res14: List[String] = List(apple, pineapple, orange, banana, a, a, a, b, c,
                                                  //|  c, a)
                                                  
}









   