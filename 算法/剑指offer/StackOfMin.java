package date1010;

import java.util.Stack;

public class StackOfMin {

    static Stack<Integer> data = new Stack<Integer>();
    static Stack<Integer> min = new Stack<Integer>();

    public static void stackWithMinPush(int item) {
        data.push(item);
        if (min.size() == 0 || item < min.peek()) {
            min.push(item);
        }else{
            min.push(min.peek());
        }
    }

    public static void stackWithMinPop() {
        if (data.size() > 0 && min.size() > 0) {
            data.pop();
            min.pop();
        }
    }

    public static int stackWithDataTop(){
        if (data.size() > 0) {
            return data.peek();
        }else{
            return 0;
        }
    }


    public static int stackWithMinMin() {
        if (data.size() > 0 && min.size() > 0) {
            return min.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        StackOfMin stack = new StackOfMin();
        stack.stackWithMinPush(2);
        stack.stackWithMinPush(4);
        stack.stackWithMinPush(3);
        stack.stackWithMinPush(12);

        System.out.println(stack.stackWithMinMin());
        System.out.println(stack.stackWithDataTop());

    }
}
