//对一个二叉树进行层次遍历

public List<List<Integer>> levelOrder(TreeNode root){
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	levelRecursion(root,result,0);
	
	return result;
}

public static void levelRecursion(TreeNode node, List<List<Integer>> result,int level){
	if(node == null) return ;
	if(result.size() < level + 1){
		result.add(new ArrayList<Integer>());
	}
	result.get(level).add(node.val);
	
	levelRecursion(node.left, result, level + 1);
	levelRecursion(node.right, result, level + 1);
}