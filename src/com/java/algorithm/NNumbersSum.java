package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.algorithm.sort.SortHelper;

public class NNumbersSum {
    public static List<List<Integer>> threeSumEquals0(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return list;
        
        int j,k;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length -2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            j = i+1;
            k = nums.length -1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }                
            }

        }
        return list;
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int j,k;
        int minGap = Integer.MAX_VALUE;
        
        for(int i = 0; i< nums.length -2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            j = i+1;
            k = nums.length -1;
            while(j < k){
                int gap = nums[i] + nums[j] + nums[k] - target;
                if(gap == 0) return target;
                minGap = Math.abs(gap) < Math.abs(minGap)? gap : minGap;
                if(gap > 0){
                    k--;
                }else{
                    j++;
                }               
            }

        } 
        return minGap+target ;
    }
    public static int threeSumSmaller(int[] nums, int target) {
        if(nums ==  null) return 0;
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        int lo, hi;
        for(int i = 0; i<= (len - 3); i++){
            lo = i+1;
            hi = len - 1;
            while(lo < hi){
                if(nums[i] + nums[lo] + nums[hi] < target){
                    count += (hi - lo);
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        return count;
    }
    //my solution with 56 ms
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        int i,j,m,n;
        
        for(i = 0; i< len -3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            j = len - 1;
            while(i < j){
                if(nums[i] > 0 && nums[i] + nums[j] > target){
                    j--;
                    continue;
                }
                m = i+1;
                n = j-1;
                while(m < n){
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[m], nums[n], nums[j]));
                        while(m<n && nums[m+1] == nums[m]) m++;
                        while(m<n && nums[n-1] == nums[n]) n--;
                        m++; n--;
                    }else if(sum > target){
                        n--;
                    }else 
                        m++;
                }
                while(i<j && nums[j] == nums[j-1]) j--;
                j--;
            }            
        }

        return res;
        
    }
    //better solution with 7ms
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
    public static void main(String[] args) {
		int[] a = {-3,-1,0,2,4,5};
		List<List<Integer>> res = NNumbersSum.fourSum(a, 0);
		SortHelper.printListInList(res);
		
	}

}
