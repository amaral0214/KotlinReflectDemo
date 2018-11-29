package com.zjnh.kotlin

@PoKo
data class Person(val name:String, val age:Int)

class DefaultConstructor()

fun main(args: Array<String>){
    val clazz=Person::class.java
    val person=Person("benny",18)
    val clazz2=person.javaClass
    val claz3=person::class.java

    val defaultConstructor=DefaultConstructor::class.java.newInstance()
    val person1=clazz2.newInstance()//默认调用无参构造方法
    val person2=clazz2.getConstructor(String::class.java,Int::class.java).newInstance("benny",18)
    val name=clazz2.getDeclaredField("name").apply { isAccessible=true }.get(person2)
    clazz2.getDeclaredField("name").apply { isAccessible=true }.set(person2,"Andy")
    val name2=clazz2.getDeclaredMethod("getName").apply { isAccessible=true }.invoke(person2)
    val person3=clazz2.getDeclaredMethod("copy",String::class.java,Int::class.java).invoke(person2,person2.name,person2.age)
    println(person3)
}