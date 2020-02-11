package com.hackerrank;


public class ResizableArray<T> {
	
	private T[] items = (T[])new Object[10];
	
	private int size=0;
	
	public int size() {
		return size;
	}
	
	public T get(int index) {
		
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		return items[index];
	}
	
	public void set(int index, T item) {
		if(index<0 || index>=size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		items[index] = item;
	}
	
	public void add(T item) {
		resizeArray();
		items[size] = item;
		size++;
	}
	
	private void resizeArray() {
		if(size==items.length) {
			T[] copy = (T[]) new Object[size + 100];
			System.arraycopy(items, 0, copy, 0, size);
			items = copy;
		}
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		for(int i=0; i<size; i++) {
			buff.append(items[i]);
			if(i!=size-1) {
				buff.append(",");
			}
			
		}
		buff.append("]");
		return buff.toString();

	}

	public static void main(String[] args) {
		ResizableArray<Integer> arr = new ResizableArray<>();
		arr.add(10); 
		arr.add(20);
		arr.add(30);
		System.out.println(arr);
	}
	
	

}
