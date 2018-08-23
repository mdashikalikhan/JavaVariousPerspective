package com.gfg.ds.list;

import java.util.Scanner;

public class LinkedList {

	Node head;
	
	static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		int val;
		Node node = null;
		while((val = new Scanner(System.in).nextInt())!=-1){
			if(linkedList.head == null) {
				node = new Node(val);
				linkedList.head = node;
			} else {
				node.next = new Node(val);
				node = node.next;
			}
			
		}
		linkedList.push( -1);
		linkedList.append(-10);
		linkedList.insertAfter(linkedList.head.next.next.next, 9999);
		linkedList.printList(linkedList.head);
		
		/*Node nodeFirst = new LinkedList.Node(103);
		Node nodeSecond = new LinkedList.Node(2);
		Node nodeThird = new LinkedList.Node(309);
		linkedList.head = nodeFirst;
		nodeFirst.next = nodeSecond;
		nodeSecond.next = nodeThird;
		nodeThird.next = null;
		linkedList.printList(linkedList.head);*/

	}
	
	public void printList(Node node) {
		while(node != null){
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	/**
	 * 
	 * @param val
	 * insert a node with value @param val in front of the list
	 */
	public void push(int val){
		/*Node node = new Node(head.data);
		node.next = head.next;
		head.next = node;
		head.data = val;*/
		Node node = new Node(val);
		node.next = head;
		head = node;
	}
	
	/**
	 * 
	 * @param val
	 * Append a new node with avlue @param val at the end of the list
	 */
	public void append(int val){
		Node node = new Node(val);
		if(head == null){
			head = node;
			return;
		}
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = node;
	}
	
	/**
	 * 
	 * @param previousNode
	 * @param val
	 * insert a new node after a given previousNode
	 */
	public void insertAfter(Node previousNode, int val){
		if(previousNode==null){
			System.out.println("The given previousNode cannot be null.");
			return;
		}
		Node node = new Node(val);
		node.next = previousNode.next;
		previousNode.next = node;
	}

}
