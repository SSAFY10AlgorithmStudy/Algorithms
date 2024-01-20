package KSY.personal.Practice;

import java.io.*;
import java.util.*;

public class S15657_N과M8 {
	
	static int N, M;
	static int[] numbers, answer;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		do {
			String temp = "";
			for(int i=0; i<M; i++) {
				temp += numbers[i] + " ";
			}
			if(!set.contains(temp)) {
				set.add(temp);
				sb.append(temp);
			}
		} while(NP(numbers));
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean NP(int[] p) {
		int i= N-1;
		while(i>0 && p[i-1] <= p[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] > p[j]) j--;
		swap(p, i-1, p[j]);
		
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = p[i];
	}
}
