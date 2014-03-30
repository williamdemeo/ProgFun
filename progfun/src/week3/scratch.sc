import week3.Rational              // imports just the Rational class
// import week3._                  // imports everything from week3 package
// import week3.{Rational, Hello}  // imports several things from the same package


object scratch {
	new Rational(1, 2)                        //> res0: week3.Rational = 1/2
	
	def error(msg: String) = throw new Error(msg)
                                                  //> error: (msg: String)Nothing
                                                  
	val x = null                              //> x  : Null = null
	val y: String = x                         //> y  : String = null
	if (true) 1 else false                    //> res1: AnyVal = 1
	
	//error("this is an error")
}