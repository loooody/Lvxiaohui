/**
 * @ClassName: Bridge
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-21 下午7:41
 * @Version 1.0
 **/

public abstract class Bridge {

    private Impl impl;

    public void method(){};

    public Impl getImpl() {
        return impl;
    }

    public void setImpl(Impl impl) {
        this.impl = impl;
    }

}
