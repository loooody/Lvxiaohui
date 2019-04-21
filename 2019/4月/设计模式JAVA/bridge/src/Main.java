public class Main {

    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Impl impl = new Impl1();
        bridge.setImpl(impl);
        bridge.method();

        Impl impl1 = new Impl2();
        bridge.setImpl(impl1);
        bridge.method();
    }
}
