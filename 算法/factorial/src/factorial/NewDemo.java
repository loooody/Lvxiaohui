package factorial;

public class NewDemo {
	
	static int i = 1,mul = 1;
	
	/**使用递归实现阶乘算法*/
	
	public static int test(int k) {
		if(i <= k) {
			mul *= i;
			i++;
			test(k);
		}
		return mul;
	}
	
	public int[] bubbleSort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return null;
		}
		int j = arr.length - 1;
		for(int i = 0;i < j;i++) {
			for(j = arr.length - 1; j>i ;j--) {
				if(arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}
		
	
	
	public static void main(String[] args) {
		System.out.println(test(5));
		
		NewDemo demo = new NewDemo();
		
		int[] arr = {48,5,7,9,1};
		
		int[] arr1 = demo.bubbleSort(arr);
		
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i] + "  ");
		}
		
	}
}
