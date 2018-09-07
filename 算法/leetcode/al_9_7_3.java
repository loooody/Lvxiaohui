class al_9_7_3{
	public static void main(String[] args){
		int num = 1990;
		
		System.out.println("原数字为:" + num);
		System.out.println("转换后的数字为:" + reverse(num));
	}
	
	public static int reverse(int x) {
        long a = 0;
        int b = 0;
        if(x >= 0){
            b = (x + "").length(); //整数
        }
        else{
            b = (x + "").length() - 1;  //负数有一个负号
        }
        while(x != 0){
            for(int i = 0;i < b; i++){
                //当前最后一位数字，负数则显示的负数
                int a1 = x % 10;   
                x = (x - a1) / 10;
                a += (int) (a1*Math.pow(10,b-i-1));
            }
        }
        //超过范围的返回0
        if((a > Math.pow(2,31) - 1) || (a < (-1)*Math.pow(2,31))){
            return 0;
        }
        
        return (int)a;
    }
	
}