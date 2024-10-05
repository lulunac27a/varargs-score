import java.util.*
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.max

object NumberLoop {
    private fun score(args: ArrayList<Int>): Int {
        var score = 0 // initialize the values
        var combo = 0

        for (i in args.indices) {
            if (args[i] == 1) { // add score and increase combo if the value is 1
                combo++
                score += combo
            } else if (args[i] == 0) { // reset combo to 0
                combo = 0
            }
        }
        return score
    }

    private fun multiplier(args: ArrayList<Int>): Int {
        var score = 0 // initialize the values
        var multiplier = 1
        for (i in args.indices) { // add score and increase multiplier
            score += args[i] * multiplier
            multiplier++
        }
        return score
    }

    private fun multiplierLog(args: ArrayList<Int>): Double {
        var score = 0.0 // initialize the values
        var multiplier = 1.0 // multiplier is exponential
        for (i in args.indices) { // add score and increase multiplier exponentially
            score += args[i] * multiplier
            multiplier += multiplier / (1 + ln(multiplier))
        }
        return floor(score)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var exit = false
        val scores = ArrayList<Int>() //get the list to pass the methods with varargs
        println("Press 1 for original, 2 for multiplier, 3 for multiplier with exponential growth")
        val sc = Scanner(System.`in`) //get input
        val mode = sc.nextInt() //get input for mode
        while (!exit) {
            if (mode == 1) { //score and combo mode - enter 1 and 2
                println("Press 1 to increase combo and increase score, 2 to reset combo, 0 to end")
                val number = sc.nextInt() //get input for 0, 1 or 2
                if (number == 0) {
                    exit = true //exit the program
                    println("Score: " + score(scores)) //print the final score
                }
                if (number == 1) {
                    scores.add(1) //add score and increase combo by 1
                }
                if (number == 2) {
                    scores.add(0) //reset combo to 1
                }
            }
            if (mode == 2) { //score multiplier mode - enter 1 to 9
                println("Enter 1-9 to add score and increase multiplier, 0 to end")
                val number = sc.nextInt() //get input and then get the first digit of integer input
                if (number == 0) {
                    exit = true //exit the program
                    println("Score: " + multiplier(scores)) //print the final score
                } else {
                    val value = Character.getNumericValue(
                        abs(
                            max(
                                1.0,
                                number.toDouble()
                            )
                        ).toString()[0]
                    ) //get the numeric value between 1 and 9
                    scores.add(value) //add the score and increase multiplier by 1
                }
            }
            if (mode == 3) { //score multiplier mode with exponential growth - enter 1 to 9
                println("Enter 1-9 to add score and increase multiplier, 0 to end")
                val number = sc.nextInt() //get input and then get the first digit of integer input
                if (number == 0) {
                    exit = true //exit the program
                    println("Score: " + multiplierLog(scores)) //print the final score
                } else {
                    val value = Character.getNumericValue(
                        abs(
                            max(
                                1.0,
                                number.toDouble()
                            )
                        ).toString()[0]
                    ) //get the numeric value between 1 and 9
                    scores.add(value) //add the score and increase multiplier exponentially
                }
            }
        }
        sc.close() //close the scanner input to avoid resource leak
    }
}