package date1008;

import date1007.HashMapTest;

public class HasSubtree {
    //树节点类
    static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //判断root2是不是root1的字结构
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //约定空树不是任意一个树的字结构
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = DoesTree1HaveTree2(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private static boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果root2为空，直接返回true
        if (root2 == null) {
            return true;
        }
        //如果root1为空，root2不为空，返回false
        if (root1 == null) {
            return false;
        }
        //如果两棵树都不为空
        if (root1.val != root2.val) {
            return false;
        }

        //如果两颗树当前节点值相同，继续判断左子树和右子树
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;
        node5.right = node7;

        node8.left = node9;
        node8.right = node;

        System.out.println(HasSubtree(node1, node8));
    }
}
