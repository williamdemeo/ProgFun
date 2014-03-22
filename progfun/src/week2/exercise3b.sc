package week2

object exercise3b {

  def product(f:Int => Int)(a: Int, b: Int): Int = {
  	if (a>b) 1
  	else f(a) * product(f)(a+1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  def factorial(b: Int): Int = product(a=>a)(1,b) //> factorial: (b: Int)Int
  	
  // Test it:
  factorial(0)                                    //> res0: Int = 1
  
  def mapReduce(map: Int => Int, reduce: (Int, Int) => Int, unit: Int)(a: Int, b: Int): Int = {
  	if(a > b) unit
  	else reduce(map(a), mapReduce(map, reduce, unit)(a+1, b))
  }                                               //> mapReduce: (map: Int => Int, reduce: (Int, Int) => Int, unit: Int)(a: Int, b
                                                  //| : Int)Int

	mapReduce(x => x*x, (a, b) => a+b, 0)(0, 3)
                                                  //> res1: Int = 14
}