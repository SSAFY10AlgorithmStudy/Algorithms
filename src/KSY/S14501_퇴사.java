package KSY;

import java.util.*;
import java.io.*;

public class S14501_퇴사 {
	static int N;
	static int[][ metting;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		metting = new Node[N];
		metting = 
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			metting[i] = node;
		}
		
//		Arrays.sort(metting);
//		for(int i=0; i<N; i++)
//			System.out.println(metting[i]);
//		
//		int time = 0;
//		while(true) {
//		}

		
		for(int i=N-1; i>=0; i--) {
			
		}
		
	}
}

class Node implements Comparable<Node>{
	int t, p;
	Node(int t, int p) {
		this.t = t; this.p = p;
	}
	@Override
	public int compareTo(Node o) {
		if(t > o.t) return 1;
		else if(t < o.t) return -1;
		return 0;
	}
	@Override
	public String toString() {
		return t + " " + p;
	}
	
	
}
