package sorted;

public class ArraySort {

	//ð������
	public static void bubbleSort(int arr[]) {
		/*
		 * ����forѭ��Ƕ��
		 * �����forѭ������һ������Ϊm������Ҫ�Ƚ϶����ֲ����������
		 * �����forѭ������ÿ��һ��ѭ����Ҫ�����ٴαȽϲ��ܽ���
		 */
		for(int i = 0;i < arr.length - 1;i++) {
			for(int j = 0;j < arr.length - i - 1;j++) {
				//��С���󣬴��ֵ���ں���λ��
				if(arr[j] > arr[j + 1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}
		
		//ѡ������
		public static void selectSort(int[] arr) {
			/*
			 * ����forѭ��
			 * ����ͬð������
			 */
			for(int i = 0;i < arr.length - 1; i++) {
				for(int j = i + 1;j < arr.length;j++) {
					if(arr[i] > arr[j]) {
						swap(arr,i,j);
					}
				}
			}
		}
	
		private static void swap(int[] arr,int index1,int index2) {
			int temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
		}
		
}
