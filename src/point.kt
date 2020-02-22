import java.lang.Math.random
import kotlin.math.pow
import kotlin.math.sqrt

class Point {
    private var x: Double = 0.0
    private var y: Double = 0.0

    init {
        this.x = random()
        this.y = random()
    }

    fun inCircle(): Boolean {
        return sqrt(this.x.pow(2) + this.y.pow(2)) <= 1
    }
}