package date1013;

import java.util.ArrayList;

public class PrintTree {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<TreeNode> stack1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> stack2 = new ArrayList<TreeNode>();

        //用一个flag标记当前时奇数层还是偶数层
        boolean flag = true;
        TreeNode temp = null;

        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                temp = stack1.get(stack1.size() - 1);
                stack1.remove(stack1.size() - 1);
            }else{
                temp = stack2.get(stack2.size() - 1);
                stack2.remove(stack2.size() - 1);
            }

            System.out.print(temp.val + " ");

            if (flag) {
                if (temp.left != null) {
                    stack2.add(temp.left);
                }

                if (temp.right != null) {
                    stack2.add(temp.right);
                }
            }else{
                if (temp.right != null) {
                    stack1.add(temp.right);
                }

                if (temp.left != null) {
                    stack1.add(temp.left);
                }
            }

            //当前层打印结束，更改flag的值
            if (flag) {
                if (stack1.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            }else{
                if (stack2.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        printTree(node1);

    }
}
