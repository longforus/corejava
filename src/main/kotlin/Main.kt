import java.util.concurrent.TimeUnit

/**
 * Created by XQ Yang on 2018/1/24  20:21.
 * Description :
 */

fun main(args: Array<String>) {
//    val ints = arrayOf(1, 2, 3, 4)
//    println(ints.size)
//    val copyArray = TestCopy.copyArray(ints, 8) as Array<Int>
//    for (i in copyArray) {
//        println(i)
//    }
//    println(copyArray.size)
//    copyArray[7] = 9999
//    println(copyArray[7])

//    val person = Person()
//    println(person::getName)
//    println("one "+System.currentTimeMillis())
//    var msg = "hello"
//    TestCopy.repeat(msg,1000)
//    msg = "world"
//    println("two"+System.currentTimeMillis())
//    Thread.sleep(2000)
//    println("end "+System.currentTimeMillis())
//    Arrays.sort(arrayOf(Person()),Comparator.comparing (Person::getName).thenComparing(Person::getName))


//    var msg = "hello"
//    TestCopy.repeat(msg,1000)
//    val map = HashMap<String, Int>()
//    println(map.merge("aa",1,Integer::sum))
//    println(map["aa"])
//    println(map.merge("aa",1,Integer::sum))
//    println(map["aa"])


    var moonRunner = MoonRunner()
    val thread = Thread(moonRunner, "moon")
    thread.start()
    TimeUnit.MILLISECONDS.sleep(10)
    thread.interrupt()

}

class MoonRunner : Runnable {
    var on = true
    override fun run() {
        var i = 0
        while (!Thread.currentThread().isInterrupted) {
            println(i++)
        }
        println("stop")
    }
}
