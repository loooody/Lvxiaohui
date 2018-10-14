package date1014;

import java.util.ArrayList;

public class FindPath {
    static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> path = new ArrayList<Integer>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {
        if (root == null) {
            return pathList;
        }

        path.add(root.val);
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            pathList.add(new ArrayList<Integer>(path));
        }

        if (root.left != null) {
            findPath(root.left, sum);
        }

        if (root.right != null) {
            findPath(root.right, sum);
        }

        path.remove(path.size() - 1);
        return pathList;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(pathList);

        findPath(node1, 22);

        for (ArrayList<Integer> list : pathList) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
