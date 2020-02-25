import java.lang.Math.random
import java.math.BigDecimal
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

val en: Double = 5000000000.0
val mctotal: Double = 50000000.0
val infmax: Double = 90.0
val cpimax: Double = 4000.0
val bpimax: Double = 50000000.0
val bbpmax: BigDecimal = 5000000.0.toBigDecimal()
val gpimax: Double = 5000.0

var circle: Double = 0.0
var bpi: Double = 0.0
var bpii: Int = 0
var dbpi: Double = 0.0
var gamble: Double = 0.0
var go: Long = 0
var infn: Double = 0.0
var infz: Double = 0.0
var bfpi: Double = 0.0
var bbpk: BigDecimal = 0.0.toBigDecimal()
var bbpz: BigDecimal = 0.0.toBigDecimal()
var gpix: Double = 0.0
var gpiy: Double = 0.0
var gpic: Double = 0.0
var currentFactor: Double = 1.0
var preFactor: Double = 1.0

fun main() {
    go = System.currentTimeMillis()
    println("test = ${test(3.0)} in ${System.currentTimeMillis() - go} milliseconds.")

    println("Kotlin π ≈ $PI")

    go = System.currentTimeMillis()
    println("Simple e ≈ ${simplee()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("bbp π ≈ ${bbp()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Recursive π ≈ ${cpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Infinite series π ≈ ${infpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("grid π ≈ ${gpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Monte carlo π ≈ ${mcpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Bogo π ≈ ${bpi()} in ${System.currentTimeMillis() - go} milliseconds.")

    go = System.currentTimeMillis()
    println("Bruteforce π ≈ ${bfpi()} in ${System.currentTimeMillis() - go} milliseconds.")
}

fun bbp(): BigDecimal {
    bbpk = 0.0.toBigDecimal()
    bbpz = 0.0.toBigDecimal()
    while (bbpk < bbpmax) {
        bbpz += (1 / 16.0.pow(bbpk.toDouble()) * (4 / (8 * bbpk.toDouble() + 1) - 2 / (8 * bbpk.toDouble() + 4) - 1 / (8 * bbpk.toDouble() + 5) - 1 / (8 * bbpk.toDouble() + 6))).toBigDecimal()
        bbpk++
    }
    return bbpz
}

fun test(t: Double): Double {
    return 1 / 16.0.pow(t) * (4 / (8 * t + 1) - 2 / (8 * t + 4) - 1 / (8 * t + 5) - 1 / (8 * t + 6))
}

fun collisions(): Double

fun simplee(): Double {
    return (1 + 1 / en).pow(en)
}

fun cpi(): Double {
    return 3 + 1 / getDivider(3.0)
}

fun gpi(): Double {
    gpix = 0.0
    gpic = 0.0
    while (gpix < gpimax) {
        gpiy = 0.0
        while (gpiy <= gpimax) {
            if (sqrt(gpix.pow(2) + gpiy.pow(2)) <= gpimax) gpic++
            gpiy++
        }
        gpix++
    }
    return gpic * 4 / gpimax.pow(2)
}

fun infpi(): Double {
    infn = 0.0
    infz = 0.0
    while (infn < infmax) {
        infz += 2.0.pow(infn) * factorial(infn).pow(2.0) / factorial(2 * infn + 1)
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
    dbpi = 10.0
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

fun bfpi(): Double {
    bfpi = 10.0
    while (abs(bfpi - PI) > 0.0000001) {
        bfpi = random() * 10.0
    }
    return bfpi
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
