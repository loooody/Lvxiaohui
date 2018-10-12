package date1012;

import java.util.ArrayList;

public class PrintTreeSplitRow {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void printTreeSplitRow(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if (root == null) {
            return;
        }

        queue.add(root);
        int nextLevel = 0, toBePrint = 1;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.get(0);
            System.out.print(temp.val + " ");

            if (temp.left != null) {
                queue.add(temp.left);
                nextLevel++;
            }

            if (temp.right != null) {
                queue.add(temp.right);
                nextLevel++;
            }

            queue.remove(0);
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
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

        printTreeSplitRow(node1);

    }
}
