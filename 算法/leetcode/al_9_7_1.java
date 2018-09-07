class al_9_7_1{
	public static void main(String[] args){
		int[] arr = {9,9,1,9};
		
		int[] newArr = plusOne(arr);
		
		for(int i : newArr){
			System.out.print(i);
		}
	}
	
	 public static int[] plusOne(int[] digits) {
        //当数组为空时，返回空数组
        int[] arr;
        boolean flag = false;
        int len = digits.length;
        if(len == 0){
            return null;
        }
        
        int i = len;
        //当数组不为空时，考虑进位a
        while(i > 0){
            if(digits[i - 1] != 9){
                if(flag){
                    digits[i - 1] += 1;
                    flag = false;
                }else{
                    digits[i - 1] += 1;
                }
                break;
            }else{
                digits[i - 1] = 0;
                flag = true;
                if(i == 1){
                    break;
                }
            }
            i--;
        }
        
        //如果最后产生进位，需要创建新的数组
        if(flag){
            arr = new int[len+1];
            arr[0] = 1;
            for(int j = 1; j <= len; j++){
                arr[j] = 0;
            }
            return arr;
        }
        
        return digits;
    }
}