var circle: Double = 0.0
var total: Double = 10000000.0

fun main(){
    println("helo")
    val points = List(total.toInt()) {point()}
    println("randomized")
    points.forEach(){
        if(it.inCircle()){
            circle++
        }
    }
    println(circle*4/total)
}