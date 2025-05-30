import java.util
import java.util.{ArrayList, Scanner}


object NumberLoopSum {
  private def score(args: util.ArrayList[Integer]) = {
    var score = 0 //initialize the values

    var combo = 0
    for (i <- 0 until args.size) {
      if (args.get(i) eq 1) { //add score and increase combo if the value is 1
        combo += 1
        score += combo
      }
      else if (args.get(i) eq 0) { //reset combo to 0
        combo = 0
      }
    }
    score
  }

  private def calculateScoreWithMultiplier(args: util.ArrayList[Integer]) = {
    var score = 0 //initialize the values

    var multiplier = 1
    for (i <- 0 until args.size) { //add score and increase multiplier
      score += args.get(i) * multiplier
      multiplier += 1
    }
    score
  }

  private def calculateScoreWithExponentialMultiplier(args: util.ArrayList[Integer]) = {
    var score = 0 //initialize the values

    var multiplier = 1 //multiplier is exponential

    for (i <- 0 until args.size) { //add score and increase multiplier exponentially
      score += args.get(i) * multiplier
      multiplier += multiplier / (1 + Math.log(multiplier))
    }
    Math.floor(score)
  }

  def main(args: Array[String]): Unit = {
    var exit = false
    val scores = new util.ArrayList[Integer] //get the list to pass the methods with varargs

    System.out.println("Press 1 for original, 2 for a multiplier, 3 for a multiplier with exponential growth")
    val sc = new Scanner(System.in) //get input

    val mode = sc.nextInt //get input for mode

    while (!exit) {
      if (mode == 1) { //score and combo mode — enter 1 and 2
        System.out.println("Press 1 to increase combo and increase score, 2 to reset combo, 0 to end")
        val number = sc.nextInt //get input for 0, 1 or 2

        if (number == 0) {
          exit = true //exit the program

          System.out.println("Score: " + score(scores)) //print the final score

        }
        if (number == 1) scores.add(1) //add score and increase combo by 1
        if (number == 2) scores.add(0) //reset combo to 1
      }
      if (mode == 2) { //score multiplier mode - enter 1 to 9
        System.out.println("Enter 1-9 to add score and increase multiplier, 0 to end")
        val numberStr = sc.next //get input and then get the first digit of integer input

        if ("0" == numberStr) {
          exit = true //exit the program

          System.out.println("Score: " + calculateScoreWithMultiplier(scores)) //print the final score

        }
        else {
          var sum = 0 //initialize sum to 0

          for (i <- 0 until numberStr.length) { //add the sum of the digits
            sum += Character.getNumericValue(numberStr.charAt(i)) //get the numeric value between 0 and 9

          }
          scores.add(sum) //add the score and increase multiplier exponentially

        }
      }
      if (mode == 3) { //score multiplier mode with exponential growth — enter 1 to 9
        System.out.println("Enter 1-9 to add score and increase multiplier, 0 to end")
        val numberStr = sc.next //get input and then get the first digit of integer input

        if ("0" == numberStr) {
          exit = true //exit the program

          System.out.println("Score: " + calculateScoreWithExponentialMultiplier(scores)) //print the final score

        }
        else {
          var sum = 0 //initialize sum to 0

          for (i <- 0 until numberStr.length) { //add the sum of the digits
            sum += Character.getNumericValue(numberStr.charAt(i)) //get the numeric value between 0 and 9

          }
          scores.add(sum) //add the score and increase multiplier exponentially

        }
      }
    }
    sc.close() //close the scanner input to avoid resource leak

  }
}