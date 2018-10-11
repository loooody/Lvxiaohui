package date1011;

import java.util.ArrayList;

public class PrintFromTopToButtom {

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printFromTopToButtom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //层次遍历使用了一个队列
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        if (root == null) {
            return null;
        }

        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

            list.add(temp.val);
        }

        return list;
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

        ArrayList<Integer> list = printFromTopToButtom(node1);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
