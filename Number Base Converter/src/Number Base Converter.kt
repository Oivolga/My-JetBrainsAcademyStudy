package converter

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

fun main() {
    menu()
}

fun menu() {
    print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
    when (val input = readLine()!!) {
        "/exit" -> return
        else -> inputNumber(input)
    }
    println()
    menu()
}

fun inputNumber(bases: String) {
    val (source, target) = bases.split(" ").map { it.toInt() }
    print("Enter number in base $source to convert to base $target (To go back type /back) ")
    when (val input = readLine()!!) {
        "/back" -> return
        else -> conversion(source, target, input)
    }
    println()
    inputNumber(bases)
}

fun conversion(source: Int, target: Int, input: String) {
    if (!input.contains(".")) {
        println("Conversion result: ${input.toBigInteger(source).toString(target)}")
    } else {
        val (unit, shot) = input.split(".").map { it }
        var c = unit.toBigInteger(source).toString(target)//преобразование целой части в целевую систему
        val nam = toDragonSpeak(shot).split(" ").map { it }//преование дробной части в десятичную систему

        var ten = 0.0
        for (i in nam.indices) {
            try {
                ten += (nam[i].toInt() * (source.toDouble().pow(-1 - i)))
            } catch (e: NumberFormatException) {
                continue
            }
        }
        ten.toBigDecimal().setScale(5, RoundingMode.DOWN)
        //преобразование десятичной дробной части
        val d11 = (ten * target).toBigDecimal().setScale(5, RoundingMode.CEILING)
        var d12 = (ten * target).toBigDecimal().setScale(0, RoundingMode.DOWN)
        val d1 = (d11 - d12)
        if (d12 >= target.toBigDecimal()) {
            d12 = BigDecimal.ZERO
            c += 1
        }
        val d21 = (d1 * target.toBigDecimal()).setScale(5, RoundingMode.CEILING)
        var d22 = (d1 * target.toBigDecimal()).setScale(0, RoundingMode.DOWN)
        val d2 = (d21 - d22)
        if (d22 >= target.toBigDecimal()) {
            d22 = BigDecimal.ZERO
            d12 += BigDecimal.ONE
        }
        val d31 = (d2 * target.toBigDecimal()).setScale(5, RoundingMode.CEILING)
        var d32 = (d2 * target.toBigDecimal()).setScale(0, RoundingMode.DOWN)
        val d3 = (d31 - d32)
        if (d32 >= target.toBigDecimal()) {
            d32 = BigDecimal.ZERO
            d22 += BigDecimal.ONE
        }
        val d41 = (d3 * target.toBigDecimal()).setScale(5, RoundingMode.CEILING)
        var d42 = (d3 * target.toBigDecimal()).setScale(0, RoundingMode.DOWN)
        val d4 = (d41 - d42)
        if (d42 >= target.toBigDecimal()) {
            d42 = BigDecimal.ZERO
            d32 += BigDecimal.ONE
        }
        val d52 = (d4 * target.toBigDecimal()).setScale(0, RoundingMode.DOWN)

        val d = "$d12 $d22 $d32 $d42 $d52"
        val r = abc(d)
        val result = "$c.${r[0]}${r[2]}${r[4]}${r[6]}${r[8]}"
        println("Conversion result: $result")
    }
}

fun toDragonSpeak(shot: String): String {
    return shot.replace(Regex("[0123456789abcdefghijklmnopqrstuvwxyz]")) {
        when (it.value) {
            "0" -> "0 "
            "1" -> "1 "
            "2" -> "2 "
            "3" -> "3 "
            "4" -> "4 "
            "5" -> "5 "
            "6" -> "6 "
            "7" -> "7 "
            "8" -> "8 "
            "9" -> "9 "
            "a" -> "10 "
            "b" -> "11 "
            "c" -> "12 "
            "d" -> "13 "
            "e" -> "14 "
            "f" -> "15 "
            "g" -> "16 "
            "h" -> "17 "
            "i" -> "18 "
            "j" -> "19 "
            "k" -> "20 "
            "l" -> "21 "
            "m" -> "22 "
            "n" -> "23 "
            "o" -> "24 "
            "p" -> "25 "
            "q" -> "26 "
            "r" -> "27 "
            "s" -> "28 "
            "t" -> "29 "
            "u" -> "30 "
            "v" -> "31 "
            "w" -> "32 "
            "x" -> "33 "
            "y" -> "34 "
            "z" -> "35 "
            else -> it.value
        }
    }
}

fun abc(d: String): String {
    val r1 = d.replace("10", "a", true).replace("11", "b", true).replace("12", "c", true).replace("13", "d", true)
    val r2 = r1.replace("14", "e", true).replace("15", "f", true).replace("16", "g", true).replace("17", "h", true)
    val r3 = r2.replace("18", "i", true).replace("19", "j", true).replace("20", "k", true).replace("21", "l", true)
    val r4 = r3.replace("22", "m", true).replace("23", "n", true).replace("24", "o", true).replace("25", "p", true)
    val r5 = r4.replace("26", "q", true).replace("27", "r", true).replace("28", "s", true).replace("29", "t", true)
    val r6 = r5.replace("30", "u", true).replace("31", "v", true).replace("32", "w", true).replace("33", "x", true)
    return r6.replace("34", "y", true).replace("35", "z", true)
}
