/**
 * @ClassName: Milk
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-8 上午10:17
 * @Version 1.0
 **/

public class Milk extends Decorator {
    private String description = "加了牛奶";
    private Beverage beverage = null;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    public double getPrice(){
        return beverage.getPrice() + 20;
    }
}
