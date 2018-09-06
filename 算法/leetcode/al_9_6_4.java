import java.util.*;

class al_9_6_4{
	public static void main(String[] args){
		int[] value = {1,2,4};
		
		System.out.println(containDup(value));
	}
	
	//方法一：使用map的containskey方法
	//方法二：使用set的contains方法
	//方法三：使用Arrays.sort排序后再判断连续数值是否有相等的
	
	public static boolean containDup(int[] nums){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				return true;
			}else{
				map.put(nums[i],i);
			}
		}
		return false;
	}
}