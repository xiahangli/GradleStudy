package com.example.gradle

import android.app.Activity
import android.app.Fragment
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import com.example.gradle.Dependency.DependencyKey
import com.example.gradle.Dependency.TIME_TICK_HANDLER
import com.example.gradle.twitter.MyFragment
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class MainActivity : Activity() {


    override fun finish() {
        super.finish()
    }
    var fragment: Fragment = MyFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val myClass1 = MyClass1()
       BitmapDrawable().setColorFilter( ColorMatrixColorFilter(ColorMatrix().apply {
            setSaturation(10f);
        }));

        val tv = TextView(this)
        tv.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
//        tv.layoutParams.apply {
//            width = 100
//            height = 100
//        }

//        ObjectAnimator.ofFloat(tv,"translationX",100.0f,10.0f).setDuration(10000).start()


        var dependency = Dependency()
        dependency.start()
//        var get = Dependency.get(TIME_TICK_HANDLER)
        var get1 = Dependency.get(SomethingController::class.java)


        var transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment)
        transaction.commitAllowingStateLoss()

//        myClass1.a(1)
//        myClass1.init()
//        ;
//        val string: Bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888).applyCanvas {
////            drawArc()
////            drawARGB()
////            drawBitmap()
//            it.drawBitmap(
//                BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background),
//                Rect(1, 2, 2, 2), Rect(1, 1, 2, 2), null
//            )
//
//        }


    }

    var a: Long = 0L
    var SOME_FLAG: Long = 0x00001

    fun setFlag(a: Int) {
//        a.xor(SOME_FLAG)
//        a = a.xor(SOME_FLAG)
    }
}


inline fun ordinaryFunction(block: () -> Unit) {
    println("hi!")
}

fun foo() {
    ordinaryFunction {
        return // ERROR: cannot make `foo` return here
    }

}

class MySubClass : MyClass(), IMyClassInterface {
    override var string = "123344"

    override fun inter() {
        println("xafdsafsdf")
        super<IMyClassInterface>.inter()
        super<MyClass>.inter()
//        super.inter()
    }
}


open class A {
    open fun f(s: String) {
        print("a$s")
    }
}

class B : A() {
    override fun f(s: String) {
        print("b")
        super.f(s)
    }
}

fun test() {
    val b = B()
    b.f("ssss")
    println()
}

interface IMyClassInterface {
    fun inter() {
        println("xxxxxxx")
    }
}

open class MyClass {
    open var string: String = "123"
//        private set

    open fun inter() {
        println("ddssddd")

    }

    fun myString(): String {
        println("hello")
        return "hell"
    }

    companion object {
        const val a = "sddd"
    }
}

fun main() {
    foo()
    var a = MyClass.a
    var myString = MyClass()
    println(myString.string)
    var mySubClass = MySubClass()
    var mySbuclassString = mySubClass.string

    print("a$a")
    lock(ReentrantLock(), ::toBeSynchronized)
    val myClass = MyClass()

//    myClass.string = "12"
//    println(myClass.string)
    var myMap: MutableMap<String, String> = HashMap<String, String>()
    myMap["12"] = "123"
//    myMap["1"]="12"
//    myMap = map
    var setMap = HashMap<String, String>()
    setMap["12"] = "1231"
    map = setMap
    myMap = map as HashMap<String, String>
    println()

}

var backingField: Int = 23
    get() = 12
    set(v) = if (v > 0) field = v else field = -1


var _map: Map<String, String>? = null
var map: MutableMap<String, String>? = null
    get() = field
    //    {
//      if (_map ==null) _map =   HashMap<String,String>()
//        return _map
//    }
    set(value) {
        field = value
    }


fun toBeSynchronized() = MyClass::myString


inline fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}


open class TreeNode {
    var parent: TreeNode? = null
    var treeNode: TreeNode? = null

    fun <T> TreeNode.fund(claz: Class<T>): T {
        var p = parent;
        while (p != null && claz.isInstance(p)) {
            p = p.parent
        }
        @Suppress("UNCHECKED_CAST")
        return p as T
    }

    //must with inline when you use reified
    inline fun <reified T> TreeNode.fund1(): T? {
        var p = parent
        while (p != null && p !is T) {
            p = p.parent
        }
        return p as T?
    }

    inline fun <reified T> membersOf() = T::class.members

    var foo: Foo
        inline get() = Foo()
        inline set(value) {
            setLine(value)
//            field = value
        }

    var setterVisibility: String = "abc"
        private set

    fun setLine(foo: Foo) {
        print("set Line")
        this.foo = foo
    }


    class Foo {
        var string: String? = null

//        fun setLine(){
//
//        }
    }

    inline fun <reified T> member1() = T::class.members
    fun test() {
        TreeNode().membersOf<String>()
        treeNode?.fund(TreeNode::class.java)
        treeNode?.fund1<MyTreeNode>()
    }

    class MyTreeNode : TreeNode {
        constructor() {
            print("myTreeNode")
        }
    }
}

inline fun Bitmap.applyCanvas(drawCanvas: (Canvas) -> Unit): Bitmap {
    val canvas = Canvas(this)
    drawCanvas(canvas)
    return this
}

