class al_9_7_5{
	public static void main(String[] args){
		String s = "anagram";
		String t = "nagaram";
		
		System.out.println(isAnagram(s,t));
	}
	
	//桶排序
	public static boolean isAnagram(String s, String t) {
        //判断两个字符串的长度是否相等，相等，继续，不相等
        int len1 = s.length();
        int len2 = t.length();
        
        if(len1 != len2){
            return false;
        }
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
    //    System.out.println(1+'a');
        for(int i = 0; i < len1; i++){
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
         }
        
        for(int i = 0;i < 26; i++){
             if(arr1[i] != arr2[i]){
                 return false;
             }
        }
        return true;
    }
}