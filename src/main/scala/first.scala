package com.onemt

import scala.collection.immutable.Map
import scala.collection.immutable.Set
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import scala.collection.mutable.ArrayBuffer

object first {
  
  def maxs(a:Int,b:Int)={
    a+b
  }
  def sign(m:Int)={
   val c =  m match{
      case 0 => "男"
      case 1 => "女"
      case _ => "未知"
    }
   c
  }
  
  def main(args: Array[String]): Unit = {
    
    val a = for(i <- 1 to 10) yield i*2
    for(i <- a){
      println(i)
      val b = ""
    }

val nums=List(1,2,3,4,5)
var result=false
for(i <- 0 until nums.size if !result){
  if(i==2){
  }
  println(nums(i))
}

for(i <- nums){
  println(i)
}
    val l = maxs(2,4)
    println(l)
   
    println(sign(3))
//数组    
    val A = new Array[Int](10)
    A(7) = 57
    A(9) = 1
    val B = A.toBuffer
    println(B)
    B.remove(2, 2)
    for(i <- 1 to (B.length,2))
      println(B(i))
//map
    var Z = Map("a1" -> "b1", "a2" -> "b2") // 不可变map，key对应的value不能改变
    var M = scala.collection.mutable.Map(("a3","b3"),("a4","b4")) //可变map
    Z=Z.++:(M) //新增map
    Z+=(("a5","b5")) //新增元素
    println(Z)
    println(Z.getOrElse("a5","a5"))
    //Z("a6")="b6"//因为Z是不可变map
    M("a3")="b6" //如果key存在，则更新对应的value，如果key不存在，则新增元素
    println(M)
    println(Z)
    Z-="a5" //删除某个元素，只需要删除元素对应的key
    for((i,j) <- Z)
      println("key=="+i+"--value=="+j)
    println(Z)
//tuple
    var g = (1,1.2,"A")
    println(g._2)
  val site: List[String] = List("Runoob", "Google", "Baidu")
  site.+:("aa")
  for(str <- site){
    println(str)
  }
  }
 
}



class Persons(){
  {
    println("我是伴生类中代码块")
  }
  def toadd(x:Int,y:Int)={
    Persons.add(x,y)
  }
  
}



object Persons {
  val x= 3
  val y =5
  
  {
     println("我是伴生对象中静态代码块") 
  }
  
  def add(x:Int,y:Int)={
    println(x+y)
  }
  
  def main(args: Array[String]): Unit = {

    val p = new Persons()
    println("........................")
    p.toadd(x, y)
    add(x,y)
  }
}


object classfirst extends App{
  i:Int => {println("hello world")}
  def adder(m:Int,n:Int)=m+n
  def adder2(m:Int)(n:Int)=m+n
  val add = adder(_:Int,4)
  val add2 = adder2(3) _
  val a = add(4)
  val b = adder(3,2)
  val c = add2(4)
  println(a)
  println(b)
  println(c)
  
}

class Marker private(val color:String) {

  println("创建" + this)
  
  override def toString(): String = "颜色标记："+ color
  
}
object Marker{
  
    private val markers: Map[String, Marker] = Map(
      "red" -> new Marker("red"),
      "blue" -> new Marker("blue"),
      "green" -> new Marker("green")
    )
    println("......................")
    def apply(color:String) = {
     
      if(markers.contains(color)) markers(color) else null
    }
  
    
    def getMarker(color:String) = { 
      if(markers.contains(color)) markers(color) else null
    }
    def main(args: Array[String]) { 
        println(Marker("red"))  
        // 单例函数调用，省略了.(点)符号  
		    println(Marker getMarker "blue")  
    }
}
object ss extends App{
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + 1
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }
  
  println(bigger(0))
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  var a =numbers.partition { x => (x%2==0) }
  println(a)
  var b = numbers.find (x => x>5)//返回集合中第一个匹配谓词函数的元素
  println(b)
  var c = numbers.drop(5)//将删除前i个元素
  println(c)
  var d = numbers.dropWhile { x => x%2!=0 }//将删除元素直到找到第一个匹配谓词函数的元素
  println(d)
  var e = numbers.foldLeft(2){(m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }
  println(e)
  
}

