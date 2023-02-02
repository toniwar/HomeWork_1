
fun main() {
    val list = mutableListOf<Int>() // Создание листа
    for(i in 0..99){ //Наполнение листа значениями от 0 до 99
        list.add(i)
    }
    println(list.sliceAndSum( true, true, 10,20,1)) //Вызов функции "sliceAndSum" на выбранном листе
    //println(list.sliceAndSum(increment = 100))
}
/*
Эксэпшен функция "sliceAndSum", внутри которой происходит фильтрация списка, берётся слайс в указанном диапозоне, далее каждый из оставшихся элементов увеличивается
на указанный инкремент, и возвращается сумма элементов. В функции есть 5 необязательных параметров:
"evenOddFilter" (если "true" - происходит фильтрация листа);
"even" (если "true" - удаляются все нечетные числа, если "false" - удаляются четные);
"fst" и "lst" - первый и последний индексы, по которым делается слайс;
"increment" -  значение, на которое увеличевается каждый элемент в списке.
По условиям задачи, лист со значениями от 0 до 99 должен быть отфильтрован от нечетных чисел. Далее делается слайс с 10 по 20 элементы,
затем к каждому элементу прибавляется 1, после чего оставшиеся элементы суммируются. Следовательно, на листе можно вызвать данную функцию с параметрами
"true", "true", "10", "20", "1"
 */
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
/*
Осознаю, что можно проще, но хотелось заморочиться, дабы лучше вникнуть в синтаксис "Kotlin"
 */




