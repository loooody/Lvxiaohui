package qq_queue;

public class Main {
	public static void main(String[] args) {
		int [] p = {0,6,3,1,7,5,8,9,2,4};
		int[] q = new int[102];
		for(int i = 0;i < p.length;i++) {
			q[i] = p[i];
		}
		int head;
		int tail;
		//初始化队列
		head = 1;
		tail = 10;  //队列中已经有9个元素了，tail指向队尾的最后一个元素
		//当队列不为空时执行循环
		while(head < tail) {
			//打印队首并将队首出队
			System.out.print(q[head] + " ");
			head ++;
			
			//先将新队首的数添加到队尾
			q[tail] = q[head];
			tail ++;
			//再将队首出队
			head ++;
		}
		
	}
}
