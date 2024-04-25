object Calculator {
  def main(args: Array[String]): Unit = {
    println("Welcome to Simple Calculator!")
    calculatorLoop() // Functional Programming: Calling a function as first-class citizen
  }

  def calculatorLoop(): Unit = {
    var continue = true // Functional Programming: Immutable variable

    while (continue) {
      println("\nSelect operation:")
      println("1. Addition (+)")
      println("2. Subtraction (-)")
      println("3. Multiplication (*)")
      println("4. Division (/)")
      println("5. Exit")

      val choice = getValidChoice("Enter your choice: ") // Type Inference: Compiler deduces type of choice

      choice match { // Pattern Matching: Match expression to handle different cases
        case 1 => performOperation("+")
        case 2 => performOperation("-")
        case 3 => performOperation("*")
        case 4 => performOperation("/")
        case 5 =>
          println("Exiting calculator. Goodbye!")
          continue = false
        case _ => println("Invalid choice. Please try again.")
      }
    }
  }

  def performOperation(operator: String): Unit = {
    val num1 = getUserInput("Enter first number: ").toDouble
    val num2 = getUserInput("Enter second number: ").toDouble

    operator match {
      case "+" => println(s"Result: $num1 + $num2 = ${num1 + num2}") // String Interpolation
      case "-" => println(s"Result: $num1 - $num2 = ${num1 - num2}")
      case "*" => println(s"Result: $num1 * $num2 = ${num1 * num2}")
      case "/" =>
        if (num2 != 0)
          println(s"Result: $num1 / $num2 = ${num1 / num2}")
        else
          println("Error: Division by zero!")
      case _ => println("Invalid operator.")
    }
  }

  def getUserInput(prompt: String): String = {
    print(prompt)
    scala.io.StdIn.readLine()
  }

  def getValidChoice(prompt: String): Int = {
    var isValid = false
    var choice = 0

    while (!isValid) {
      //Error Handling: 
      try {
        choice = getUserInput(prompt).toInt
        isValid = true
      } catch {
        case _: NumberFormatException => println("Invalid input. Please enter a number.")
      }
    }

    choice
  }
}
