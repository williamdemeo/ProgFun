package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 

	def square(x: Double) = {x * x};System.out.println("""square: (x: Double)Double""");$skip(217); 

	// Here you want second argument to be call-by-name so that
	// and(false, loop) terminates and returns false
	// (this is why => appears in second argument)
	def and(x: Boolean, y: => Boolean) = if(x) y else false;System.out.println("""and: (x: Boolean, y: => Boolean)Boolean""");$skip(165); 

	// Here you want second argument to be call-by-name so that
	// or(true, loop) terminates and returns true
		def or(x: Boolean, y: => Boolean) = if(x) true else y;System.out.println("""or: (x: Boolean, y: => Boolean)Boolean""");$skip(44); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(309); 

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 1e-6

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(27); 

	def loop: Boolean = loop;System.out.println("""loop: => Boolean""");$skip(14); 
	def x = loop;System.out.println("""x: => Boolean""");$skip(13); val res$0 = 
	or(true, x);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(14); val res$1 = 
	and(false,x);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(13); val res$2 = 
	
	square(2);System.out.println("""res2: Double = """ + $show(res$2));$skip(11); val res$3 = 
	square(3);System.out.println("""res3: Double = """ + $show(res$3));$skip(10); val res$4 = 
  sqrt(2);System.out.println("""res4: Double = """ + $show(res$4));$skip(10); val res$5 = 
  sqrt(4);System.out.println("""res5: Double = """ + $show(res$5));$skip(13); val res$6 = 
  sqrt(1e-6);System.out.println("""res6: Double = """ + $show(res$6));$skip(13); val res$7 = 
  sqrt(1e60);System.out.println("""res7: Double = """ + $show(res$7))}




}
