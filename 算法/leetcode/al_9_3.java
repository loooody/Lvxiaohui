import java.util.*;

class al_9_3{
	public static void main(String[] args){
		int[] nums = {2,7,11,15};
		int target = 26;
		int[] arr = twoSum(nums,target);
		System.out.println("[" + arr[0] + "," + arr[1] + "]");
	}
	
	public static int[] twoSum(int[] nums,int target){
		//创建一个map来存放数组中的值
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			int result = target - nums[i];
			if(map.containsKey(result)){
				return new int[]{map.get(result),i};
			}
			map.put(nums[i],i);
		}
		throw new IllegalArgumentException("没有结果");
	}
}