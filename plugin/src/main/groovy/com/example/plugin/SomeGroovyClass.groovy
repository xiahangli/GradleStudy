package com.example.plugin;


//def var = {
//    println "Hello Groovy"
//}()

class A{

    String name ;
//    int age;
 def pretty={
//    Closure.TO_SELF
    println("myname is $name")
}
    def String toString(){
        pretty()
    }
  /*  def script = {
        println owner
        println this
        println delegate
    }
    static def method1(){
        def closure = {
//            println owner
//            println this
//            println delegate
        }
        closure()
//        closure.call()
    }
    def method2(){
        def outterClosure={
            def closure = {
                println owner
                println this
                println delegate
            }
            closure()
        }
        outterClosure()

    }*/
}
class SuperA {
    String name;
}

println "============================"
/*
A a =  new A(name: "xiahangli")
SuperA superA = new SuperA(name: "yangjingjing")
//delegate of closure
a.pretty.delegate = superA
a.pretty.resolveStrategy = Closure.TO_SELF
println a.toString()
*/

//new A().script()

class Children {
    String name
    def pretty = {
        String name="pretty" //Closure.TO_SELF
        "My name is $name"
    }

    String toString() {
        pretty.call()
    }
}

def children = new Children(name: 'Groovy')

class Parent {
    String name
}

def parent = new Parent(name: 'Gradle')
//将parent委托给children
children.pretty.delegate = parent
//闭包委托策略
children.pretty.resolveStrategy = Closure.TO_SELF//到闭包内部去找属性
println children.toString()




//class SomeGroovyClass {
//
//    def invokeMethod(String name, Object args) {
//        return "called invokeMethod $name $args"
//    }
//
//    def test() {
//        return 'method exists'
//    }
//
//    public static void main(String[] args) {
//        println("xxxxx")
//
////        def someGroovyClass = new SomeGroovyClass()
////
////        assert someGroovyClass.test() == 'method exists1'
////        assert someGroovyClass.someMethod() == 'called invokeMethod someMethod []'
//    }
//}



//def someGroovyClass = new SomeGroovyClass()
//
//assert someGroovyClass.test() == 'method exists'
//assert someGroovyClass.someMethod() == 'called invokeMethod someMethod []'