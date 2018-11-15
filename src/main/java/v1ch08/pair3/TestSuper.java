package v1ch08.pair3;

/**
 * Created by XQ Yang on 2018/5/3  19:40.
 * Description :
 */

class TestSuper extends Manager {
    /**
     * @param name the employee's name
     * @param salary the salary
     * @param year the hire year
     * @param month the hire month
     * @param day the hire day
     */
    public TestSuper(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
}
