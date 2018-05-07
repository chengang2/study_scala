package collections.map

import scala.collection.JavaConversions._;

object TestMap {
  def main(args: Array[String]): Unit = {
   
      val m1 = Map("a"->1,"b"->2,3->"c")
      //m1 +=("c"-> 3) error
         
      val m2 =scala.collection.mutable.Map("aa"->1,"bb"->2,33->"c")
      m2 +=("c"-> 3)
      m2 ++=m1
      val a = m2("c")
      val b = m2.getOrElse("cc", 0)
      println(b)
      //update/add
      m2("cc") = b
      
      for(m<-m2)
        println(m._1+"="+m._2)
       for(m <-m2.keySet)
         println(m+"="+m2(m))
      //初始化可变map  
      val m3 = scala.collection.mutable.Map[String,Int]()
      
      //java map与scala map隐式转换
      import scala.collection.JavaConversions.mapAsJavaMap
      val m2c1:java.util.Map[String,Int] = Map("a"->1,"b"->2,"c"->3)
      println(m2c1.get("a"))
      import scala.collection.JavaConversions.mapAsScalaMap
      val m2c2 = m2c1
    
      
  }
}