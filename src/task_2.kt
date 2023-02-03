
data class Person(val name: String, val surname: String, val age: Int){
    fun showPersonInfo (){
        println("$name $surname, age: $age")
    }

}
// Сортировка по возрасту:
fun List<Person>.sortByAge(descending:Boolean = false): List<Person>{
    if(!descending) return this.sortedBy{it.age}
    return this.sortedByDescending { it.age }
}
// Сортировка по имени:
fun List<Person>.sortByName() = this.sortedBy { it.name + it.surname }

fun main() {
    test()
}

private val persons = mutableListOf<Person>()
fun test(){
    addNewPerson()
    println("Sorted by age:")
    persons.sortByAge(true).map { it.showPersonInfo() }
    println()
    persons.sortByName().map { it.showPersonInfo() }

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
