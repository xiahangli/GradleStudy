package com.example.plugin

class Test {
    static main(args){
        println("xxx1111111111")
        def a = ["1","11","1111","111"]
        a+="111111"
        a+="11111"
//     assert a.sort({
//            it.size()
//        }) == ['1','11','111','1111','11111','111111nnnnn']

//        print()
        def map = [:]

        map."an identifier with a space and double quotes" = "ALLOWED"

        map.'with-dash-signs-and-single-quotes' = "ALLOWED"

        assert map."an identifier with a space and double quotes" == "ALLOWED"
        assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"
//map.get
        def firstname = "Homer"
        map."Simpson-${firstname}" = "Homer Simpson"
//        cars.collect{ it.make }
        assert map.'Simpson-Homer' == "Homer Simpson"
        println()
    }
}