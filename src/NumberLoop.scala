import java.util
import java.util.Scanner

object NumberLoop {
  private def score(args: util.ArrayList[Integer]) = {
    var score = 0 // initialize the values

    var combo = 0
    for (i <- 0 until args.size) {
      if (args.get(i) == 1) { // add score and increase combo if value is 1
        combo += 1
        score += combo
      } else if (args.get(i) == 0) { // reset combo to 0
        combo = 0
      }
    }
    score
  }

  private def multiplier(args: util.ArrayList[Integer]) = {
    var score = 0 // initialize the values

    var multiplier = 1
    for (i <- 0 until args.size) { // add score and increase multiplier
      score += args.get(i) * multiplier
      multiplier += 1
    }
    score
  }

  private def multiplierLog(args: util.ArrayList[Integer]) = {
    var score: Double = 0 // initialize the values

    var multiplier: Double = 1 // multiplier is exponential

    for (i <- 0 until args.size) { // add score and increase multiplier exponentially
      score += args.get(i) * multiplier
      multiplier += multiplier / (1 + Math.log(multiplier))
    }
    Math.floor(score)
  }

  def main(args: Array[String]): Unit = {
    var exit = 0
    val scores =
      new util.ArrayList[Integer] // get list to pass the methods with varargs

    System.out.println(
      "Press 1 for original, 2 for multiplier, 3 for multiplier with exponential growth"
    )
    val sc = new Scanner(System.in) // get input

    val mode = sc.nextInt // get input for mode

    while (exit != 1) {
      if (mode == 1) { // score and combo mode - enter 1 and 2
        System.out.println(
          "Press 1 to increase combo and increase score, 2 to reset combo, 0 to end"
        )
        val number = sc.nextInt // get input for 0, 1 or 2

        if (number == 0) {
          exit = 1 // exit the program

          System.out.println("Score: " + score(scores)) // print the final score

        }
        if (number == 1) scores.add(1) // add score and increase combo by 1
        if (number == 2) scores.add(0) // reset combo to 1
      }
      if (mode == 2) { // score multiplier mode - enter 1 to 9
        System.out.println(
          "Enter 1-9 to add score and increase multiplier, 0 to end"
        )
        val number =
          sc.nextInt // get input and then get the first digit of integer input

        if (number == 0) {
          exit = 1 // exit the program

          System.out.println(
            "Score: " + multiplier(scores)
          ) // print the final score

        } else {
          val value = Character.getNumericValue(
            String.valueOf(Math.abs(Math.max(1, number))).charAt(0)
          ) // get the numeric value between 1 and 9

          scores.add(value) // add the score and increase multiplier by 1

        }
      }
      if (mode == 3) { // score multiplier mode with exponential growth - enter 1 to 9
        System.out.println(
          "Enter 1-9 to add score and increase multiplier, 0 to end"
        )
        val number =
          sc.nextInt // get input and then get the first digit of integer input

        if (number == 0) {
          exit = 1 // exit the program

          System.out.println(
            "Score: " + multiplierLog(scores)
          ) // print the final score

        } else {
          val value = Character.getNumericValue(
            String.valueOf(Math.abs(Math.max(1, number))).charAt(0)
          ) // get the numeric value between 1 and 9

          scores.add(
            value
          ) // add the score and increase multiplier exponentially

        }
      }
    }
  }
}
