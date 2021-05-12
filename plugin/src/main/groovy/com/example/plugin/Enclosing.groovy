package com.example.plugin

class Enclosing{
    void run() {
        println("xxxdddddx")
        def whatIsThisObject = { getThisObject() }
        assert whatIsThisObject() == this
        def whatIsThis = { this }
        assert whatIsThis() == this.metaClass
    }
}