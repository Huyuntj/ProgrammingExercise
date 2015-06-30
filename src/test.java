import java.util.HashMap;
import java.util.Map;


public class test {
	public static int find(int a[]) {
		int candidate = -1;
		int times, i;
		for (i = 0, times = 0; i < a.length; i++) {
			if (times == 0) {
				candidate = a[i];
				times++;
			} else {
				if (candidate == a[i])
					times++;
				else
					times--;
			}
		}
		return candidate;
	};

	public static void main(String[] args) {
//		int[][] a = new int[][] { {1, 4}, {5, 7} };
//		int[] b = new int[]{1,2};
//		System.out.println(Arrays.asList(b));
//		String s = "abcdefg";
//		for(int i = s.length()-1; i>=0; i--){
//			System.out.print(s.charAt(i));
//		}
//		String a = "25/12/2015";
//		String b = "25/12/2015";
//		System.out.println(a.compareTo(b));
//		String s = "MCMXCVI";
//
//		Map<Character,Integer> map = new HashMap<Character,Integer>();
//        map.put('I',1);
//        map.put('V',5);
//        map.put('X',10);
//        map.put('L',50);
//        map.put('C',100);
//        map.put('D',500);
//        map.put('M',1000);
//        s = s.toUpperCase();
//        int sum = map.get(s.charAt(s.length()-1)).intValue();
//        for(int i=s.length()-1; i>= 1; i--){
//            int b = map.get(s.charAt(i)).intValue();
//            int a = map.get(s.charAt(i-1));                
//                if(a < b){
//                    sum =  sum - a;
//                }else{
//                    sum =  sum + a;
//                }
//            
//        }
//        System.out.println(sum);
		System.out.println(1 ^ 1);
	}

}
