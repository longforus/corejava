import java.awt.event.ActionListener;
import java.lang.reflect.Array;

/**
 * Created by XQ Yang on 2018/1/24  20:14.
 * Description :
 */

class TestCopy {
    /**
     * @param obj 要扩张的数组
     * @param newLength 新数组的长度
     * @return 已扩张的数组, 大小为obj.lenght()和newLength的最小者
     */
    @SuppressWarnings("SuspiciousSystemArraycopy")
    public static Object copyArray(Object obj, int newLength) {
        Class<?> objClass = obj.getClass();
        if (!objClass.isArray()) {
            return null;
        }
        Class<?> componentType = objClass.getComponentType();
        int length = Array.getLength(obj);
        Object instance = Array.newInstance(componentType, newLength);
        System.arraycopy(obj, 0, instance, 0, Math.min(length, newLength));
        return instance;
    }

    public static void repeat(String msg, int delay) {
        class PartClassTest {
            private void test() {
                System.out.println("part class test " + msg);
            }
        }
        PartClassTest partClassTest = new PartClassTest();
        partClassTest.test();
        ActionListener listener = e -> {
            System.out.println(msg + System.currentTimeMillis());
        };

        new javax.swing.Timer(delay, listener).start();
        //Runnable runnable = () -> {
        //    System.out.println(msg);
        //};
        //new Thread(runnable).start();

    }

    public static void testArraylist(java.util.List<String> list) {
            list.forEach(System.out:: println);
    }

    public static void main(String[] args){
        //testArraylist(new ArrayList<String>() {{
        //    add("123");
        //    add("456");
        //}});
        Object strArr = Array.newInstance(String.class, 20);
        System.out.println(Array.getLength(strArr));
        System.out.println(strArr.getClass().getComponentType());


    }
}
