package puzzle8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Info {
		//info class that is used in every search 
	public Queue<BoardNode> queue; // this class has datastructures such as queue, stack, and priority Queue in order to keep track of time, space and which nodes are in the queue 
	public Stack<BoardNode> stack;
	public PriorityQueue<BoardNode> pQueue;
	public int time;
	private int maxQueueSize;
	public HashMap<Integer,BoardNode> visited; 
	
	
	public Info() {
		queue = new LinkedList<BoardNode>();
		stack = new Stack<BoardNode>();
		pQueue = new PriorityQueue<BoardNode>();
		time = 0;
		maxQueueSize = 0;
		visited = new HashMap<Integer,BoardNode>();
		
		
		
	}
	
	public void  makePQueue(Comparator c) {   //creates a prioirty queue with a comparator as an argument to decidee the order in which the queue will organize elements
		pQueue = new PriorityQueue<BoardNode>(c);
	}
	
	public void incTime() {  //timer method that begins timer
		time += 1;
	}
	
	public void queueSize() {   //queue size that constantly checks for maximum size, this will tell us the space
		if(queue.size()>maxQueueSize) {
			maxQueueSize = queue.size();
		}
	}
	
	public void stackSize() {   //behaves similar to queueSize() but for stack
		if(stack.size()>maxQueueSize) {
			maxQueueSize = stack.size();
		}
	}
	
	public void pQueueSize() {  //behaves similar to queueSize() but for priority queue
		if(pQueue.size()>maxQueueSize) {
			maxQueueSize = pQueue.size();
		}
	}
	
	public int getTime() { //time is returned
		return time;
	}
	
	public int getSpace() {  //space is returned
		return maxQueueSize;
	}
	
}
