package puzzle8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCost implements Search {
	private BoardNode initialNode;
	
	public UniformCost(BoardNode node) {
		this.initialNode = node;
	}
	
	private class gComparator implements Comparator<BoardNode>{
		
		public int compare(BoardNode a, BoardNode b) {
			return a.getMaxCost() - b.getMaxCost();
		}
	}
	
	public boolean search() {
		//UnifromCost search which creates a priority queue which sorts according to g(n)
		Info info = new Info();
		info.makePQueue(new gComparator()); //making a priority queue with gComparator
		BoardNode node = initialNode;
		info.pQueue.add(node);
		
		while(!(info.pQueue.isEmpty())) {
			node = info.pQueue.poll();
			info.incTime();
			info.visited.put(node.hashCode(), node);
			if(node.isGaol()) {
				PathActions p = new PathActions(initialNode,node,info); // class that creates a path from goal to start Node if goal is reached.
				p.printPath(); // the path is then printed
				return true;
			}
			
			Successor s = new Successor(); // Successor class created to provide next possible moves from current node
			List<BoardNode> list = s.successor(node); // list of potential children
			
			for(BoardNode temp: list) {
				boolean ans = info.visited.containsKey(temp.hashCode()); //Uses temporary node's hashCode to check if it has been expanded or not.
				if(ans==false) { //if it hasn't been expanded then we can now check if there is a node in the Priority Queue with a higher Cost
					if(!(info.pQueue.contains(temp))){
					info.pQueue.add(temp);
					info.pQueueSize();
					}
				}
			}
		}
		return false;
	}
}
