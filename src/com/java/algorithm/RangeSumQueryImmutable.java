package com.java.algorithm;

import java.util.HashMap;

public class RangeSumQueryImmutable {

//    class Range{
//        int start;
//        int end;
//        public Range(int s, int e){
//            this.start = s;
//            this.end = e;
//        }
//        public boolean equals(Object range){
//        	if(range instanceof Range){
//        		Range r = (Range)range;
//        		return (this.start == r.start && this.end == r.end);
//        	}
//        	return false;
//            
//        }
//        public int hashCode(){
//            return (this.start *31)^ this.end;
//        }
//    }
//    private HashMap<Range, Integer> map = new HashMap();
//    public RangeSumQueryImmutable(int[] nums) {
//        for(int i = 0; i<=nums.length-1; i++){
//            map.put(new Range(i,i), nums[i]);
//            for(int j = i+1; j<=nums.length-1;j++){
//                map.put(new Range(i,j), map.get(new Range(i,j-1))+nums[j]);
//            }
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return map.get(new Range(i,j));
//    }
//    303. easy
//    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//    Example:
//    Given nums = [-2, 0, 3, -5, 2, -1]
//
//    sumRange(0, 2) -> 1
//    sumRange(2, 5) -> -1
//    sumRange(0, 5) -> -3
//    Note:
//    You may assume that the array does not change.
//    There are many calls to sumRange function.
    private int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        sum = nums;
        for(int i = 1; i<=nums.length-1;i++){
            sum[i] += sum[i-1];
        } 

    }

    public int sumRange(int i, int j) {
        return i == 0? sum[j] :sum[j]-sum[i-1];
    }
	public static void main(String[] args) {
		int[] nums = {-2,0,3,-5,2,-1};
	
		RangeSumQueryImmutable rs = new RangeSumQueryImmutable(nums);
		System.out.println(rs.sumRange(0, 2));
		System.out.println(rs.sumRange(2, 5));
		System.out.println(rs.sumRange(0, 5));
		
//		RangeSumQueryImmutable.Range r = rs.new Range(0,0);
//		RangeSumQueryImmutable.Range r2 = rs.new Range(0,0);
//		HashMap<RangeSumQueryImmutable.Range, Integer> map = new HashMap();
//		map.put(r, 1);
//		System.out.println(map.get(r2));
//		System.out.println(r.equals(r2));
//		System.out.println(r.hashCode() == r2.hashCode());

	}

}
