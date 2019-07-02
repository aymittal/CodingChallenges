fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val no_of_elements = readLine()!!.toInt()
        val arrayP = readLine()!!.split(' ').map(String::toInt)
        val arrayQ = readLine()!!.split(' ').map(String::toInt)
        var mutableArrayP: MutableList<Int> = arrayP.toMutableList()
        var mutableArrayQ: MutableList<Int> = arrayQ.toMutableList()
        mutableArrayP.sort()
        mutableArrayQ.sort()
        val iteratorP = mutableArrayP.iterator()
        val iteratorQ = mutableArrayQ.iterator()
        while(iteratorP.hasNext()){
            val arrP = iteratorP.next()
            if(arrP in mutableArrayQ){
                iteratorP.remove()
                mutableArrayQ.removeAt(mutableArrayQ.indexOf(arrP))
            }
        }
        if (mutableArrayP.size === 0)
        {
            println("Yes")
        }
        else if (mutableArrayP.size > 2)
        {
            println("No")
        }
        else
      {
        
        if (mutableArrayP.get(0) > mutableArrayQ.get(0))
        {
          print(mutableArrayP.get(0) - mutableArrayQ.get(0))
          print(" ")
          println("2")
        }
        else{
            print(Math.abs(mutableArrayQ.get(0) - mutableArrayP.get(0)))
            print(" ")
            println("1")
        }
      }
    }
}