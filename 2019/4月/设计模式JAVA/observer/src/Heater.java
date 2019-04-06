/**
 * @ClassName: Heater
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-5 下午11:53
 * @Version 1.0
 **/

public class Heater extends Subject {

    private int temperature;

    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void boilWater(){
        for (int i = 95; i < 105; i++) {
            temperature = i;
            this.setTemperature(temperature);
            this.notigyAllObserver(Integer.toString(temperature));
        }
    }
}
