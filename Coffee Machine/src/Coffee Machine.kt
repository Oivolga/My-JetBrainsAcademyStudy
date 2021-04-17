package machine
var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

fun stat() = run {
    println()
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
    //println()
}
fun sort() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when (readLine()!!.toString()) {
        "1" -> espresso()
        "2" -> latte()
        "3" -> cappuccino()
        "back" -> return
    }
}
fun espresso() {
    if (water > 250 && beans > 16 && cups > 0) {
        produce(250, 16, 4)
        println("I have enough resources, making you a coffee!")
    } else {
        if (water < 250) {
            println("Sorry, not enough water!")
        }
        if (beans < 16) {
            println("Sorry, not enough beans!")
        }
        if (cups == 0) {
            println("Sorry, not enough caps!")
        }
    }
}
fun latte() {
    if (water > 350 && beans > 20 && cups > 0 && milk > 75 ) {
        produce(350, 20, 7, 75)
        println("I have enough resources, making you a coffee!")
    } else {
        if (water < 350) {
            println("Sorry, not enough water!")
        }
        if (beans < 20) {
            println("Sorry, not enough beans!")
        }
        if (cups == 0) {
            println("Sorry, not enough caps!")
        }
        if (milk < 75) {
            println("Sorry, not enough milk!")
        }
    }
}
fun cappuccino() {
    if (water > 200 && beans > 12 && cups > 0 && milk > 100 ) {
        produce(200, 12, 6, 100)
        println("I have enough resources, making you a coffee!")
    } else {
        if (water < 200) {
            println("Sorry, not enough water!")
        }
        if (beans < 12) {
            println("Sorry, not enough beans!")
        }
        if (cups == 0) {
            println("Sorry, not enough caps!")
        }
        if (milk < 100) {
            println("Sorry, not enough milk!")
        }
    }
}
fun produce (water: Int, beans: Int, money: Int, milk: Int = 0) {
    machine.water -= water
    machine.beans -= beans
    cups -= 1
    machine.money += money
    machine.milk -= milk
}
fun fill() {
    println()
    print("Write how many ml of water do you want to add: ")
    water += readLine()!!.toInt()
    print("Write how many ml of milk do you want to add: ")
    milk += readLine()!!.toInt()
    print("Write how many grams of coffee beans do you want to add: ")
    beans += readLine()!!.toInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    cups += readLine()!!.toInt()
}
fun cash() {
    println("I gave you $money")
    money -= money
}
fun main() {
    do {
        println()
        print("Write action (buy, fill, take, remaining, exit): ")
        val input = readLine()!!.toString()
        when (input) {
            "buy" -> sort()
            "fill" -> fill()
            "take" -> cash()
            "remaining" -> stat()
        }
        if (input == "exit") {
            break
        }
    } while (input != "exit")
}