class Publication(val title :String)

class Book(title:String) extends Publication(title)

object Library{
  val books :Set[Book]=Set(new Book("Programming in Scala"),new Book("walden"))
  
  def printBookList(info:Book => AnyRef){
    assert(info.isInstanceOf[Function1[_,_]])
    for(book <- books){
      println(info(book))
    }
  }

  def printBokkListByTrait[P >: Book, R <: AnyRef](
    action: GetInfoAction[P, R]) {
    //打印  
    for (book <- books)
      println(action(book))
  }  
}
trait GetInfoAction[P >: Book, R <: AnyRef] {  
    //取得图书内容的文本描述，对应（）操作符  
   def apply(book : P) : R  
} 

//单例对象，文件的主程序  
object Customer extends App {  
 implicit def float2Int(x:Float)=x.toInt
 val y:Int =123.8F
 println(y)
  
  
    //定义取得出版物标题的函数  
    def getTitle(p: Publication): String = p.title  
    //使用函数来打印  
    Library.printBookList(getTitle)  
  
    //使用特征GetInfoAction的实例来打印  
    Library.printBokkListByTrait(new GetInfoAction[Publication, String] { def apply(p: Publication) : String = p.title })  
} 

class MetworkService(port:Int, poolSize:Int) extends Runnable {
  val serversocket = new  ServerSocket(port)
  val pool: ExecutorService = Executors.newFixedThreadPool(poolSize)
  def run(): Unit = {
    try {
      while (true) {
        val socket = serversocket.accept()
        //new Thread((new Handler(socket))).start()
        pool.execute(new Handler(socket))
      }
    }finally{
      pool.shutdown()
    }

  }
}
class Handler(socket:Socket) extends Runnable {
  
  def run(): Unit = {
    val message = socket.getInputStream.read()
    println("message==="+message)
    socket.getOutputStream.close()
  }
}

class MetworkSocket(port:Int) extends Runnable {
  val socket = new Socket("localhost",port)
  def message = (Thread.currentThread().getName+"\n").getBytes
  def run(): Unit = {

    socket.getOutputStream.write(message)
    socket.getOutputStream.close()
  }
  
}

object objectss extends App{

  def apply() = new MetworkService(2020,2)
  
  new Thread(objectss()).start()
  
}
object sss extends App{
  def apply() = new MetworkSocket(2020)
  
  new Thread(sss()).start()
}



class Personsss(var name :String){
   def set(changeName :String){
     synchronized{
        name = changeName
     }
   }
   
}

object classs extends App{
  var f3 =(a:Int)=>a*2
  def mul(a:Int)=(b:Int)=> b*a
  f3=mul(2)
  println(f3(3))
  def sum4(f:Int=>Int)(a:Int,b:Int): Int={
   (if(a>b) 0 else f(a)+sum4(f)(a+1,b))
    
  }
  val f4=sum4(f3)(7,12)
  println(f4)
}



object TestClient extends App {    
    val queue1 = (new BasicIntQueue with Incrementing with Doubling)
    queue1.put(2) //Doubling.put(2*2)->Incrementing.put(4+1)
    println(queue1.get()) //result is 5
    
    val queue2 = (new BasicIntQueue with Doubling with Incrementing)
    queue2.put(2) //Incrementing.put(2+1)->Doubling.put(2*3)
    println(queue2.get()) //result is 6
}

abstract class IntQueue {
    def get(): Int
    def put(x: Int)
}

class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) { buf += x }
}

trait Incrementing extends IntQueue {
    abstract override def put(x: Int) {
        super.put(x + 1)
    }
}

trait Doubling extends IntQueue {
    abstract override def put(x: Int) {
        super.put(2 * x)
    }
}

