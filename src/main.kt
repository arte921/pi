import java.lang.Math.random
import java.math.BigInteger
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.round

val mctotal: Double = 50000000.0
val en: Double = 5000000000.0
val cpimax: Double = 4000.0
var bpimax: Double = 50000000.0

var mcpi: Double = 0.0
var simplee: Double = 0.0
var bpi: Double = 0.0
var bpii: Int = 0
var dbpi: Double = 10.0
var gamble: Double = 0.0
var go: Long = 0

var cpi: Double = 0.0

var circle: Double = 0.0

fun getDivider(n: Double): Double{
    return if(n/2<cpimax){
        6+n.pow(2)/getDivider(n+2)
    }else{
        1.0
    }
}

fun main() {
    go = System.currentTimeMillis()
    simplee = (1+1/en).pow(en)
    println("e ≈ $simplee in ${System.currentTimeMillis()-go} milliseconds")

    go = System.currentTimeMillis()
    cpi = 3+1/getDivider(3.0)
    println("recursive π ≈ $cpi in ${System.currentTimeMillis()-go} milliseconds")

    go = System.currentTimeMillis()
    val points = List(mctotal.toInt()) { Point() }
    points.forEach {
        if (it.inCircle()) {
            circle++
        }
    }
    mcpi = circle * 4 / mctotal

    println("mote carlo π ≈ $mcpi in ${System.currentTimeMillis()-go} milliseconds")

    go = System.currentTimeMillis()
    while(bpii<bpimax){
        gamble = random()*10.0

        if(abs(gamble - PI) < dbpi){
            bpi = gamble
            dbpi = abs(gamble - PI)
        }
        bpii++
    }

    println("bogo π ≈ $bpi in ${System.currentTimeMillis()-go} milliseconds")
}
