package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//13644KB/	112ms

public class S2630_색종이만들기 {
	
	static int[][] map ;
	static int answer[] = new int[] {0, 0}; // white, blue
	static int[] dr = new int[] {1, 0, 0, 1};
	static int[] dc = new int[] {1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// map 입력받기
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(!checkSame(0, 0, N)) {
			divide(0, 0, N);
		}
		sb.append(answer[0]).append("\n").append(answer[1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	public static boolean checkSame(int row, int col, int size) {
		int start = map[row][col];
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j] != start) {
					return false;
				}
			}
		}
		answer[start]++;
		return true;
	}
	
	public static void divide(int row, int col, int size) {
		if(size == 1) {
			answer[map[row][col]]++;
			return;
		}
		int half = size/2;
		for(int d=0; d<4; d++) {
			int r = row + dr[d]*half;
			int c = col + dc[d]*half;
			if(!checkSame(r,c,half)) {
				divide(r, c, half);
			}
		}
	}
	

}
