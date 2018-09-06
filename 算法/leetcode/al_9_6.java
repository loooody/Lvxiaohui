import java.util.*;

class al_9_6{
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args){
		int[] l = {9,9};
		int[] s = {1};
		
		ListNode list1,list2;
		
		//链表初始化
		list1 = init(l);
		list2 = init(s);
		
		
		ListNode result = addTwoNumbers(list1,list2);
		while(result != null){
			System.out.print(result.val);
			result = result.next;
		}
		
	}
	
	public static ListNode addTwoNumbers(ListNode l,ListNode s){
		ListNode head = new ListNode(0);
		ListNode p = l,q = s,curr = head;
		
		int carry = 0;
		while(p != null || q != null){
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x +y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if(p != null)
				p = p.next;
			if(q != null)
				q = q.next;
		}
		
		if(carry > 0){
			curr.next = new ListNode(carry);
		}
		return head.next;
	}
	
	public static ListNode init(int[] arr){
		ListNode head = new ListNode(0);
		ListNode current = head;
		
		for(int i = 0; i < arr.length; i++){
			current.next = new ListNode(arr[i]);
		//	System.out.println("ar:" + current.next.val);
			current = current.next;
		}
	//	System.out.println("ar:" + head.val);
		return head.next;
	}
}