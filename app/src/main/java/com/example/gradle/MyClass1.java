package com.example.gradle;

//import org.jetbrains.annotations.NotNull;
//
//import kotlin.jvm.functions.Function0;
//import kotlin.jvm.functions.Function1;

//import org.jetbrains.annotations.NotNull;
//
//import kotlin.jvm.functions.Function0;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Henry
 * @Date 2021/1/31  9:48 PM
 * @Email 2427417167@qq.com
 */
class MyClass1 {
//    @NotNull
//    private Function0<String> function0;

    void a(int a) {
//        if (a<0){
//            throw  new IllegalArgumentException("exception");
//        }else {
            b();
            System.out.println();
//        }
    }

    void b(){

        try{
            FileInputStream stream = new FileInputStream("xxx");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
      MyClass1 myClass1 = new MyClass1();

        myClass1.a(1);
        myClass1.init();
    }

    interface A{
        void fun();
    }

    public void init(){
        A a = ()->{
            System.out.println("x");
        };
        a.fun();



//        function0 = ()->{
//            return "function1";
//        };
//        function0.invoke();
//        function0();
    }
}
