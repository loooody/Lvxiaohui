import java.util.*;

class al_9_12_1{
	public static void main(String[] args){
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		
		merge(nums1,nums2);
		
		for(int i : nums1)
			System.out.print(i + " ");
	}
	
	public static void merge(int[] nums1, int[] nums2){
		for(int i = 0; i < nums2.length; i++){
			nums1[nums1.length-i-1] = nums2[i];
		}
		Arrays.sort(nums1);
	}
}