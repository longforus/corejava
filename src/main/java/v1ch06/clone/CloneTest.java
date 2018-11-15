package v1ch06.clone;

import java.util.function.BiFunction;

/**
 * This program demonstrates cloning.
 *
 * @author Cay Horstmann
 * @version 1.10 2002-07-01
 */
public class CloneTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int a = 123;
            int b = 234;
            System.out.println(Thread.currentThread().getName());
            System.out.println(a + b);
        };

        runnable.run();
        BiFunction<String, Integer, Double> function = (s, i) -> Double.valueOf(s + i);

        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}