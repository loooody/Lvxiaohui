package sorted;

public class ArraySort {

	//冒泡排序
	public static void bubbleSort(int arr[]) {
		/*
		 * 两个for循环嵌套
		 * 外面的for循环决定一个长度为m的数据要比较多少轮才能完成排序
		 * 里面的for循环决定每次一轮循环中要做多少次比较才能结束
		 */
		for(int i = 0;i < arr.length - 1;i++) {
			for(int j = 0;j < arr.length - i - 1;j++) {
				//从小到大，大的值放在后面位置
				if(arr[j] > arr[j + 1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}
		
		//选择排序
		public static void selectSort(int[] arr) {
			/*
			 * 两个for循环
			 * 规律同冒泡排序
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
