class Cube(sx: Double, sw: Double, sv: Double, sm: Double) {
    private var x: Double = 0.0 //locatie
    private var w: Double = 0.0 //breedte
    private var v: Double = 0.0 //snelheid
    private var m: Double = 0.0 //massa
    private var u: Double = 0.0 //backup snelheid
    private var totalCollisions: Int = 0

    init {
        this.x = sx
        this.w = sw
        this.v = sv
        this.m = sm
    }

    fun checkcollide(other: Cube){
        if(this.x + this.w >= other.x || other.x + other.w >= this.x){
            collided(other)
        }
        if(this.x <= 0){
            this.collideWall()
        }
    }

    fun collided(other: Cube){
        this.u = this.v
        other.u = other.v

        this.v = (this.m - other.m)/(this.m + other.m)*this.u + (2*other.m)/(this.m + other.m) * other.u
        other.v = (other.m - this.m)/(other.m + this.m)*other.u + (2*this.m)/(other.m + this.m) * this.u

        totalCollisions++
    }

    fun collideWall(){
        this.v *= -1
    }

}