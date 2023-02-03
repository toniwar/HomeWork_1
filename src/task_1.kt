
fun main() {
    val list = mutableListOf<Int>()
    for(i in 0..99){
        list.add(i)
    }
    print(getFinalResult(list))
}

fun getFinalResult(list: List<Int>):Int{
    return list.filter{ it % 2 == 0}
        .checkList()
        .slice(10..20)
        .checkList()
        .map { it+1 }
        .checkList()
        .sumOf { it }

}
fun List<Int>.checkList():List<Int> {
    println(this)
    return this
}
