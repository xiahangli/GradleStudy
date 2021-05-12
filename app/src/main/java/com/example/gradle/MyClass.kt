package com.example.gradle

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Henry
 *@Date 2021/1/31  8:48 PM
 *@Email 2427417167@qq.com
 */

//typealias  NodeSet = MutableSet<MyClas.Node>

//class MyClas {
//    class Node {
//        var string = "xxx"
//    }

//    var myNodeSet: NodeSet = HashSet<MyClas.Node>()
//
//
//    val list = listOf(1, 2, 3, 4, 5)
//    val map = mapOf(1 to "1", 2 to "2")
//    val pluslist = list + 2
//    fun test() {
//        var nod = Node()
////        nod.string = "1"
//        nod = Node()
//        myNodeSet.add(nod)
//        nod.string = "2"
//        myNodeSet.add(nod)
//        println("myNodeSet$myNodeSet")

//        myFunc.invoke()
//        val b = object :IInter{
////            override fun my() {
////                print("my impl")
////            }
//        }
//        b.my()

//        var myInterface :Function0 () -> String ={
//        "String"
//    }
//        myInterface.invoke()
//        var invoke = myInterface()
//        System.out.println(invoke)

//}


/** A function that takes 1 argument. */
public interface Function1<in P1, out R> : Function<R> {
    /** Invokes the function with the specified argument. */
    public fun invoke(p1: P1): R
}

var str: Function0<String> = object : Function0<String> {
    override fun invoke(): String {
        return "x"
    }

}

////注意 fun interface 是新特性
//fun interface Action {
//    fun run()
//}
//
//// Kotlin 函数，参数为 Kotlin 单一方法接口
fun runAction(a: Action) = a.run()

//// Kotlin 函数，参数为 Java 单一方法接口
fun runRunnable(r: Runnable) = r.run()


interface Action {
    fun run();
}


public interface Function0<out R> : Function<R> {
    /** Invokes the function. */
    operator fun invoke(): R
}

fun test1() {
    str.invoke()
    str()

}


interface IInter<out R> {
    operator fun invoke(): R
}


var s = "13"

//    inner class B {
//        fun b() {
////            println(s)
//        }
//    }

//}
//
//interface Listener {
//    fun invoke()
//}

//fun setListener(listener: Listener) {
//
//}

data class Point(val x: Int, val y: Int) {
    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }
}


interface Callback {
   public operator fun invoke()
}

public interface Function01  {
    /** Invokes the function. */
    public operator fun invoke()
}

class AA {
    lateinit var callback: () -> Unit;
    fun setCallback1(callback: () -> Unit) {
        this.callback = callback;
    }

    fun setCallback(callback: Callback) {
        callback.run { }
        var a = """123"""";
        with(a, {
            1
        })
    }

    fun test() {
        callback.invoke()
    }
}

class BB {
    val aa = AA();
    fun test() {

//        aa.setCallback();

        aa.setCallback1({ -> print("hello") })

        aa.setCallback1 { ->
            println()
        }
        aa.test()
    }
}


val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


fun main() {
    BB().test()


    GlobalScope.launch { // launch a new coroutine in background and continue
        val ste = Throwable().stackTrace
        if (ste.size >= 1) {
            for (i in 1 until ste.size) {
                print("File:" + ste[i].fileName + ", Line: " + ste[i].lineNumber + ", MethodName:" + ste[i].methodName);
            }
        }

        print("xia")
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive


//    val myClas = MyClas()
//    myClas.test()
//    val p = Point(1, 2)
//    setListener {
//        print("xxxx")
//    }
//
//
//    sum(1, 2)
//
//    sum.invoke(1, 2)
//
//    var p1 = -p;//炒作父重载
//    println()
}