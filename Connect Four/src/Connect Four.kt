var row = 6
var col = 7
var res = false
var play = ""
var sor = 0
var cor = 0
var x = ""
var correct = false
var gameNum = ""
var counter = 0
var score1 = 0
var score2 = 0

fun main() {
    println("Connect Four\nFirst player's name:")
    val first = readLine()!!
    println("Second player's name:")
    val second = readLine()!!

    while (true) {
        if (correct) {
            println("$first VS $second\n$row x $col board\n$gameNum")
            val mutList = MutableList(row) { i -> MutableList(col + 1) { j -> " " } }
            gameCount(first, second, mutList)
            break
        } else {
            println("Set the board dimensions (Rows x Columns)\nPress Enter for default (6 x 7)")
            val dim = readLine()!!.trim()
            if (dim.isEmpty()) {
                games()
                correct = true
            } else {
                if (dim != "end" && !dim.contains('x', true) || dim.length < 3 || !dim[0].isDigit() || !dim[dim.lastIndex].isDigit()) {
                    println("Invalid input")
                } else {
                    val line = dim.toLowerCase().split("x")
                    row = line[0].trim().toInt()
                    if (dim != "end" && row < 5 || row > 9) {
                        println("Board rows should be from 5 to 9")
                    } else {
                        col = line[1].trim().toInt()
                        if (dim != "end" && col < 5 || col > 9) {
                            println("Board columns should be from 5 to 9")
                        } else {
                            games()
                        }
                    }
                }
            }
        }
    }
}

fun gameCount(first: String, second: String, mutList: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    if (counter == 1) {
        display(mutList)
        firstPlay(first, second, mutList)
        println("Game over!")
    } else {
        var rep = 1
        while (rep <= counter) {
            println("Game #$rep")
            display(mutList)
            if (rep % 2 != 0) {
                firstPlay(first, second, mutList)
            } else {
                secondPlay(first, second, mutList)
            }
            println("Score\n$first: $score1 $second: $score2")

            if (rep == counter) {
                println("Game over!")
                break
            } else {
                rep += 1
                for (i in 0 until row) {
                    for (j in 0 until (col + 1)) {
                        mutList[i][j] = " "
                    }
                }
                play = ""
                x = ""
                sor = 0
                cor = 0
            }
        }
    }
    return mutList
}

