package week1

object session {


  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 1e-6

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res0: Double = 1.4142135623746899
  sqrt(4)                                         //> res1: Double = 2.0000000929222947
  sqrt(1e-6)                                      //> res2: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res3: Double = 1.0000000031080746E30
}