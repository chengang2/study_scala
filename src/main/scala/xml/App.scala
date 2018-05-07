package xml

/**
 * @author cg
 */

import scala.xml._
object App {

  def main(args : Array[String]) : Unit ={
    val person = <person id="person1" name="username"><name>chengang</name><age>18</age></person>
    println(person)
    val labels = person.label //person
    val texts = person.text//chengang18
    val name = (person \"name").text //chengang
    val childs = person.child
    for(child <- childs){
      println(child.label+"--"+child.text)
    }
    val attr = person.attributes
    println(attr.asAttrMap) //Map(id -> person1, name -> username)
    println(person \"@id") //person1
    
  }

}

class Person(val name :String,val age :Int){
  //序列化
  def toXML()={
    <person id={age.toString()}>
       <name>{name}</name>
       <age>{age}</age>
    </person>
  }
  //反序列化
  def fromXML(xml:scala.xml.Elem)={
    new Person((xml \"name").text,(xml \"age").text.toInt)
  }
}
object xmlserialization extends App{
  
  val p = new Person("chengang",20)
  val xml = p.toXML()
  println(xml)
  val person = p.fromXML(xml)
  println(person)
  //XML.save("C:\\Users\\Administrator\\Desktop\\xmltest.xml", xml, "utf-8", true, null)
  val x = XML.loadFile("C:\\Users\\Administrator\\Desktop\\xmltest.xml")
  println(x)
  
  val getChild: Node => Unit = rootNode => for (node <- rootNode.child)
        node match {

            //如果只需要节点文本，可以将表达式嵌在匹配语句中
            case <node1>{ text }</node1> => println("Node1 text: " + text)

            //支持多级标签匹配
            case <node><node2>{ text }</node2></node> => println("Case node_node2: " + text)

            //如果需要整个节点的内容，需要使用@符号
            case n @ <node2>{ _ }</node2> => println("Node2 text: " + n.text)

            //使用attribute()或者attributes()方法获取节点的属性
            case n @ <node3>{ _ }</node3> => println("Node3 attribute: " + n.attribute("arg").get)
            case n @ <node4>{ _ }</node4> => println("Node4 attribute: " + n.attributes("arg"))

            //匹配其它类型节点，也可以写成 case _ if node.child.length > 0 => ...
            case _ if node.child != null => getChild(node)
        }
  
  getChild(x)
  
}


