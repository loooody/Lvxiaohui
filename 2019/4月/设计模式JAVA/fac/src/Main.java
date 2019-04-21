public class Main {

    public static void main(String[] args) {

        CreateFactoryA createFactoryA = new CreateFactoryA();
        Iwork iwork = createFactoryA.createWork();
        iwork.dWork();

        CreateFactoryB createFactoryB = new CreateFactoryB();
        Iwork iwork1 = createFactoryB.createWork();
        iwork1.dWork();

    }
}
