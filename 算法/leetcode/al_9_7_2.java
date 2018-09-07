class al_9_7_2{
	public static void main(String[] args){
		String s = "123456789";
		StringBuffer bf = new StringBuffer(s);
		
		System.out.println(bf.reverse().toString());
		
		//方法二：使用数组的方式，toCharArray()方法将字符串转化为数组，再重新拼接字符串
	}
	
}