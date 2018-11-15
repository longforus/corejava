package annotationDemo

/**
 * Created by XQ Yang on 2018/4/19  19:39.
 * Description :
 */


class TestAnnotation{
    @MethodInfo("longforus","2018-4-19 19:41:06",2)
    fun getInfo() = "this fun return info"

}

fun main(args:Array<String>){
    val kClass = TestAnnotation::class
    kClass.java.methods.forEach {
        val annotation = it.getAnnotation(MethodInfo::class.java)

        annotation?.apply {
            println(author)
            println(date)
            println(version)
        }

        annotation?.let {
            println(it.author)
            println(it.date)
            println(it.version)
        }

    }
}