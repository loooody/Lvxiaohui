class al_9_8_2{
	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		int[] data = {1,2,3,4,5,6};
		ListNode head1 = createListNode(data);
		//再单链表中删除倒数第i个元素
		ListNode head = removeLasKNode(head1,3);
		
		while(head != null){
			System.out.print(head.val + "-->");
			head = head.next;
		}
	}
	
	//在单链表中删除倒数第i个数
	public static ListNode removeLasKNode(ListNode head,int k){
		if(k <= 0 || head == null) 
			return head;
		ListNode p = head;
		while(p != null){
			p = p.next;
			k--;
		}
		if(k == 0)
			return head.next;
		if(k < 0){
			ListNode q = head;
			while(++k != 0){
				//先自加，再判断
				q = q.next;
			}
			q.next = q.next.next;
		}
		return head;
	}
	
	//创建链表
	public static ListNode createListNode(int data[]){
		ListNode head = new ListNode(data[0]);
		ListNode temp = head;
		for(int i = 1; i < data.length; i++){
			ListNode headNext = new ListNode(data[i]);
			temp.next = headNext;
			temp = temp.next;
		}
		return head;
	}
}