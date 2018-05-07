package collections

import scala.collection.mutable.LinkedList
import scala.collection.mutable.HashSet
import scala.collection.mutable.LinkedHashSet
import scala.collection.mutable.Set

object test {
  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3,4)
    println(list1.head)
    println(list1.tail)
    println(list1.take(2))
    val list2= List(5,6,7,8)
    val list3 = list1 :: list2
    val list4 = list1.:::(list2)
    //    val list4 = list ::: list2
//    val list3 = list.::(list2)
    println(list3)
    println(list4)
    list1.foreach {x=>println("a:"+x)}
    def doforeachList(l:List[Int],prexit:String){
      if(l != Nil){
        println(prexit+l.head)
        doforeachList(l.tail,prexit)
      }
    }
    doforeachList(list1,"aa:")
    
    val l = LinkedList(1,2,3,4,5,6,7,8,9,10)
    var lls=List[Int]()
    var ls=List[Int]()
    var a =1
    l.map( x=>{if(a%2!=0)ls=ls ++ List(2*x) else ls=ls ++ List(x);a=a+1 } )
//    l.foreach { x => {if(a%2!=0) ls=ls ++ List(2*x) 
//                      else ls=ls ++ List(x)
//                      a=a+1 } }
    println("----------------"+ls)
    for(i <- 0 until l.length){
      if(i==0 || i%2==0){
        lls = lls ++ List(l(i)*2)
      }else{
        lls = lls ++ List(l(i))
      }
    }
    println("________________"+lls)
    println(l.elem)
    println(l.next)
    println(l)
    var first = true
    var ll = l
    while(ll!=Nil && ll.next!=Nil){
      if(first){
        ll.elem=ll.elem * 2
        first = false
      }
      ll=ll.next.next
      ll.elem = ll.elem * 2
    }
    println(l)
    
    var s = HashSet[Int]()
    s += 1
    s += 1
    s += 2
    s += 5
    s += 4
    println(s)
    
    var aa = Set[Int]()
    aa += 1
    aa += 1
    aa += 2
    aa += 5
    aa += 4
    println(aa)
    
    var ss = LinkedHashSet[Int]()
    ss += 1
    ss += 1
    ss += 2
    ss += 5
    ss += 4
    println(ss)
    
  }
}