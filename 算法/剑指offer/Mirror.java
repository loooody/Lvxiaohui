package date1008;

public class Mirror {

    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            return ;
        } else {
            //交换根节点的左右孩子
            TreeNode temp = root.left;
            System.out.print(root.left == null ? 0 + " " : root.left.val + " ");
            root.left = root.right;
            System.out.print(root.right == null ? 0 + " " : root.right.val + " ");
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

        Mirror(node1);
        System.out.println();
        Mirror(node1);
    }
}
