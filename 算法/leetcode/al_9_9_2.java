class al_9_9_2{
	public static BinaryNode root;
	
	public static class BinaryNode{
		Object element;
		BinaryNode left;
		BinaryNode right;
		
		public BinaryNode(Object element,BinaryNode left,BinaryNode right){
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args){
		init();
		
		System.out.println("最后结果为:" + isSymmetric(root));
	}
	
	public static boolean isSymmetric(BinaryNode root){
		if(root == null) return true;
		
		return checkISymmetric(root.left,root.right);
	}
	
	public static boolean checkISymmetric(BinaryNode p,BinaryNode q){
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if(p.element != p.element) return false;
		
		return checkISymmetric(p.left,q.right) && checkISymmetric(p.right,q.left);
	}
	
	//数据初始化
	public static void init(){
        BinaryNode l = new BinaryNode("l",null,null);
		BinaryNode i = new BinaryNode("l",null,null);
		
        root = new BinaryNode("i", l, i);

	}
}