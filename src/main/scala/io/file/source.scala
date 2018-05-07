package io.file

import scala.io.Source

object source {
  def main(args: Array[String]): Unit = {
    //val url = Source.fromURL("https://blog.csdn.net/yyywyr/article/details/50224561","UTF-8")
    val source = Source.fromFile("C:\\Users\\Administrator\\Desktop\\new9.txt","UTF-8")
//    val reader = source.bufferedReader()
//    var line = reader.readLine()
//    while(line != null){
//       
//      println(line)
//      line = reader.readLine()
//    }
    
//    val lineIterator = source.getLines()
//    for(line <- lineIterator){
//      println(line)
//    }
    //一个文本变成一个字符串
//    val sources = source.mkString
//    println(sources)
   
    //读取字符
    val iter = source.buffered
    
    while(iter.hasNext){
      println(iter.next())
    }
    
     source.close()
  }
}