/**
 * @ClassName: MyBridge
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午7:43
 * @Version 1.0
 **/

public class MyBridge extends Bridge {

    @Override
    public void method() {
        getImpl().method();
    }
}
