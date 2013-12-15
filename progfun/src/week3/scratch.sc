import week3.Rational
// To import everything, do:
//   import week3._
// To import several things from the same package:
//   import week3.{Rational, Hello}

object scratch {
	new Rational(1, 2)                        //> res0: week3.Rational = 1/2
	
	def error(msg: String) = throw new Error(msg)
                                                  //> error: (msg: String)Nothing
                                                  
	val x = null                              //> x  : Null = null
	val y: String = x                         //> y  : String = null
	if (true) 1 else false                    //> res1: AnyVal = 1
}