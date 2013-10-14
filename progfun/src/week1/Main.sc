package week1

object Main {

	def pascal(c: Int, r: Int): Int = {
		if (r==0) 1
		else
			if (c==0) pascal(c, r-1)
			else
				if (c==r) pascal(c-1,r-1)
				else pascal(c-1,r-1) + pascal(c,r-1)
	}
	
	pascal(0,0)
	pascal(0,1)
	pascal(1,1)
	pascal(0,2)
	pascal(1,2)
	pascal(2,2)
	pascal(0,3)
	pascal(1,3)
	pascal(2,3)
	pascal(3,3)
	pascal(0,4)
	pascal(1,4)
	pascal(2,4)
	pascal(3,4)
	pascal(4,4)
	
	cnt = 0
	def balance(chars: List[Char]): Boolean = {
		if (cnt < 0) false
		if (chars.isEmpty)
			if (cnt ==0) true else false
		hchar = chars.head
		chars = chars.tail
		if (hchar=="(") cnt++
		else
			if (hcar==")") cnt--
		if cnt<0 false else balance(chars)
	}
}