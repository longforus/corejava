package annotationDemo

import java.lang.annotation.Inherited

/**
 * Created by XQ Yang on 2018/4/19  19:33.
 * Description :
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Inherited
public annotation class MethodInfo(val author:String ="void",val date:String,val version:Int = 1)