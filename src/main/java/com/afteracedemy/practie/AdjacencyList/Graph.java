package com.afteracedemy.practie.AdjacencyList;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

	/**
	 * 
	 * 			Graph implementation with Adjacency List
	 * 
	 */
	
	private int nodes = 0;
	private LinkedList<Integer> adjacencyList[];
	
	public Graph(int nodes) {
		this.nodes = nodes;
		adjacencyList = new LinkedList[nodes];
		
		for(int i=0; i<nodes; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int node1, int node2) {
		adjacencyList[node1].add(node2);
	}
	
	void BFS(int startNode) {
		int[] visited = new int[nodes];
		Arrays.fill(visited, 0);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(startNode);
		visited[startNode] = 1;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.println(v);
			LinkedList<Integer> neighbors = adjacencyList[v];
			neighbors.stream().forEach(node->{
				if(visited[node]==0) {
					queue.add(node);
					visited[node] = 1;
					
				}
			});
		}
		
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println(Arrays.toString(graph.adjacencyList));
		
		graph.BFS(2);
	}
	
}
