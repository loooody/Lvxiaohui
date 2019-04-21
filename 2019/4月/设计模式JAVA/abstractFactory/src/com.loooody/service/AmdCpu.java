/**
 * @ClassName: AmdCpu
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:48
 * @Version 1.0
 **/

public class AmdCpu implements Cpu {

    private int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("Amd CPU的脚针数目：" + pins);
    }
}
