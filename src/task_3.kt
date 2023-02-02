

fun main() {
    println("The operation took ${theMostImportantFunction(myQuestion)} ms")
}
const val ultimateQuestion = "Ultimate question of Live, the Universe and Everything"

private val myQuestion = { question: String ->
    println("Deep Thought! Give an answer to the question: $question")
    if(question == ultimateQuestion) {
        println("I need to think about it...")
        val timeForReflection = (1000..4000).random()
        Thread.sleep(timeForReflection.toLong())
        println("42")
    }
    else println("Sorry! I don't know")

}

private fun theMostImportantFunction(answer: (question: String) -> Unit, question: String = ultimateQuestion): Long {
    //return measureTimeMillis { answer(question) }
    val startTime = System.currentTimeMillis()
    answer(question)
    return System.currentTimeMillis() - startTime

}