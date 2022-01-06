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
