package KSY.personal.Prectice;

import java.io.*;
import java.util.*;

// 317052KB/	852ms

public class S1780_종이의개수 {
	
	static int N, paper[][];
	static int zero=0, positive=0, negative=0;

	public static void main(String[] args) throws IOException { // main start
		System.setIn(new FileInputStream(new File("testcase.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BR
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BW
		StringBuilder sb = new StringBuilder(); // SB

		N = Integer.parseInt(br.readLine());  // N x N 종이
		paper = new int[N][N];
		
		//입력 받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 0, N);
		bw.write(sb.append(negative).append("\n").append(zero).append("\n").append(positive).toString());
		bw.flush();
		bw.close();
		

	}
	
	private static boolean checkAllSame(int r, int c, int size) {  // size x size 종이의 내용이 모두 같은지 확인
		int first = paper[r][c];
		
		for(int i=r; i < r+size; i++) {
			for(int j=c; j <c+size; j++) {
				if(paper[i][j] != first)
					return false;
			}
		}
		return true;
	}
	
	private static void DFS(int r, int c, int size) {
		if(size == 1 || checkAllSame(r, c, size)) {  // 1이거나 모든 내용이 같다면
			switch(paper[r][c]) {
			case -1:
				negative++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				positive++;
			}
			return;
		} else {
			//9개로 나눠서 
			for(int i=r; i<r+size; i+=size/3) {
				for(int j=c; j<c+size; j+=size/3) {
					DFS(i, j, size/3);
				}
			}
			
		}
			
	}

}
