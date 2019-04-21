/**
 * @ClassName: IntelFactory
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午6:58
 * @Version 1.0
 **/

public class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu(555);
    }

    @Override
    public MainBoard createMainBoard() {
        return new IntelMainBoard(555);
    }
}
