package week3

// Lecture 2.5 -- Functions and Data
// Lecture 2.6 -- More Fun With Rationals
object rationals {
  val x = new Rational(1, 3)                      //> x  : week3.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : week3.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : week3.Rational = 3/2
	x.sub(y).sub(z)                           //> res0: week3.Rational = -79/42
	x.add(y).mul(z)                           //> res1: week3.Rational = 11/7
	y.add(y)                                  //> res2: week3.Rational = 10/7
	x.less(y)                                 //> res3: Boolean = true
	x.max(y)                                  //> res4: week3.Rational = 5/7
}

class Rational(x: Int, y: Int) {
	// A requirement that throws illegal argument exception
	require(y != 0, "denominator must not be zero")
	// require is used to prevent illegal arguments; assert is used to check code for errors

	// When `this` is called as a function, it becomes a second constructor.
	def this(x: Int) = this(x, 1)
	
	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	// First implementation:
	// g = gcd(x, y)
	// def numer = x/g
	// def denom = y/g
  // Alternative implementation:
	val numer = x/gcd(x, y)
	val denom = y/gcd(x, y)

	def less(that: Rational) = numer * that.denom < that.numer * denom

	def max(that: Rational) = if (this.less(that)) that else this
	
	def add(that: Rational) =
		new Rational(
			numer * that.denom + that.numer * denom,
			denom * that.denom)
			
	def mul(that: Rational) = new Rational(numer*that.numer, denom*that.denom)

	def neg = new Rational(-numer, denom)
	
	def sub(that: Rational) = add(that.neg)
	
	override def toString = numer + "/" + denom
}