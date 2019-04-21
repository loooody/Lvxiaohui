/**
 * @ClassName: IntelCpu
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:46
 * @Version 1.0
 **/

public class IntelCpu implements Cpu {

    private int pins;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Intel CPU的脚针数目：" + pins);
    }
}
