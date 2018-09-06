class al_9_6_3{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7};
		
		int[] newArr = new int[arr.length];
		
		newArr = rotate(arr,3);
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(newArr[i]+" ");
		}
	}
	
	public static int[] rotate(int[] nums,int k){
		int len = nums.length;
		//判断将要移动的位数
		int newk = k % len;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			
			//移动后新元素的位置
			int position = (i + newk)% len;
			arr[position] = nums[i];
		}
		return arr;
	}
}