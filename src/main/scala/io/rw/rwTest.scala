package io.rw

import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter
import scala.io.Source

object rwTest {
  
  //递归获取子目录
  def subdir(dir:File):Iterator[File] = {
    
     val childDirs = dir.listFiles().filter{ x => x.isDirectory() }
     childDirs.toIterator ++ childDirs.toIterator.flatMap { x => subdir(x) }
  }
  
  def main(args: Array[String]): Unit = {
     
      val file = new File("C:\\Users\\Administrator\\Desktop\\new9.txt")
      val out= new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\new10.txt")))
   
      val read = Source.fromFile(file)
      for( lines <- read.getLines()){
        out.write(lines)
        out.newLine()
      }
      out.close()
      read.close()
//      val iteratordirs = subdir(new File("E:\\onemt"))
//      for(dir <- iteratordirs)
//          println(dir)
  }
}