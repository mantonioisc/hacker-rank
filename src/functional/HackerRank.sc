def listReplication(num:Int,arr:List[Int]):List[Int] = arr.flatMap(i => List.fill(3)(i))
listReplication(3, List(1,2,3,4))

def filterArray(delim:Int,arr:List[Int]):List[Int] = arr.filter(i => i < delim)
filterArray(3, List(10, 9 ,8 ,2 ,7 ,5 ,1 ,3 ,0))

def filterNonPairs(arr:List[Int]):List[Int] = arr.zipWithIndex.filter{case (_, i) => i % 2 != 0}.map{case (v, _) => v }
filterNonPairs(List(2 ,5 ,3 ,4 ,6 ,7 ,9 ,8))

def arrayOfNElements(num:Int) : List[Int] = (for(i <- 0 until num) yield i).toList
arrayOfNElements(10)