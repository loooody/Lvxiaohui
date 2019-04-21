/**
 * @ClassName: IntelMainBoard
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:51
 * @Version 1.0
 **/

public class IntelMainBoard implements MainBoard {

    private int cpuHeles;

    public IntelMainBoard(int cpuHeles) {
        this.cpuHeles = cpuHeles;
    }

    @Override
    public void installCpu() {
        System.out.println("Intel主板上的CPU：" + cpuHeles);
    }
}
