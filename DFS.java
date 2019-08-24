package puzzle8;

import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class DFS implements Search {
	private BoardNode initialNode;
	
	//DFS constructor that creates the DFS object
	
	public DFS(BoardNode node) {
		this.initialNode = node;
	}
	
	
	public boolean search() { 
		Info info = new Info();
		
		BoardNode node = initialNode;
		info.stack.push(node);  // a stack is used to ensure LIFO
		
		while(!(info.stack.isEmpty())) {
			
			 node = info.stack.pop();
			 info.incTime();
			info.visited.put(node.hashCode(), node);
			if (node.isGaol()) {
				PathActions p = new PathActions(initialNode, node,info);
				p.printPath();
				return true;
			}
			Successor s = new Successor();
			List<BoardNode> list = s.successor(node);
			for(BoardNode temp: list) {
				boolean ans = info.visited.containsKey(temp.hashCode());
				if(ans==false ){
					if(!(info.stack.contains(temp))) { //checking the stack for duplicate children
						info.stack.push(temp);
						info.stackSize();
					}
					
				}
			}
			
		}
		
		return false;
	}
}
