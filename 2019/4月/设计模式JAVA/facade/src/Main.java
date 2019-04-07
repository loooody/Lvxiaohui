public class Main {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.register();
        facade.treament();
        facade.payment();
        facade.getDrugs();
    }
}
