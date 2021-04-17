package cinema

fun main() {
    println("Enter the number of rows:")
    val numRows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val numSeats = readLine()!!.toInt()
    val cinema = Array(numRows) {Array(numSeats) { "S" } }
    var count = 0
    var current = 0
    println()
    do {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val input = readLine()!!.toInt()
        if (input == 1) {
            println()
            movie(cinema, numRows, numSeats)
            println()
        }
        if (input == 2) {
            println()

            println("Enter a row number: ")
            var costRow = readLine()!!.toInt()
            println("Enter a seat number in that row:")
            var costLines = readLine()!!.toInt()
            println()

            if (try { (cinema[costRow - 1][costLines - 1] == "B")
                } catch (e: ArrayIndexOutOfBoundsException) {
                    println("Wrong input!")
                    println()
                    run { println("Enter a row number: ")
                        costRow = readLine()!!.toInt()
                        println("Enter a seat number in that row:")
                        costLines = readLine()!!.toInt()
                        println() }
                    continue
                })

            {
                println("That ticket has already been purchased!")
                println()
                run { println("Enter a row number: ")
                    costRow = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    costLines = readLine()!!.toInt()
                    println() }
            }
            if (costRow > numRows || costLines > numSeats) {
                println("Wrong input!")
                println()
                run { println("Enter a row number: ")
                    costRow = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    costLines = readLine()!!.toInt()
                    println() }
            }
            if (numRows * numSeats <= 60 || costRow <= numRows / 2) {
                val price = 10
                current += price
                println("Ticket price: $$price")
            } else {
                val price = 8
                println("Ticket price: $$price")
                current += price
            }
            try { cinema[costRow - 1][costLines - 1] = "B"
            } catch (e: ArrayIndexOutOfBoundsException) {
                println("Wrong input!")
                println()
                run { println("Enter a row number: ")
                    costRow = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    costLines = readLine()!!.toInt()
                    println() }
                continue
            }
            count += 1

            println()
        }

        if (input == 3) {
            println("Number of purchased tickets: $count")
            val percent = ((count.toDouble() * 100) / (numRows.toDouble() * numSeats.toDouble()))
            print("Percentage: ")
            println("%.2f".format(percent) + "%")
            println("Current income: $$current")
            if (numRows * numSeats <= 60) {
                println("Total income: $${10 * numRows * numSeats}")
            } else {
                println("Total income: $${10 * (numRows /2 * numSeats) + 8 * (numRows - numRows /2) * numSeats}")
            }
            println()
        }
        if (input == 0) {
            break
        }
    } while (input != 0)
}
fun movie(cinema: Array<Array<String>>, row: Int, lines: Int) {
    println("Cinema:")
    print(" ")
    (1..lines).forEach { (print(" $it")) }
    println()
    for (i in 0 until row) {
        print("${i + 1} ")
        println(cinema[i].joinToString(" "))
    }
}
