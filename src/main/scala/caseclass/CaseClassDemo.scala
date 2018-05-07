package com.onemt

import java.util.Date
import java.text.SimpleDateFormat

object CaseClassDemo extends App{
  abstract class Person
  case class Teacher(name:String) extends Person
  case class Student(age:Int) extends Person
  def macthfun(m:Person){
    m match {
      case Teacher("aa") => println("This is a teacher")
      case Student(_) => {println("This is a student")}
      case _ => println("This is a unknown")
    }
  }
  
  macthfun(Teacher("AA"))
  
  def mulBy(a:Double) = (b:Double) => a*b
  
  println(mulBy(2.0)(3.0))
 
}

class Student{
  private var myName = " leo"
  def name = myName
  def name_= (newName:String){
    myName=newName
    println("my name is "+newName)
  }
}

object Student extends App{
  def apply()=new Student
  val s = Student()
  println(s.name)
  
  s.name="aaa";
  println(s.name)
  val now = new Date()
val dateFormat = new SimpleDateFormat("yyyyMMddHH")
val runtime = dateFormat.format(now)
  
//  s.name_=("jack")
//  println(s.name)
}

