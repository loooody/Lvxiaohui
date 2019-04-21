public class Main {

    public static void main(String[] args) {
        ComputerEngineer computerEngineer = new ComputerEngineer();
        AbstractFactory intelFactor = new IntelFactory();
        computerEngineer.makeComputer(intelFactor);
    }
}
