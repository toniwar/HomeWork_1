

fun main() {
    val list = mutableListOf<Int>()
    for(i in 0..99){
        list.add(i)
    }
    print(getSum(list))
}

fun getSum(list: List<Int>):Int{
    val newList = mutableListOf<Int>()
    list.map{ if(it % 2 == 0) newList.add(it)}
    test(newList)
    val slicedList = newList.slice(10..20)
    test(slicedList)
    val newSlicedList = slicedList.map { it+1 }
    test(newSlicedList)
    return newList.sumOf{ it}
}

fun test(list: List<Int>){
    list.forEach{print("$it, ") }
    println()
}



