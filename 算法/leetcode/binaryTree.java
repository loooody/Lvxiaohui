import java.util.*;

class binaryTree{
	public static class BinaryNode{
		private Object element;
		private BinaryNode lChild;	//定义指向左子树的指针
		private BinaryNode rChild;	//定义指向右子树的指针
		
		public BinaryNode(Object element,BinaryNode lChild,BinaryNode rChild){
			this.element = element;
			this.lChild = lChild;
			this.rChild = rChild;
		}
	}
	
	
	private static BinaryNode root;
	private static List<BinaryNode> list = new ArrayList<BinaryNode>();
	private static List<BinaryNode> list1 = new ArrayList<BinaryNode>();
	private static List<BinaryNode> list2 = new ArrayList<BinaryNode>();
	
	public static void main(String[] args){
		init();
		
		//前序遍历
		preOrder(root);
		//中序遍历
		midOrder(root);
		//后序遍历
		postOrder(root);
		
		System.out.println("前序遍历:");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).element + "->");
		}
		
		System.out.println("\n中序遍历:");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list1.get(i).element + "->");
		}
		
		System.out.println("\n后序遍历:");
		for(int i = 0; i < list.size(); i++){
			System.out.print(list2.get(i).element + "->");
		}
	}
	
	
	
	/**
	*对二叉树进行前序遍历
	*/
	public static void preOrder(BinaryNode node){
		list.add(node);
		//如果左子树不为空则继续往左找，在递归调用方法时会一直将子树的根存到list中
		if(node.lChild != null){
			preOrder(node.lChild);
		}
		
		//无论走到哪一层，只要当前节点左子树为空，就可以在右子树上遍历
		if(node.rChild != null){
			preOrder(node.rChild);
		}
	}
	
	/**
	*对二叉树进行前序遍历
	*/
	public static void midOrder(BinaryNode node){
		if(node.lChild != null){
			midOrder(node.lChild);
		}
		list1.add(node);
		if(node.rChild != null){
			midOrder(node.rChild);
		}
	}
	
	/**
	*对二叉树进行后序遍历
	*/
	public static void postOrder(BinaryNode node){
		if(node.lChild != null){
			postOrder(node.lChild);
		}
		if(node.rChild != null){
			postOrder(node.rChild);
		}
		list2.add(node);
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