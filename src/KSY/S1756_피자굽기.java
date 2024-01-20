package KSY;

import java.util.*;
import java.io.*;

public class S1756_피자굽기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb =new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());  // 오븐 깊이
		int N = Integer.parseInt(st.nextToken());  // 반죽의 개수
		
		int[] oven = new int[D];
		
		st = new StringTokenizer(br.readLine());
		for(int d=0; d<D; d++) {
			oven[d] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int idx = D-1;
		for(int i=0; i<N; i++) {  // 피자 도우
			int pizza = Integer.parseInt(st.nextToken());
			
			for(int j=idx; j>=0; j--){
				
			}
		}
		
		

	}

}