fun firstPlay(first: String, second: String, mutList: MutableList<MutableList<String>>) {
    while (play != "end") {
        println("$first's turn:")
        play = readLine()!!
        if (play == "end") {
            break
        } else {
            check(mutList, play)
            if (res)  {
                for (i in (0 until row).reversed()) {
                    if (mutList[i][play.toInt() - 1] == " ") {
                        mutList[i][play.toInt() - 1] = "o"
                        cor += 1
                        display(mutList)
                        if (cor + sor == row * col) {
                            println("It is a draw")
                            score1 += 1
                            score2 += 1
                            play = "end"
                            break
                        } else {
                            if (cor >= 4 && i <= row - 4 && play.toInt() > 3 && mutList[i + 1][play.toInt() - 2] == "o" &&
                                mutList[i + 2][play.toInt() - 3] == "o" && mutList[i + 3][play.toInt() - 4] == "o") {
                                play = "end"
                                println("Player $first won")
                                score1 += 2
                                break
                            } else {
                                if (cor >= 4 && i <= row - 4 && mutList[i + 1][play.toInt()-1] == "o" &&
                                    mutList[i + 2][play.toInt() - 1] == "o" && mutList[i + 3][play.toInt() - 1] == "o") {
                                    play = "end"
                                    println("Player $first won")
                                    score1 += 2
                                    break
                                } else {
                                    win(mutList)
                                    if (x.contains("oooo")) {
                                        play = "end"
                                        println("Player $first won")
                                        score1 += 2
                                        break
                                    } else {
                                        secondPlay(first, second, mutList)
                                        break
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun win(mutList: MutableList<MutableList<String>>): String {
    for (i in 0 until row) {
        for (j in 0 until (col + 1)) {
            if (j == 0) {
                x += " "
            }
            x += mutList[i][j]
        }
    }
    return x
}

fun secondPlay(first: String, second: String, mutList: MutableList<MutableList<String>>) {
    while (play != "end") {
        println("$second's turn:")
        play = readLine()!!
        if (play == "end") {
            break
        } else {
            check(mutList, play)
            if (res)  {
                for (i in (0 until row).reversed()) {
                    if (mutList[i][play.toInt() - 1] == " ") {
                        mutList[i][play.toInt() - 1] = "*"
                        sor += 1
                        display(mutList)
                        if (cor + sor == row * col) {
                            play = "end"
                            println("It is a draw")
                            score1 += 1
                            score2 += 1
                            break
                        } else {
                            if (sor >= 4 && i <= row - 4 && play.toInt() > 3 && mutList[i + 1][play.toInt() - 2] == "*" &&
                                mutList[i + 2][play.toInt() - 3] == "*" && mutList[i+3][play.toInt() - 4] == "*") {
                                play = "end"
                                println("Player $second won")
                                score2 += 2
                                break
                            } else {
                                if (sor >= 4 && i > 3 && play.toInt() > 3 && mutList[i - 1][play.toInt() - 2] == "*" &&
                                    mutList[i - 2][play.toInt() - 3] == "*" && mutList[i - 3][play.toInt() - 4] == "*") {
                                    play = "end"
                                    println("Player $second won")
                                    score2 += 2
                                    break
                                } else {
                                    if (sor >= 4 && i <= row - 4 && mutList[i+1][play.toInt()-1] == "*" &&
                                        mutList[i + 2][play.toInt() - 1] == "*" && mutList[i + 3][play.toInt() - 1] == "*") {
                                        play = "end"
                                        println("Player $second won")
                                        score2 += 2
                                        break
                                    } else {
                                        win(mutList)
                                        if (x.contains("****")) {
                                            play = "end"
                                            println("Player $second won")
                                            score2 += 2
                                            break
                                        } else {
                                            firstPlay(first, second, mutList)
                                            break
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun check(mutList: MutableList<MutableList<String>>, play: String): Boolean {
    var count = 0
    if (play.isEmpty() || !play[0].isDigit() || play.contains(Regex("[a-zA-Z]"))) {
        println("Incorrect column number")
        res = false
    } else {
        if (play.toInt() < 1 || play.toInt() > col) {
            println("The column number is out of range (1 - $col)")
            res = false
        } else {
            for  (i in (0 until row).reversed()) {
                if (mutList[i][play.toInt() -1] !=  " ") {
                    count += 1
                    if (count == row){
                        println("Column $play is full")
                        res = false
                    }
                } else {
                    res = true
                }
            }
        }
    }
    return res
}

fun display(mutList: MutableList<MutableList<String>>) {
    for (i in 1..col) {
        print(" $i")
    }
    println()
    for (i in 0 until row) {
        for (j in 0 until (col + 1)) {
            print("║${mutList[i][j]}")
        }
        println()
    }
    print("╚")
    for (i in 1 until col) {
        print("═╩")
    }
    println("═╝")
}
fun games() {
    while (!correct) {
        println(
            "Do you want to play single or multiple games?\n" +
                    "For a single game, input 1 or press Enter\n" +
                    "Input a number of games:"
        )
        val game = readLine()!!
        if (game.isEmpty() || game == "1") {
            gameNum = "Single game"
            correct = true
            counter = 1
        } else {
            if (game.contains(Regex("[0-9]")) && game != "0" && !game.contains(" ")) {
                gameNum = "Total $game games"
                correct = true
                counter = game.toInt()
            } else {
                println("Invalid input")
            }
        }
    }
}



