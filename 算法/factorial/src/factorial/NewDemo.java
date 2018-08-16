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
	
	public static void main(String[] args) {
		System.out.println(test(4));
	}
}
