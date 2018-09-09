class al_9_1{

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public int lasVal = Integer.MAX_VALUE;
	public boolean firstNode = true;
	public boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		if(!isValidBST(root.left)){
			return false;
		}
		if(!firstNode && lasVal >= root.val){
			return false;
		}
		
		firstNode = false;
		lasVal = root.val;
		if(!isValidBST(root.right)){
			return false;
		}
		
		return true;
	}
	
	
}