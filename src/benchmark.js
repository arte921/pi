class Point{
    constructor(){
        this.x = Math.random();
        this.y = Math.random();
    }
    inCircle(){
        if(Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)) <= 1){
            return true
        }else{
            return false
        };
    }
}

var total = 100;
var circle = 0;

var points = new Array(total).map(function(){return new Point();});
points.forEach(function(it){
        if(it.inCirkle){
            circle++;
        }
}

);
console.log(circle*4/total);
