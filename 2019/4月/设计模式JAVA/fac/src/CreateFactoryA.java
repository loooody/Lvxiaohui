/**
 * @ClassName: CreateFactoryA
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午5:30
 * @Version 1.0
 **/

public class CreateFactoryA implements CreateFactory {

    @Override
    public Iwork createWork() {
        return new Awork();
    }
}
