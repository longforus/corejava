/**
 * Created by XQ Yang on 2018/1/25  19:39.
 * Description :
 */

class Person implements IPerson,INamed {
    @Override
    public String getName() {
        return INamed.super.getName();//实现的接口中拥有签名的方法时,需要显式指定调用父类的方法
    }
}
