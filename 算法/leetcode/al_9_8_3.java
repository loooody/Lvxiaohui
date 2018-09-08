class al_9_8_3{
	private static BinaryNode root;
	
	public static class BinaryNode{
		Object element;
		BinaryNode lChild;
		BinaryNode rChild;
		
		public BinaryNode(Object element,BinaryNode lChild,BinaryNode rChild){
			this.element = element;
			this.lChild = lChild;
			this.rChild = rChild;
		}
	}
	
	public static void main(String[] args){
		init();
		
		System.out.println("此树的最大深度为：");
		System.out.println(maxDepth(root));
	}
	
	//求树的最大深度
	public static int maxDepth(BinaryNode root){
		return root == null ? 0 : (1 + Math.max(maxDepth(root.lChild),maxDepth(root.rChild)));
	}
	
	//数据初始化
	public static void init(){
		BinaryNode b = new BinaryNode("b",null,null);
		BinaryNode a = new BinaryNode("a",null,b);
		BinaryNode c = new BinaryNode("c",a,null);
		
		BinaryNode e = new BinaryNode("e",null,null);
		BinaryNode g = new BinaryNode("g", null, null);
        BinaryNode f = new BinaryNode("f", e, g);
        BinaryNode h = new BinaryNode("h", f, null);
        
        BinaryNode d = new BinaryNode("d", c, h);
        
        BinaryNode j = new BinaryNode("j", null, null);
        BinaryNode k = new BinaryNode("k", j, null);
        BinaryNode m = new BinaryNode("m", null, null);
        BinaryNode o = new BinaryNode("o", null, null);
        BinaryNode p = new BinaryNode("p", o, null);
        BinaryNode n = new BinaryNode("n", m, p);
        BinaryNode l = new BinaryNode("l", k, n);
        
        root = new BinaryNode("i", d, l);

	}
}