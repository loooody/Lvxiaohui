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
		//��ʼ������
		head = 1;
		tail = 10;  //�������Ѿ���9��Ԫ���ˣ�tailָ���β�����һ��Ԫ��
		//�����в�Ϊ��ʱִ��ѭ��
		while(head < tail) {
			//��ӡ���ײ������׳���
			System.out.print(q[head] + " ");
			head ++;
			
			//�Ƚ��¶��׵�����ӵ���β
			q[tail] = q[head];
			tail ++;
			//�ٽ����׳���
			head ++;
		}
		
	}
}
