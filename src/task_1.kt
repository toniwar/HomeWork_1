

fun main() {
    val list = mutableListOf<Int>()
    for(i in 0..99){
        list.add(i)
    }
    println(list.sliceAndSum( true, true, 10,20,1))
    //println(list.sliceAndSum(increment = 100))
}

fun List<Int>.sliceAndSum(evenOddFilter: Boolean = false, even:Boolean = false, fst:Int = 0, lst:Int = lastIndex, increment:Int = 0):Int {
    var range:IntRange

        return  this.filter {
            when{
                evenOddFilter ->
                    if (even) it % 2 == 0 else it % 2 != 0

                else -> true
            }
        }

            .also {
                val last = it.lastIndex
                range = (if(fst in 0..last) fst else 0)..if(lst in 0..last) lst else last

            }
            .slice(range)
            .sumOf { it+increment }

}




