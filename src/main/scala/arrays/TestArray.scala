package arrays

import scala.collection.mutable.ArrayBuffer

object TestArray {
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)
    val s = Array("hello","scala")
    for(i <- s)
        println(i)
    for(i <- 0 to s.length-1) //for(i <- 0 until s.length)
      println(s(i))
      
    //变长数组:数组缓冲
    val b = new ArrayBuffer[Int]
    b.append(1)
    b.append(2)
    b += 3
    b ++= Array(4,5,6)
    //b.trimEnd(4)//移除最后4个元素  1,2
    //b.trimStart(4)//移除最开始的4个元素 5，6
    b.insert(4,7,8,9)//在index=4的地方插入7，8，9
    b.remove(5) //删除第5个元素
    b.remove(2, 3)// 从index=2开始，删除3个元素
    for(i <- b)
       println(i)
    val c = b.toArray //构建变长数据
    val d = c.toBuffer 
    
    val a = Array(1,2,3,4,5)
    
    //result是新的集合Array（4，8），a不变
    val result = for(j<- a if j%2==0) yield 2 * j
    println(result.mkString("<",",",">"))
    
    //只会取最少元素个数
    val r = a.zip(s)
    r.foreach(x=>println(x._1+"--"+x._2))
    val m = r.toMap
    m.foreach(x=>println(x._1+"--"+x._2))
  }
}