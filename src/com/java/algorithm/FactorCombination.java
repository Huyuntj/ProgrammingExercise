package com.java.algorithm;

import java.util.ArrayList;
import java.util.List;

//#254, medium

public class FactorCombination {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <=3) return res;
        List<Integer> item = new ArrayList();
        getAllFactors(n, item, res);
        return res;
    }
    
    public void getAllFactors(int n, List<Integer> item, List<List<Integer>> res){
        if(n <= 3) {
//        	res.add(item);
        	return;
        }
        for(int i= 2; i*i<= n; i++){
            if(item.size() == 0 
                ||
                item.size() > 0 && item.get(item.size()-1) <= i)
            {
            	if((n % i == 0)){
                    List<Integer> l = new ArrayList(item);
//                    l.addAll(item);
                    l.add(i);l.add(n/i); res.add(l);
                    item.add(i);     
                    getAllFactors(n/i, item,res);                 
                    item.remove(item.size()-1);
            	}

            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorCombination c = new FactorCombination();
		System.out.println(c.getFactors(32));
	}

}
