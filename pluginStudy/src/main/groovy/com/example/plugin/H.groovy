def a = 12
println a
//
//使用groovyc编译所有的*.groovy为java的*.class文件，把这些*.class文件放在java类路径中，通过java类加载器来加载这些类。
//
//  通过groovy的类加载器在运行时直接加载*.groovy文件并且生成对象，在这种方式下，没有生成任何*.class
// ，但是生成了一个java.lang.Class对象的实例，也
// 就是说，当groovy代码中包括一个new MyClass()的表达式时，
// 并且也有一个MyClass.groovy的文件，这个文件将被解释，
// 一个MyClass的类型将被产生并且增加到类加载器中
// jav，在代码中将像从*.class一样获取到MyClass对象。
//————————————————
//版权声明：本文为CSDN博主「iteye_7617」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/iteye_7617/article/details/82474191