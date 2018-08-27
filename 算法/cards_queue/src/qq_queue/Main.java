package qq_queue;

public class Main {
	public static void main(String[] args) {
		int [] p = {0,7,1,12,2,8,3,11,4,9,5,13,6,10};
		int[] q = new int[102];
		for(int i = 0;i < p.length;i++) {
			q[i] = p[i];
		}
		int head;
		int tail;
		//初始化队列
		head = 1;
		tail = 14;  //队列中已经有13个元素了，tail指向队尾的最后一个元素
		//当队列不为空时执行循环
		while(head < tail) {
			//打印队首并将队首出队
			if(tail - head == 1) {
				System.out.print(q[head] + " ");
				break;
			}else {
				head ++;
				System.out.print(q[head] + " ");
			}
			
			//将队首的数添加到队尾
			q[tail] = q[--head];
			tail ++;
			//队首出队
			head += 2;
		}
		
	}
}
