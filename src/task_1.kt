import java.lang.IndexOutOfBoundsException

fun main() {
    val list = mutableListOf<Int>()
    for(i in 0..99){
        list.add(i)
    }
    println(list.getResult(true, 10..20, 1))
}

fun List<Int>.getResult(even:Boolean = true, range: IntRange = first().. last(), increment:Int = 0):Int {

    return  try {
        this.filter { if (even) it % 2 == 0 else it % 2 != 0 }
            .slice(range)
            .map { it + increment }
            .sumOf { it }
    } catch (e: IndexOutOfBoundsException) {
        this.filter { if (even) it % 2 == 0 else it % 2 != 0 }
            .map { it + increment }
            .sumOf { it }
    }
}




