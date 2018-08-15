package findStr;

public class NewDemo {
	private static int count;
	
	//统计一段文本中指定字符串出现的次数
	
	public static void test() {
		System.out.println("字符串出现的次数为:" + text("helloworldhello","ell"));
	}
	
	public static int text(String text,String input) {
		
		for(int i = 0; i < text.length() - input.length(); i++) {
			
			String str = text.substring(i, i + input.length());
			if(str.equals(input)) {
				count ++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		test();
	}
}
