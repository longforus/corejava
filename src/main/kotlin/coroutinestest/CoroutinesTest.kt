package coroutinestest

import kotlinx.coroutines.*

/**
 * @describe
 * @author  longforus
 * @date 11/21/2018  10:56 AM
 */
suspend fun fun1(): String {
    println("fun1" + Thread.currentThread())
    delay(1000)
    return "123123"
}


suspend fun fun2(str: String): Long {
    println("fun2" + Thread.currentThread())
    delay(1000)
    return str.toLong()
}


fun fun3(long: Long) {
    println("fun3" + Thread.currentThread())
    println(long)
}


fun main1(args: Array<String>) {

    var flag = true
    //rxJava
//    Single.fromCallable {
//        fun1()
//    }.map {
//        fun2(it)
//    }.subscribeOn(Schedulers.io()).subscribe { t: Long ->
//        fun3(t)
//        flag = false
//    }


    val job = GlobalScope.launch {
        val v1 = fun1()
        val v2 = fun2(v1)
        fun3(v2)
        flag = false
    }

    while (flag) {
        Thread.sleep(1_00)
    }
    println("finish")
}

fun main() = runBlocking {
    val job = launch {
        val v1 = fun1()
        val v2 = fun2(v1)
        fun3(v2)
    }
    println("finish")
    coroutineScope {
        println("in scope")
    }
    println("over")
}


fun main2() = runBlocking {
    // this: CoroutineScope
    launch {
        val v1 = fun1()
        val v2 = fun2(v1)
        fun3(v2)
    }

//    coroutineScope {
//        // 创建一个新的协程作用域
//        launch {
//            delay(500L)
//            println("Task from nested launch")
//        }
//
//        delay(100L)
//        println("Task from coroutine scope") // 该行将在嵌套启动之前执行打印
//    }

    println("Coroutine scope is over") // 该行将在嵌套结束之后才会被打印
}