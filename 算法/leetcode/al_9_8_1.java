class al_9_8_1{
	private static ListNode head = new ListNode(0);;
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args){
		int[] arr = {4,5,1,9};
		ListNode head1 = createList(arr);
		
		while(head1 != null){
			System.out.println("zi" + head1.next.val + "->");
			head1 = head1.next;
		}
	}
	
	//删除链表中指定元素
	private static void deleteNode(ListNode node){
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	//使用数组创建一个新的链表
	public static ListNode createList(int[] arr){
	//	head = new ListNode(0);
		ListNode curr ,head1;
		head1 = head;
		curr = head1;
		
		for(int i = 0; i < arr.length; i++){
			curr = new ListNode(arr[i]);
			
			curr = curr.next;
			
		}
//		System.out.println(head.next.val);
		return head1.next;
	}
}