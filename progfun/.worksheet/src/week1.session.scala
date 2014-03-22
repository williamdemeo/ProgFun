package week1

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(40); val res$0 = 

  1 + 2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(37); 

  def square(x: Double) = { x * x };System.out.println("""square: (x: Double)Double""");$skip(247); 

  // Here you want second argument to be call-by-name instead of
  // call-by-value so that and(false, loop) terminates and returns false
  // (this is why => appears in second argument)
  def and(x: Boolean, y: => Boolean) = if (x) y else false;System.out.println("""and: (x: Boolean, y: => Boolean)Boolean""");$skip(168); 

  // Here you want second argument to be call-by-name so that
  // or(true, loop) terminates and returns true
  def or(x: Boolean, y: => Boolean) = if (x) true else y;System.out.println("""or: (x: Boolean, y: => Boolean)Boolean""");$skip(44); 
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
  };System.out.println("""sqrt: (x: Double)Double""");$skip(28); 

  def loop: Boolean = loop;System.out.println("""loop: => Boolean""");$skip(15); 
  def x = loop;System.out.println("""x: => Boolean""");$skip(14); val res$1 = 
  or(true, x);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(16); val res$2 = 
  and(false, x);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(13); val res$3 = 

  square(2);System.out.println("""res3: Double = """ + $show(res$3));$skip(12); val res$4 = 
  square(3);System.out.println("""res4: Double = """ + $show(res$4));$skip(10); val res$5 = 
  sqrt(2);System.out.println("""res5: Double = """ + $show(res$5));$skip(10); val res$6 = 
  sqrt(4);System.out.println("""res6: Double = """ + $show(res$6));$skip(13); val res$7 = 
  sqrt(1e-6);System.out.println("""res7: Double = """ + $show(res$7));$skip(13); val res$8 = 
  sqrt(1e60);System.out.println("""res8: Double = """ + $show(res$8))}

}
