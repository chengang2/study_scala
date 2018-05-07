package implicits

object test extends App{
  
  implicit def a2RichA(a : A) = new RichA(a)
  val b = new A
  b.rich
  
   import Context.ddd
   AAA.print("nimei")
   
  class SignPen {
    def write(content: String) = println(content)
  }
  
  implicit val signPen = new SignPen

  def signForExam(name: String) (implicit signPen: SignPen) {
    signPen.write(name + " come to exam in time.")
   }
  
  signForExam("xx")
  
  implicit class Calculator(x : Int){
    def add(a : Int)  : Int = a + 1
    def adds(a : String)  : String = a+1
  }

  //import xx.xx.Calculator
  println(1.add(1))
  println(1.adds("a"))
   
}


class A{

}

class RichA(a : A){
  def rich{
    println("rich...")
  }
}

object AAA{
  def print(content:String)(implicit prefix:String){
    println(prefix + ":" + content)
  }
}

object Context{
  implicit val ccc : String = "Hello"
  implicit val ddd : String = "hello"
}