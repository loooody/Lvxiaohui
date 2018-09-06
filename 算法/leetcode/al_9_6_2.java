class al_9_6_2{
	public static void main(String[] args){
		int[] prices = {7,1,5,3,6,4};
		int profit = maxProfit(prices);
		
		System.out.println("最后的利益为:" + profit);
	}
	
	//求出最大利益
	public static int maxProfit(int[] prices){
		int money = 0;
		int i = 0;
		
		while(i < prices.length - 1){
			if(prices[i+1] > prices[i]){
				money += prices[i+1] - prices[i];
			}
			i++;
		}
		return money;
	}
}