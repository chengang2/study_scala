package reducefold

object rf {
  
  def main(args: Array[String]): Unit = {
      
      val list1 = List(1,2,3,4)
      //reduce == reduceLeft
      var result = list1.reduceLeft({(m,n)=>{println(m+":"+n);m-n}})
      println(result)//1-2-3-4
      result = list1.reduceRight({(m,n)=>{println(m+":"+n);m-n}})
      println(result)//1-(2-(3-4))

      val list2 = List(1,2,3,4)
      //fold == foldLeft
      result = list2.foldLeft(10){{(m,n)=>{println(m+":"+n);m-n}}}
      println(result) //10-1-2-3-4
      result = list2.foldRight(10){{(m,n)=>{println(m+":"+n);m-n}}}
      println(result) //1-(2-(3-(4-10)))
      
  }
}