package tictactoe

val win1 = listOf(0, 1, 2)
val win2 = listOf(3, 4, 5)
val win3 = listOf(6, 7, 8)
val win4 = listOf(0, 3, 6)
val win5 = listOf(1, 4, 7)
val win6 = listOf(2, 5, 8)
val win7 = listOf(0, 4, 8)
val win8 = listOf(2, 4, 6)
var x3InRow = false
var o3InRow = false
var win = false

fun main() {
    val a = mutableListOf(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ')
    var count = 0
    field(a)
    do {
        print("Enter the coordinates: ")
        val b = readLine()!!.toString()
        if (!b.contains(Regex("[0-9]"))) {
            println("You should enter numbers!")
        } else {
            val (y, x) = b.split(" ").map { it.toInt() }
            if (y > 3 || x > 3) {
                println("Coordinates should be from 1 to 3!")
            } else {
                if (!enter(a, y, x)) {
                    println("This cell is occupied! Choose another one!")
                } else {
                    field2(a, y, x, count)
                    count += 1
                }
            }
        }
    } while (!wins(a))
}

fun enter(a: MutableList<Char>, y: Int, x: Int): Boolean {
    var empty = false
    when {
        a[0] == ' ' && y == 1 && x == 1 -> empty = true
        a[1] == ' ' && y == 1 && x == 2 -> empty = true
        a[2] == ' ' && y == 1 && x == 3 -> empty = true
        a[3] == ' ' && y == 2 && x == 1 -> empty = true
        a[4] == ' ' && y == 2 && x == 2 -> empty = true
        a[5] == ' ' && y == 2 && x == 3 -> empty = true
        a[6] == ' ' && y == 3 && x == 1 -> empty = true
        a[7] == ' ' && y == 3 && x == 2 -> empty = true
        a[8] == ' ' && y == 3 && x == 3 -> empty = true
    }
    return empty
}

fun field2(a: MutableList<Char>, y: Int, x: Int, count: Int): MutableList<Char> {
    when {
        y == 1 && x == 1 -> if (count % 2 == 0) {a[0] = 'X'} else {a[0] = 'O'}
        y == 1 && x == 2 -> if (count % 2 == 0) {a[1] = 'X'} else {a[1] = 'O'}
        y == 1 && x == 3 -> if (count % 2 == 0) {a[2] = 'X'} else {a[2] = 'O'}
        y == 2 && x == 1 -> if (count % 2 == 0) {a[3] = 'X'} else {a[3] = 'O'}
        y == 2 && x == 2 -> if (count % 2 == 0) {a[4] = 'X'} else {a[4] = 'O'}
        y == 2 && x == 3 -> if (count % 2 == 0) {a[5] = 'X'} else {a[5] = 'O'}
        y == 3 && x == 1 -> if (count % 2 == 0) {a[6] = 'X'} else {a[6] = 'O'}
        y == 3 && x == 2 -> if (count % 2 == 0) {a[7] = 'X'} else {a[7] = 'O'}
        y == 3 && x == 3 -> if (count % 2 == 0) {a[8] = 'X'} else {a[8] = 'O'}
    }
    field(a)
    return a
}

fun wins(a: MutableList<Char>): Boolean {
    val bX = mutableListOf<Int>()
    val bO = mutableListOf<Int>()
    val z = mutableListOf<Int>()
    for (i in a.indices) {
        when (a[i]) {
            'X' -> bX.add(i)
            'O' -> bO.add(i)
            ' ' -> z.add(i)
        }
    }
    when {
        bX.containsAll(win1) || bX.containsAll(win2) || bX.containsAll(win3) || bX.containsAll(win7) -> x3InRow = true
        bO.containsAll(win1) || bO.containsAll(win2) || bO.containsAll(win3) || bO.containsAll(win7) -> o3InRow = true
        bX.containsAll(win4) || bX.containsAll(win5) || bX.containsAll(win6) || bX.containsAll(win8) -> x3InRow = true
        bO.containsAll(win4) || bO.containsAll(win5) || bO.containsAll(win6) || bO.containsAll(win8) -> o3InRow = true
    }
    if (o3InRow) {
        println("O wins")
        win = true
    } else {
        if (x3InRow) {
            println("X wins")
            win = true
        } else {
            if (!x3InRow && !o3InRow && z.size == 0) {
                println("Draw")
                win = true
            }
        }
    }
    return win
}

fun field(a: MutableList<Char>) {
    println("---------")
    println("| ${a[0]} ${a[1]} ${a[2]} |")
    println("| ${a[3]} ${a[4]} ${a[5]} |")
    println("| ${a[6]} ${a[7]} ${a[8]} |")
    println("---------")
}
