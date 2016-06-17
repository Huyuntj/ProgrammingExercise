package com.java.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.java.algorithm.utility.PrintHelper;

public class CourseSchedule {
//	210. Course ScheduleII Medium
//	similar to problem 207
//	There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//	Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//	There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//	For example:
//
//	2, [[1,0]]
//	There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//	4, [[1,0],[2,0],[3,1],[3,2]]
//	There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
//
//	Note:
//	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i<numCourses;i++){
            edges[i] = new ArrayList<Integer>();
        }
        //initial edge list and indegree array
        for(int i = 0; i<prerequisites.length;i++){
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            edges[start].add(end);
            indegree[end]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque();
        for(int i = 0; i<numCourses;i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        //here, if no vertex has indegree 0, means there is a circle in it
        //no solution here is available to return;
        if(queue.isEmpty()) return new int[]{};
        int[] res = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            res[idx++] = top;
            for(int i = 0; i<edges[top].size();i++){
                int v = (Integer) edges[top].get(i);
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }
        //there is partial circle in it
        return (idx == numCourses)? res : new int[]{};
    }
	public static void main(String[] args) {
		int num = 2;
		int[][] pre = {{1,0},{0,1}};//{{1,0},{2,0},{3,1},{3,2}};
		CourseSchedule cs = new CourseSchedule();
		PrintHelper.print(cs.findOrder(num, pre));

	}

}
