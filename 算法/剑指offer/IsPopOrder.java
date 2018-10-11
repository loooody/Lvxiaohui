package date1011;

import java.util.Stack;

public class IsPopOrder {

    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && (stack.peek() == popA[j])) {
                stack.pop();
                j++;
            }
        }

        if (stack.empty()) {
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 1, 2};

        boolean flag = isPopOrder(pushA, popA);
        System.out.println(flag);

    }
}
