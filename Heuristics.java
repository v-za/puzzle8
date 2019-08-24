package puzzle8;

import java.awt.List;
import java.util.ArrayList;

public class Heuristics {
	
	//heuristic class that creates both heuristics
	
	public Heuristics() {
		
	}
	
	//First Heuristic which tells us how many tiles are in an incorrect position
	
	public int numCorPos(BoardNode node) {
		int [][] goal = {{1,2,3},{8,0,4},{7,6,5}};
		int result = 0;
		int [][] state = node.getMatrix();
		for(int i=0; i<state.length; i++) {
			for(int j=0; j<state.length; j++) {
				if(goal[i][j]!=state[i][j]) {
					result += 1;
				}
			}
		}
		return result;
	}

	public int manhattan(BoardNode node) {   //second heuristic which uses a goal state to help determined how far argument node tiles are from desired position
		int [][]goal = {{1,2,3},{8,0,4},{7,6,5}};
		int result = 0;
		int [][]state = node.getMatrix();
		for(int i=0; i<state.length; i++) {
			for(int j=0; j<state.length; j++) {
				int value = state[i][j];
				result += Math.abs(i - node.getRow(value)) + Math.abs(j - node.getCol(value)); 
			}
		}
		return result;
	}
	
	
	

}
