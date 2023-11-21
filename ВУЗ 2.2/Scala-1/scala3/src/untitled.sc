trait Pow {

  def toTwo(num:Double):Double

  def toThree(num:Double):Double

  def toFour(num:Double):Double

  def toFive(num:Double):Double
}

class St() extends Pow {
  override def toTwo(num: Double): Double = {
    val nu = Math.pow(num,2)
    nu
  }

  override def toThree(num: Double): Double = {
    val nu = Math.pow(num,3)
    nu
  }

  override def toFour(num: Double): Double = {
    val nu = Math.pow(num,4)
    nu
  }

  override def toFive(num: Double): Double = {
    val nu = Math.pow(num,5)
    nu
  }
}

val pow = new St()

println(2.0)
println(pow.toTwo(2))
println(pow.toThree(2))
println(pow.toFour(2))
println(pow.toFive(2))