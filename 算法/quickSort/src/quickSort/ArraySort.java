package quickSort;

public class ArraySort {
	
	//��������
	public static void quickSort(int[] arr, int low, int high) {
		int l = low;
		int h = high;
		//����
		int povit = arr[low];
		//һ�˿������򣬼�l=h������povit��λ�þ͹̶��ˣ���߶���С������ֵ���ұ߶��Ǵ�������ֵ
		while(l < h) {
			//���ұ߿�ʼ��ͨ����λ�Ǳ�h���Լ���������λ���λ��һȡ�������е�ֵ��l<h�ų���l=h���
			while(povit < arr[h] && l < h) {
				h--;
			}
			//��������ѭ����������l != h��˵���ұ߳���С��povitԪ�أ���Ҫ����λ��
			if(l < h) {
				swap(arr,l,h);
				//�Ӻ�һλ��ʼ��ȡ����
				l++;
			}
			//����߿�ʼ��ͨ����λ�Ǳ�l������������������λ��һȡ�������е�ֵ
			while(povit > arr[l] && l <h) {
				l++;
			}
			//���ѭ����������l ��= h��˵����߳��ִ���povitԪ�أ���Ҫ����λ��
			if(l < h) {
				swap(arr,l,h);
				h++;
			}
			//���¼����������whileѭ����ֱ��l =h
			
		}
		//�ݹ飬povit��߼�������quickSort
		if(l > low)
			quickSort(arr,low,l - 1);
		//�ݹ飬povit�ұ߼�������quickSort
		if(h < high)
			quickSort(arr,l + 1,high);
	}
	
	private static void swap(int[] arr,int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
