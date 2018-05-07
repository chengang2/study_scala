package Basic

class Basic6 {

}

class A{

}

class RichA(a : A){
  def rich{
    println("rich...")
  }
}

//Scala会根据隐式转换函数的签名，在程序中使用到隐式转换函数接收的参数类型定义的对象时，会自动将其传入隐式转换函数，转换为另外一种类型的对象并返回。这就是“隐式转换”
object Basic6 extends App{

  implicit def a2RichA(a : A) = new RichA(a)

  val b = new A
  b.rich

//  def testParam(implicit name : String){
//    println(name)
//  }
//
//  implicit val name = "implicit!!!"
//
//  testParam
//  testParam("xx")
  
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
