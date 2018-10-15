package date1015;

public class SerializeOfTree {

    public static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int index = -1;

    public static String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public static TreeNode Deserialize(String string) {
        String[] str = string.split(",");
        int len = str.length;
        index++;
        if (index >= len) {
            return null;
        }

        TreeNode node = null;
        if (!str[index].equals("#")) {

            node = new TreeNode(Integer.valueOf(str[index]));
            node.left = Deserialize(string);
            node.right = Deserialize(string);

            System.out.print(node.val + " ");
        }



        return node;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        String str = Serialize(node4);
        System.out.println(str);


        Deserialize(str);
    }
}
