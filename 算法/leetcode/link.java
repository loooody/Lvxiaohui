class Link{
	private Node root;
	
	class Node{
		private String name;
		private Node next;
		public Node(String name){
			this.name = name;
		}
	public String getName(){
		return this.name;
	}
	public void addNode(Node newNode){
		if(this.next == null){
			this.next = newNode;
		}else{
			this.next.addNode(newNode);
		}
	}
	
	public void printNode(){
		System.out.print(this.name + "-->");
		if(this.next != null){
			this.next.printNode();
		}
	}
	};
	
	public void add(String name){
		Node newNode = new Node(name);
		if(this.root == null){
			this.root = newNode;
		}else{
			this.root.addNode(newNode);
		}
	}
	
	public void print(){
		if(this.root != null){
			this.root.printNode();
		}
	}
	
	//测试
	public static void main(String[] args){
		Link link = new Link();
		link.add("根节点");
		link.add("第一节点");
		link.add("第二节点");
		link.add("第三节点");
		link.print();
	}
}