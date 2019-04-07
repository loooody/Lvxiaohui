/**
 * @ClassName: Facade
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-7 下午11:53
 * @Version 1.0
 **/

public class Facade {
    private Register register;
    private Treament treament;
    private Payment payment;
    private Drugstore drugstore;

    public Facade() {
        this.register = new Register();
        this.treament = new Treament();
        this.payment = new Payment();
        this.drugstore = new Drugstore();
    }

    //挂号
    public void register(){
        register.register();
    }

    //门诊
    public void treament(){
        treament.treament();
    }

    //缴费
    public void payment(){
        payment.payment();
    }

    //取药
    public void getDrugs(){
        drugstore.getDrug();
    }
}
