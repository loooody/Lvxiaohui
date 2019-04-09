/**
 * @ClassName: Milk
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-8 上午10:17
 * @Version 1.0
 **/

public class Soy extends Decorator {
    private String description = "加了豆浆";
    private Beverage beverage = null;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "\n" + description;
    }

    public double getPrice(){
        return beverage.getPrice() + 30;
    }
}
