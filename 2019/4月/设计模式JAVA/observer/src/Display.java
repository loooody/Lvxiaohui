/**
 * @ClassName: Display
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-5 下午11:57
 * @Version 1.0
 **/

public class Display extends Subject implements Observer {

    private boolean isBoiled = false;
    private int displayTemperature;

    public boolean isBoiled(){
        return isBoiled;
    }

    public void setBoiled(boolean isBoiled) {
        this.isBoiled = isBoiled;
    }

    public void update(String state) {
        displayTemperature = Integer.parseInt(state);
        System.out.println("当前显示器的温度时：" + displayTemperature);
        this.displayTemperature(displayTemperature);
    }

    private void displayTemperature(int temperature) {
        if (temperature > 100) {
            this.setBoiled(true);
            this.notigyAllObserver(Boolean.toString(isBoiled));
        }
    }

}

