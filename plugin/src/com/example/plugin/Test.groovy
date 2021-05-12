package com.example.plugin

class Test {
    static main(args){
        println("xxx12")
        Enclosing enclosing =  new Enclosing()
        enclosing.run()

        def a = [1, 2, 3]
        a += 4      // creates a new list and assigns it to `a`
        print()
    }
}