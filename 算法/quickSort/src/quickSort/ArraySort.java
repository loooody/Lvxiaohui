package quickSort;

public class ArraySort {
	
	//快速排序
	public static void quickSort(int[] arr, int low, int high) {
		int l = low;
		int h = high;
		//基数
		int povit = arr[low];
		//一趟快速排序，即l=h，这是povit的位置就固定了，左边都是小于它的值，右边都是大于它的值
		while(l < h) {
			//从右边开始，通过高位角标h的自减，从最右位向低位逐一取出数组中的值，l<h排除了l=h情况
			while(povit < arr[h] && l < h) {
				h--;
			}
			//如果上面的循环结束，且l != h，说明右边出现小于povit元素，需要互换位置
			if(l < h) {
				swap(arr,l,h);
				//从后一位开始读取数组
				l++;
			}
			//从左边开始，通过低位角标l的自增，从最左边向高位逐一取出数组中的值
			while(povit > arr[l] && l <h) {
				l++;
			}
			//如果循环结束，且l ！= h，说明左边出现大于povit元素，需要互换位置
			if(l < h) {
				swap(arr,l,h);
				h++;
			}
			//向下继续最外面的while循环，直到l =h
			
		}
		//递归，povit左边继续调用quickSort
		if(l > low)
			quickSort(arr,low,l - 1);
		//递归，povit右边继续调用quickSort
		if(h < high)
			quickSort(arr,l + 1,high);
	}
	
	private static void swap(int[] arr,int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
