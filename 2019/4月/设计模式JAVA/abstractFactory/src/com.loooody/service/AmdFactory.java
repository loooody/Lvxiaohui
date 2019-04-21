/**
 * @ClassName: AmdFactory
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:59
 * @Version 1.0
 **/

public class AmdFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new AmdCpu(8888);
    }

    @Override
    public MainBoard createMainBoard() {
        return new AmdMainboard(8888);
    }
}
