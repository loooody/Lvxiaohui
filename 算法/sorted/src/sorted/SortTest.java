package sorted;

public class SortTest {
	
	public static void main(String[] args) {
		//定义一个一维数组
		int arr1[] = {5,3,8,9,4,6,1,7};
		ArraySort.bubbleSort(arr1);
		printArray(arr1);
		
		int[] arr2 = {5,3,8,9,4,6,1,7};
		ArraySort.selectSort(arr2);
		printArray(arr2);
	}
	
	public static void printArray(int[] arr) {
		String str = "[";
		for(int i = 0;i < arr.length;i++) {
			str = str + arr[i] + ",";
		}
		str = str.substring(0,str.length() -1);
		str = str + "]";
		System.out.println(str);
		System.out.println("");
	}
}
