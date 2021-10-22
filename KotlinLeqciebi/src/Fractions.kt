fun main(){

    var f1 = Fraction()
    f1.numerator = -3
    f1.denominator = 9

    var f2 = Fraction()
    f2.numerator = 5
    f2.denominator = -6

    // შეკვეცა
    println("$f1 = ${f1.simplify()}")
    println("$f2 = ${f2.simplify()}")


    // გამოკლება
    println("$f1 - $f2 = ${substract(f1,f2)}")

    // მიმატება
    println("$f1 + $f2 = ${add(f1,f2)}")

    // გამრავლება
    println("$f1 * $f2 = ${multiply(f1,f2)}")

    // გაყოფა
    println("$f1 / $f2 = ${divide(f1,f2)}")
}


class Fraction {

    var numerator:Int = 0
    var denominator:Int = 1
    
    fun simplify(): String {

        if (denominator < 0) {
            numerator *= -1
            denominator *= -1
        }

        for (i in 2..denominator) {
            while (denominator%i == 0 && numerator%i == 0){
                    denominator = denominator / i
                    numerator = numerator / i
            }
        }
        return "$numerator / $denominator"
    }

    override fun equals(other: Any?): Boolean {

        if (other is Fraction){
            if(numerator*other.denominator / denominator == other.numerator){
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator / $denominator"
    }
}

fun add(f1: Fraction, f2: Fraction): String {

    var result = Fraction()

    result.numerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator
    result.denominator = f1.denominator * f2.denominator

    return result.simplify()
}

fun substract(f1: Fraction, f2: Fraction): String {

    var result = Fraction()

    result.numerator = f1.numerator * f2.denominator - f2.numerator * f1.denominator
    result.denominator = f1.denominator * f2.denominator

    return result.simplify()
}

fun multiply (f1 : Fraction, f2 : Fraction) : String{

    var result = Fraction()

    result.numerator = f1.numerator * f2.numerator
    result.denominator = f1.denominator * f2.denominator

    return result.simplify()
}

fun divide (f1 : Fraction, f2 : Fraction) : String{

    var result = Fraction()

    result.numerator = f1.numerator * f2.denominator
    result.denominator = f1.denominator * f2.numerator

    return result.simplify()
}
