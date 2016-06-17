package com.java.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Twitter {
//	355. Medium
//	Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
//
//	postTweet(userId, tweetId): Compose a new tweet.
//	getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
//	follow(followerId, followeeId): Follower follows a followee.
//	unfollow(followerId, followeeId): Follower unfollows a followee.
//	Example:
//
//	Twitter twitter = new Twitter();
//
//	// User 1 posts a new tweet (id = 5).
//	twitter.postTweet(1, 5);
//
//	// User 1's news feed should return a list with 1 tweet id -> [5].
//	twitter.getNewsFeed(1);
//
//	// User 1 follows user 2.
//	twitter.follow(1, 2);
//
//	// User 2 posts a new tweet (id = 6).
//	twitter.postTweet(2, 6);
//
//	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//	twitter.getNewsFeed(1);
//
//	// User 1 unfollows user 2.
//	twitter.unfollow(1, 2);
//
//	// User 1's news feed should return a list with 1 tweet id -> [5],
//	// since user 1 is no longer following user 2.
//	twitter.getNewsFeed(1);
	   //private Map<Integer, LinkedList<Integer>> user2NewsFeed;//store all users and the list of their tweet ids
	    private Map<Integer, HashSet<Integer>> followerMap; //key is the follee and value is the follower, it records all the followers of a folloee;
	    private Map<Integer, HashSet<Integer>> user2TweetIds;
	    private Map<Integer, Integer> tweet2Time;
	    private int count;
	    

	    /** Initialize your data structure here. */
	    public Twitter() {
	       //user2NewsFeed = new HashMap<Integer, LinkedList<Integer>>();
	       followerMap = new HashMap<Integer, HashSet<Integer>>();
	       user2TweetIds = new HashMap<Integer, HashSet<Integer>>();
	       tweet2Time = new HashMap<Integer, Integer>();
	       count = 1;
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	        tweet2Time.put(tweetId, count++);
	        if(user2TweetIds.containsKey(userId)){
	            user2TweetIds.get(userId).add(tweetId);
	        }else{
	            HashSet<Integer> set = new HashSet();
	            set.add(tweetId);
	            user2TweetIds.put(userId, set);
	        }
	    }

	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	        List<TweetInfo> list = new ArrayList();
	        if(user2TweetIds.get(userId) != null && user2TweetIds.get(userId).size() > 0){
    	        for(Integer id: user2TweetIds.get(userId)){
    	            list.add(new TweetInfo(id,tweet2Time.get(id)));
    	        }	            
	        }
	        if(followerMap.get(userId) != null && followerMap.get(userId).size()>0){
    	        for(Integer followeeId : followerMap.get(userId)){
    	            if(user2TweetIds.get(followeeId) !=  null){
        	            for(Integer id: user2TweetIds.get(followeeId)){
        	                list.add(new TweetInfo(id, tweet2Time.get(id)));
        	            }    	                
    	            }

    	        }	            
	        }
	        List<Integer> res = new ArrayList();
	        
	        if(list.size() == 0) return res;
	        
	        Collections.sort(list, new Comparator<TweetInfo>(){
	            public int compare(TweetInfo t1, TweetInfo t2){
	                return t2.priority - t1.priority;
	            }
	            });
	        
	        int count = 0;
	        for(TweetInfo t: list){
	            res.add(t.tweetId);
	            count++;
	            if(count == 10) break;
	        }
	        return  res;
	    }

	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	        if(followerId == followeeId) return;
	        
	        if(followerMap.containsKey(followerId)){
	                followerMap.get(followerId).add(followeeId);
	        }else{
	            HashSet<Integer> set = new HashSet();
	            set.add(followeeId);
	            followerMap.put(followerId, set);
	        }
	        
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	        if(followerId == followeeId) return;
	        if(followerMap.containsKey(followerId)){
	            followerMap.get(followerId).remove(followeeId);
	        }
	    }
	    
	    class TweetInfo{
	        int tweetId;
	        int priority;
	        TweetInfo(int id, int priority){
	            this.tweetId = id;
	            this.priority = priority;
	        }
}


	public static void main(String[] args) {
		Twitter t = new Twitter();
		t.postTweet(2,5 );
		t.postTweet(1,3 );
		t.postTweet(1,101 );
		t.postTweet(2, 13);
		t.postTweet(2, 10);
		t.postTweet(1, 2);
		t.postTweet(2, 94);
		t.postTweet(2,505 );
		t.postTweet(1, 333);
		t.postTweet(1, 22);
		t.getNewsFeed(2);
		t.follow(2, 1);
		System.out.println(t.getNewsFeed(2));
	}

}
