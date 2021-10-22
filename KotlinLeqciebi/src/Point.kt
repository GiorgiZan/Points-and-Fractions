import kotlin.math.pow

fun main(){
    val point1 = Point() // (3,4)
    point1.x = 3.0
    point1.y = 4.0

    val point2 = Point()
    point2.x = 5.0
    point2.y = 12.0

    val str = "False"

    // რიცხობრივი შედარება
    println(equals(point1,point2))

    // ტიპების შედარება
    println("${point1.equals(point2)} ${point1.equals(str)}")

    // სიმეტრია ღერძის მიმართ
    println("${point1.sym()}, ${point2.sym()}")

    // მანძილი ორ წერტილს შორის
    println(distBetweenPoints(point1,point2))

}
open class Point(){
    var x : Double = 0.0
    var y : Double = 0.0
    override fun toString() : String{
        return "($x, $y)"
    }
    fun calcDist():Double{
        return Math.sqrt(x*x + y*y)

    }
    fun sym(): String{

        if (x != 0.0)
            x = -1*x
        if (y != 0.0)
            y = -1*y

        return "($x, $y)"
    }
    override fun equals(other: Any?): Boolean {
        if (other is Point){
            return true
        }
        return false
    }
}
fun equals(p1: Point, p2:Point):String{
    if (p1.calcDist() > p2.calcDist())
        return "$p1 > $p2"
    else if (p1.calcDist() < p2.calcDist())
        return "$p1 < $p2"
    else
        return "$p1 = $p2"
}
fun distBetweenPoints(p1:Point, p2 : Point):Double{
    var result = Math.sqrt((p1.x-p2.x).pow(2.0) +(p1.y-p2.y).pow(2.0))
    return result
}
