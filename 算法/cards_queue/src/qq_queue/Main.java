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
		//��ʼ������
		head = 1;
		tail = 14;  //�������Ѿ���13��Ԫ���ˣ�tailָ���β�����һ��Ԫ��
		//�����в�Ϊ��ʱִ��ѭ��
		while(head < tail) {
			//��ӡ���ײ������׳���
			if(tail - head == 1) {
				System.out.print(q[head] + " ");
				break;
			}else {
				head ++;
				System.out.print(q[head] + " ");
			}
			
			//�����׵�����ӵ���β
			q[tail] = q[--head];
			tail ++;
			//���׳���
			head += 2;
		}
		
	}
}
