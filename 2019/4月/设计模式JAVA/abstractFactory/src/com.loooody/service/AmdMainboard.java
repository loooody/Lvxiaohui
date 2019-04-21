/**
 * @ClassName: AmdMainboard
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:55
 * @Version 1.0
 **/

public class AmdMainboard implements MainBoard {

    private int cpuHoles;

    public AmdMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCpu() {
        System.out.println("AMD主板上的CPU：" + cpuHoles);
    }
}
