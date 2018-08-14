package quickSort;

public class quickSortTest {
	
	/*
	 * 快速排序
	 * 学习链接
	 * http://wiki.jikexueyuan.com/project/easy-learn-algorithm/fast-sort.html
	 */
	public static void main(String[] args) {
		
		int[] arr = {3,6,8,5,2,4,1,10};
		ArraySort.quickSort(arr, 0, arr.length-1);
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		String str = "[";
		for(int i = 0; i < arr.length; i++) {
			str = str + arr[i] + ",";
		}
		str = str.substring(0,str.length() - 1);
		str = str + "]";
		System.out.println(str);
		System.out.println("");
	}
}
