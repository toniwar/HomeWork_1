
data class Person(val name: String, val surname: String, val age: Int){
    fun showPersonInfo (){
        println("$name $surname, age: $age")
    }

}
// Функции-расширения
// Сортировка по возрасту:
fun List<Person>.sortByAge(descending:Boolean = false): List<Person>{
    val sortedList = this.sortedWith(compareBy { it.age })
    return if(!descending) sortedList
    else sortedList.asReversed()
}

// Сортировка по имени:
fun List<Person>.sortByName(reversed:Boolean = false): List<Person> {

    //val sortedByName = this.sortedWith(compareBy { it.name })
    val sortedList = this.sortedWith(compareBy({it.name}, {it.surname}))
    return if(!reversed) sortedList
    else sortedList.asReversed()
}

fun main() {
    test()
}

private val persons = mutableListOf<Person>(
    Person("Петя", "Пупкин", 22),
    Person("Маша","Шушина", 28),
    Person("Вася","Масясин",34 ),
    Person("Маша","Растеряша",21),
    Person("Петя","Велосипедин",55),
    Person("Вася","Васин",32),
    Person("Коля","Простоколя",60)
)

//Тестовые методы для проверки.
fun test(){
    //addNewPerson()
    println()
    println("Sorted by age:")
    persons.sortByAge().map { it.showPersonInfo() }
    println()
    println("Sorted by age (descending):")
    persons.sortByAge(true).map { it.showPersonInfo() }
    println()
    println("Sorted by name")
    persons.sortByName().map { it.showPersonInfo() }
    println()
    println("Sorted by name (reversed)")
    persons.sortByName(true).map { it.showPersonInfo() }

}
private fun addNewPerson(){
    println("Enter the name:")
    val name = readln()
    println("Enter the surname:")
    val surname = readln()
    println("Enter the age:")
    val age = try{readln().toInt()} catch (e:NumberFormatException){-1}
    if(name != "" && surname != "" && age >= 0) persons.add(Person(name, surname, age))
    else {
        println("Incorrect data! Please try again!")
        addNewPerson()
    }
    println("Do you want to add another person?(\"y\"/\"n\")")
    val answer = readln()
    if(answer.equals("y", true)) addNewPerson() else return
}
