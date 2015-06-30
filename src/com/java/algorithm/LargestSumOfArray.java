package com.java.algorithm;

public class LargestSumOfArray {
	public static int calculateLargestSumOfArray(int[] array){
		 int sum = 0, max = array[0];
		    for(int i = 0; i < array.length; i++){
		        sum += array[i];
		        if(sum > max)
		            max = sum;
		        if(sum < 0)  //如果 sum < 0, 将 sum 重新置 0
		            sum = 0;
		    }
		    return max;
	}

	public static String calculateLargestSubstring(String a, String b){
		String largestSubstring = "";
		String temp = "";
		int i =0,j = 0;
		while(i < a.length()){
			while( j < b.length()){
				if(a.charAt(i) == b.charAt(j)){
					temp += a.charAt(i);
					j++;
					i++;
				}else{
					if(temp.length() > largestSubstring.length()){
						largestSubstring = temp;
					}else{
						j++;
						break;
					}
				}				
			}
			i++;
		}

		return largestSubstring;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-1, 1, 3, -4, 4, -1, 5, -7};
		int[] array2 = {-2,-2,-3};
//		System.out.println(LargestSumOfArray.calculateLargestSumOfArray(array2));
		
		String s1 = "abstringtest123";
		String s2 = "cdstring123";
		System.out.println(LargestSumOfArray.calculateLargestSubstring(s1, s2));
	}

}
