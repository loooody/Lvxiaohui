class hikanvision{
	public static void main(String[] args){
		System.out.println("1000以内的完数有:");
		
		total();
	}
	
	public static void total(){
		//求1000以内的所有完数
		int count = 0;
		int sum ;
		for(int i = 0; i < 1000; i++){
			sum = 0;
			for(int j = 1; j < i; j++){
				if(i % j == 0){
					sum += j;
				}
			}
			//判断i的所有因子的和与i是否相等
			if(i == sum){
				System.out.print(i + " ");
				count++;
				if(count % 10 == 0){
					System.out.println();
				}
			}
		}
	}
}