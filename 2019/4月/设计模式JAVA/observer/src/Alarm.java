/**
 * @ClassName: Alarm
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-6 上午12:02
 * @Version 1.0
 **/

public class Alarm implements Observer {

    private String observerState;

    public void update(String state) {
        Boolean flag = Boolean.parseBoolean(state);
        if (flag) {
            System.out.println("报警器响声了，水温超过100度了");
        }
    }

}
