/**
 * @ClassName: ComputerEngineer
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午7:01
 * @Version 1.0
 **/

public class ComputerEngineer {

    private Cpu cpu = null;

    private MainBoard mainBoard = null;

    public void makeComputer(AbstractFactory abstractFactory) {
        this.prepareHardWare(abstractFactory);
    }

    private void prepareHardWare(AbstractFactory af) {
        this.cpu = af.createCpu();
        this.mainBoard = af.createMainBoard();
        this.cpu.calculate();
        this.mainBoard.installCpu();
    }

}
