package com.java.algorithm.string;

public class MultiplyStrings {
	//brilliant solution from leetcode
	//https://drscdn.500px.org/photo/130178585/m%3D2048/300d71f784f679d5e70fadda8ad7d68f
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];
        int sum = 0;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                sum = mul + pos[p2];
                pos[p2] = sum % 10;
                pos[p1] = pos[p1] + sum/10;
                
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : pos){
            if(sb.length() == 0 && p == 0) continue;
            sb.append(p);
        }
        return (sb.length() == 0) ? "0" : sb.toString();
        
    }
	//my brutal force solution 
	//just act like the real multiplication doing
    public String multiplyBrutalForce(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if(num1.equals("0") || num2.equals("0")) return "0";
        String res = "";
        for(int i = num2.length() - 1; i>= 0; i--){
            String tmp = multiplyOneBitString(num1, num2.charAt(i));
            for(int j = 1; j< num2.length() - i; j++){
                tmp = tmp.concat("0");
            }
            System.out.println("tmp = "+ tmp);
            res = addTwoString(res, tmp);
            System.out.println("res = "+ res);
        }
        return res;
    }
	    private String addTwoString(String s1, String s2){
	        if((s1 == null || s1.length() == 0) && (s2 == null||s2.length() == 0)) return "";
	        if(s1 == null || s1.length() == 0) return s2;
	        if(s2 == null || s2.length() == 0) return s1;
	        int l1 = s1.length() - 1;
	        int l2 = s2.length() - 1;
	        int bit = 0;
	        StringBuilder sb = new StringBuilder();
	        while(l1 >= 0 && l2 >= 0){
	            int n1 = (int)s1.charAt(l1) - 48;
	            int n2 = (int)s2.charAt(l2) - 48;
	            sb.insert(0, Integer.toString((n1+n2+bit)%10));
	            bit = (n1 + n2 + bit) /10;
	            l1--;
	            l2--;
	        }
	        if(l1 >= 0){
	            if(bit == 0){
	                return s1.substring(0,l1+1) + sb.toString();
	            }else{
	                for(int j = l1; j>=0;j--){
	                    int n1 = (int)s1.charAt(j) - 48;
	                    sb.insert(0,Integer.toString((n1+bit)%10));
	                    bit = (n1+bit)/10;
	                }
	            }
	        }
	        if(l2 >=0){
	            if(bit == 0){
	                return s2.substring(0,l2+1) + sb.toString();
	            }else{
	                for(int j = l2;j>=0;j--){
	                    int n1 = (int)s2.charAt(j) - 48;
	                    sb.insert(0,Integer.toString((n1+bit)%10));
	                    bit = (n1+bit)/10;
	                }
	            }
	        }
            if(bit > 0){
            	sb.insert(0, Integer.toString(bit));
            }
	        return sb.toString();
	    }
	    private String multiplyOneBitString(String s1, char c){
	        StringBuilder sb = new StringBuilder();
	        int bit = 0;
	        for(int i = s1.length()-1; i>= 0;i--){
	            int n1 = (int)s1.charAt(i) - 48;
	            int n2 = n1 * ((int)c -48) + bit;
	            sb.insert(0,Integer.toString(n2 % 10));
	            bit = n2 / 10;	            
	        }
	        if(bit > 0){
	            sb.insert(0,Integer.toString(bit));
	        }
	        return sb.toString();
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings ms = new MultiplyStrings();
		String s1 = "123456789";
		String s2 = "987654321";
		System.out.println(ms.multiply(s1, s2));
		System.out.println(ms.addTwoString("9876543120000000", "944977892635269"));
	}

}
