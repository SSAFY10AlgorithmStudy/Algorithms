package KSY.personal;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree1<T> { 
	private static Object[] tree;
	private final int SIZE;
	private int lastIndex=0;
	
	CompleteBinaryTree1(int size){
		this.SIZE = size;
		tree = new Object[SIZE+1];  //주의
	}
	
	public boolean add(T data) {
		if(lastIndex == SIZE)
			return false;
		tree[++lastIndex] = data;
		return true;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void BFS() {
		if(isEmpty())
			return;
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(1);
		
		while(!que.isEmpty()) {
			int current = que.poll();
			System.out.println(tree[current]);
			if(current*2 <= lastIndex)  // 주의
				que.offer(current*2);
			if(current*2+1 <= lastIndex)  // 주의
				que.offer(current*2+1);
		}
	}

	public static void main(String[] args) {
		CompleteBinaryTree1 tree = new CompleteBinaryTree1<Character>(9);

		for(int i=0; i<9; i++) {
			tree.add((char)(65+i));  // 65 == 'A'
		}
		tree.BFS();
	}

}
