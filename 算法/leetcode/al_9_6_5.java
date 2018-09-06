import java.util.*;

class al_9_6_5{
	public static void main(String[] args){
		int[] nums = {4,1,2,1,2};
		
		System.out.println(singleNumber(nums));
	}
	
	//注意判断当数组为空或为1的情况，还有当不重复的值为最后一个时
	public static int singleNumber(int[] nums) {
        int i;
        Arrays.sort(nums);
        if(nums.length == 1)
            return nums[0];
        
        for(i = 0; i < nums.length - 1; i = i+2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        if(nums.length-1 == i){
                return nums[nums.length-1];
        }
        return -1;
    }
}