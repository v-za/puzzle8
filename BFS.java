package puzzle8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS implements Search{
	
	private BoardNode initialNode;
	
	public BFS(BoardNode node) {
		this.initialNode = node;
	}
	
	
	public boolean search() {
		Info info = new Info(); // a class that has the visited HashMap, Queue, time and space

		BoardNode node = initialNode; 
		info.queue.add(node);  //start Node is added to queue
		
		while(!(info.queue.isEmpty())) {   //loop keeps going as long as queue is not empty
			
			 node = info.queue.remove();   //remove or pop the node and begin timer
			 info.incTime();
			info.visited.put(node.hashCode(), node);   //places node in visited hashMap
			if (node.isGaol()) {  //if goal is found, a path is created and a path is printed
				PathActions p = new PathActions(initialNode, node, info);
				p.printPath();
				return true;
			}
			Successor s = new Successor();  //successor function that provides node's children
			List<BoardNode> list = s.successor(node);
			for(BoardNode temp: list) {
				boolean ans = info.visited.containsKey(temp.hashCode());
				if(ans==false ){
					if(!(info.queue.contains(temp))) {
					info.queue.add(temp);
					info.queueSize();
					}
				}
			}

		}

		return false;
	}
	
	
}
