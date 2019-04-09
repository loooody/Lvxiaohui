public class Main {

    public static void main(String[] args) {

        Beverage coffeeBean1 = new CoffeeBean1();
        coffeeBean1 = new Milk(coffeeBean1);
        coffeeBean1 = new Soy(coffeeBean1);
        coffeeBean1 = new Mocha(coffeeBean1);
        System.out.println(coffeeBean1.getDescription() + "\n加了摩卡和牛奶的咖啡价格：" + coffeeBean1.getPrice());
    }
}
