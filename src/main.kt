import java.lang.Math.random
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow

val en: Double = 5000000000.0
val mctotal: Double = 50000000.0
val infmax: Double = 90.0
val cpimax: Double = 4000.0
val bpimax: Double = 50000000.0
val bbpmax: Double = 500000.0

var circle: Double = 0.0
var bpi: Double = 0.0
var bpii: Int = 0
var dbpi: Double = 10.0
var gamble: Double = 0.0
var go: Long = 0
var infn: Double = 0.0
var infz: Double = 0.0

var bbpk: Double = 0.0
var bbpz: Double = 0.0

var currentFactor: Double = 1.0
var preFactor: Double = 1.0


fun main() {
    go = System.currentTimeMillis()
    println("Simple e ≈ ${simplee()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("bbp π ≈ ${bbp()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Recursive π ≈ ${cpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Infinite π ≈ ${infpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Monte carlo π ≈ ${mcpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Bogo π ≈ ${bpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    println("Kotlin π ≈ $PI")
}

fun bbp(): Double {
    bbpk = 0.0
    bbpz = 0.0
    while (bbpk < bbpmax) {
        bbpz += 1/16.0.pow(bbpk)*(4/(8*bbpk+1)-2/(8*bbpk+4)-1/(8*bbpk+5)-1/(8*bbpk+6))
        bbpk++
    }
    return bbpz
}

fun simplee(): Double {
    return (1 + 1 / en).pow(en)
}

fun cpi(): Double {
    return 3 + 1 / getDivider(3.0)
}

fun infpi(): Double {
    infn = 0.0
    infz = 0.0
    while (infn < infmax) {
        infz += 2.0.pow(infn)*factorial(infn).pow(2.0)/factorial(2*infn+1)
        infn++
    }
    return infz * 2
}

fun mcpi(): Double {
    circle = 0.0
    val points = List(mctotal.toInt()) { Point() }
    points.forEach {
        if (it.inCircle()) {
            circle++
        }
    }
    return circle * 4 / mctotal
}

fun bpi(): Double {
    bpii = 0
    while (bpii < bpimax) {
        gamble = random() * 10.0
        if (abs(gamble - PI) < dbpi) {
            bpi = gamble
            dbpi = abs(gamble - PI)
        }
        bpii++
    }
    return bpi
}

fun getDivider(n: Double): Double {
    return if (n / 2 < cpimax) {
        6 + n.pow(2) / getDivider(n + 2)
    } else {
        1.0
    }
}

fun factorial(n: Double): Double {
    currentFactor = 0.0
    preFactor = 1.0
    while (currentFactor < n) {
        currentFactor++
        preFactor *= currentFactor
    }
    return preFactor
}
