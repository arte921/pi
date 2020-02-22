import kotlin.math.pow
import kotlin.math.sqrt

class Point {
    var x: Double = 0.0
    var y: Double = 0.0

    init{
        x = Math.random()
        y = Math.random()
    }

    fun inCircle(): Boolean{
        return sqrt(this.x.pow(2)+this.y.pow(2)) <= 1
    }
}