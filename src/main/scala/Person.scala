package com.onemt


class Person{
   var xx = 10 
  
  {
    println("我是伴生类中代码块")
  }
  def toadd(x:Int,y:Int)={
    Person.add(x,y)
  }
  def add(x:Int,y:Int)={
    println(x-y)
  }
  
}



object Person {
  var x= 3
  val y =5
  
//  def x()={
//    println("1111")
//  }  
  {
     println("我是伴生对象中静态代码块") 
  }
  def add(x:Int,y:Int)={
    println(x+y)
  }
  def plus(x:Int,y:Float)={
    x + y*2
  }
  //偏函数
  val getStudentGrade: PartialFunction[String, Int] = { 
	    case "Leo" => 90; case "Jack" => 85; case "Marry" => 95 
  }
  
  def main(args: Array[String]): Unit = {

    val p = new Person()
    println("........................"+p.xx)
    p.toadd(x, y)
    println(p.xx)
//    p.xx=20
    println(p.xx)
    add(x,y)
    println(plus(1,2.1f))
    println(getStudentGrade("Jack"))
  }
}
object Personss extends App{
  val x= 3
  val y =5
    
  {
     println("我是伴生对象中静态代码块ss") 
  }
  def add(x:Int,y:Int)={
    println(x+y)
  }
  val p = new Person()
  println("........................")
  p.toadd(x, y)
//  def main(args: Array[String]): Unit = {
//
//    val p = new Person()
//    println("........................")
//    p.toadd(x, y)
//    add(x,y)
//    
//  }
  val acc = new MyAccount with messagerLogger
  acc.save()
}
  trait Logger{
    def log(msg :String)
  }
  trait ConsoleLogger extends Logger{
    def log(msg:String){
      println("save money:"+msg)
    }
  }
  trait messagerLogger extends ConsoleLogger{
    override def log(msg:String){
      println("save money to bank:"+msg)
    }
  }
  abstract class Account{
    def save
  }
  class MyAccount extends Account with ConsoleLogger{
    def save(){
      log("100")
    }
  }
  




