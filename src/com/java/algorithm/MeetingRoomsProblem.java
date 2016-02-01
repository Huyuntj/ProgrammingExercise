package com.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class MeetingRoomsProblem {

	public class Interval{
		int start;
		int end;
		public Interval(){ start = 0; end = 0;}
		public Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	public int meetingRooms2(Interval[] intervals){
		if(intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return (a.start - b.start);
            }
        });		
        List<Interval> input =  new ArrayList<Interval>(Arrays.asList(intervals));
        int i = 0;
        while(i < input.size()){
        	Interval in = input.get(i);
        	Interval pre = in;
        	if(i == input.size() -1) break;
        	Iterator<Interval> it = input.subList(i+1, input.size()).iterator();
        	while(it.hasNext()){
        		Interval next = it.next();
        		if(next.start >= pre.end){
        			it.remove();
//        			input.remove(next);
        		}
        		pre = next;
        	}
        	i++;
        }
        return input.size();
        
	}	
	@SuppressWarnings("rawtypes")
	public int meetingRooms(Interval[] intervals){
		if(intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return (a.start - b.start);
            }
        });		
        int room = 0;
//        List<ArrayList<Interval>> res = new ArrayList<ArrayList<Interval>>();
        int i = 0;
        boolean[] visited = new boolean[intervals.length];
        while(i<intervals.length){
        	@SuppressWarnings("unchecked")
			ArrayList<Interval> list = new ArrayList();
        	int pre = 0;
        	if(visited[i]== false){
        		pre = i;
            	visited[i] = true;
            	list.add(intervals[i++]);
        	}else{
        		i++;
        		continue;
        	}
        	int j = i;
        	while(j < intervals.length){
        		if(visited[j] == false && intervals[j].start >= intervals[pre].end){
        			visited[j] = true;
        			pre = j;
        			list.add(intervals[j]);
        		}
        		j++;
        	}
        	room++;
//        	res.add(list);
        }
        return room;
	}
	
    public int minMeetingRoomsRecusive(Interval[] intervals) {
		if(intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return (a.start - b.start);
            }
        });		
        return helper(new ArrayList<Interval>(Arrays.asList(intervals)));
    }
    private int helper(List<Interval> list){
        if(list.size() == 0) return 0;
        Interval in = list.get(0);
        ArrayList<Interval> l = new ArrayList();
        for(int i = 1; i<list.size();i++){
            if(list.get(i).start < in.end){
                l.add(list.get(i));
            }else{
                in = list.get(i);
            }
        }
        return 1 + helper(l);
    }	
    
    public int minMeetingRoomsWithTreeMap(Interval[] intervals){
    	TreeMap<Integer, Integer> map = new TreeMap();
    	for(Interval in : intervals){
    		if(!map.containsKey(in.start)) map.put(in.start, 1);
    		else map.put(in.start, map.get(in.start)+1);
    		
    		if(!map.containsKey(in.end)) map.put(in.end, -1);
    		else map.put(in.end, map.get(in.end)-1);    		
    	}
    	int max = 0;
    	int cur = 0;
    	for(Integer key : map.keySet()){
    		cur += map.get(key);
    		max = Math.max(max, cur);
    	}
    	return max;
    }
    private static final int START = 1;

    private static final int END = 0;

    private class Event {
        int time;
        int type; // end event is 0; start event is 1

        public Event(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
  
    public int minMeetingRoomWithPriorityQueue(Interval[] intervals){
        int rooms = 0; // occupied meeting rooms
        int res = 0;

        // initialize an event queue based on event's happening time
        @SuppressWarnings({ "unchecked", "rawtypes" })
		Queue<Event> events = new PriorityQueue(new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                // for same time, let END event happens first to save rooms
                return e1.time != e2.time ? 
                       e1.time - e2.time : e1.type - e2.type;
            }
        });

        // create event and push into event queue
        for (Interval interval : intervals) {
            events.offer(new Event(interval.start, START));
            events.offer(new Event(interval.end, END));
        }

        // process events
        while (!events.isEmpty()) {
            Event event = events.poll();
            if (event.type == START) {
                rooms++;
                res = Math.max(res, rooms);
            } else {
                rooms--; 
            }
        }

        return res;
      	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingRoomsProblem mrp = new MeetingRoomsProblem();
		Interval[] intervals = {
				mrp. new Interval(0,30), mrp. new Interval(5,10), mrp.new Interval(15,20)};
		Interval[] intervals2 = {
				mrp. new Interval(1,5), mrp. new Interval(8,9),mrp. new Interval(8,9)};
		System.out.println(mrp.minMeetingRoomsWithTreeMap(intervals));
		System.out.println(mrp.minMeetingRoomWithPriorityQueue(intervals));
	}

}
