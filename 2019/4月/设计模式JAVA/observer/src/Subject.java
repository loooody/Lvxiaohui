import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Subject
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-4-5 下午11:38
 * @Version 1.0
 **/

public class Subject {

    private List<Observer> list = new ArrayList<>();

    /**
     * 添加观察者对象
     * @param observer
     */
    public void registerObserver(Observer observer) {
        list.add(observer);
        System.out.println("注册了一个观察者角色");
    }

    /**
     * 删除观察者对象
     * @param observer
     */
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    public void notigyAllObserver(String newState) {
        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
