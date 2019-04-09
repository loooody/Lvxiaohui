/**
 * @ClassName: CoffeeBean1
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-8 上午10:09
 * @Version 1.0
 **/

public class CoffeeBean1 implements Beverage {

    private String description = "选了第一种咖啡豆";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 50;
    }
}
