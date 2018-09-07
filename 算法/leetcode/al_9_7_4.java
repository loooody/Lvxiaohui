class al_9_7_4{
	public static void main(String[] args){
		String s = "ellay";
		
		System.out.println("最后的结果为:" + firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
       int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}