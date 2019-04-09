/**
 * @ClassName: Decorator
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-8 上午10:14
 * @Version 1.0
 **/

public class Decorator implements Beverage {
    private String description = "我只是装饰类，不知道具体的描述";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
