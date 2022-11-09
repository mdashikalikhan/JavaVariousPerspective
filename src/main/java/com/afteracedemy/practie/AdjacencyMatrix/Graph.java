package com.afteracedemy.practie.AdjacencyMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

	int[][] adjacencyMatrix;
	
	public Graph(int nodes) {
		adjacencyMatrix = new int[nodes][nodes];
		for(int i=0; i<nodes; i++) {
			Arrays.fill(adjacencyMatrix[i], 0);
		}
	}
	
	public void addEdge(int node1, int node2) {
		if(node1>=adjacencyMatrix.length || node2>=adjacencyMatrix.length || node1 < 0 || node2 < 0) {
			System.out.println("Invalid node");
			return;
		}
		adjacencyMatrix[node1][node2] = 1;
		adjacencyMatrix[node2][node1] = 1;
	}
	
	public void BFS(int startNode) {
		List<Integer> queue = new ArrayList<>();
		queue.add(startNode);
		
		
		int visited[] = new int[adjacencyMatrix.length];
		Arrays.fill(visited, 0);
		visited[startNode] = 1;
		while(!queue.isEmpty()) {
			int v = queue.get(0);
			queue.remove(0);
			System.out.println(v);
			
			for(int i=0; i<adjacencyMatrix.length; i++) {
				if(adjacencyMatrix[v][i]==1 && visited[i]==0) {
					queue.add(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(0, 3);
		graph.BFS(0);
	}
	
}

/*class Solution {
    public int knight(int A, int B, int C, int D, int E, 
                      int F) {
    	// write your awesome code here 
        LinkedList<String> queue = new LinkedList<>();
        int dx={-2,-2,-1,1,-1,1,2,2};
        int dy={1,-1,-2,-2,2,2,-1,1};
        Set<String> visited = new HashSet<>();
        int moves = 0;
        if(C==E && D==F){
            return moves;
        }
        String tmp = "";
        if(isInside(C,D,A,B)==1){
            tmp = C + "," +D;
            queue.push(tmp);
        }
        
        while(!queue.isEmpty()){
            String strV = queue.poll();
            visited.add(strV);
            int x = (int)strV.split(",")[0];
            int y = (int)strV.split(",")[1];
            for(int i=0; i<8; i++){
                if(isInside(x+dx[i],y+dy[i],A,B)==1){
                    tmp = (x+dx[i]) + "," + (y+dy[i]);
                    if( (x+dx[i]) ==E && y+dy[i]==F){
                        return moves + 1;
                    }
                    if(!visited.contains(tmp)){
                        visited.add(tmp);
                        queue.push(tmp);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    public int isInside(int x, int y, int A, int B){
        if(x<0 || y<0 || x>=A || y>=B){
            return 0;
        }
        return 1;
    }
}*/
