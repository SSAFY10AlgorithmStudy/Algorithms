package KSY;

import java.util.*;
import java.io.*;

//32424KB	556ms

public class S14500_테크노미로 {
	
	static int[][] map;
	static int answer=0, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[][]> que = new ArrayDeque<>();
		que.offer(new int[][] {{1, 1, 1, 1}});  // 도형1
		que.offer(new int[][] {{1, 1}, {1, 1}});  // 도형2
		que.offer(new int[][] {{1, 0}, {1, 0}, {1, 1}});  // 도형3
		que.offer(new int[][] {{1, 0}, {1, 1}, {0, 1}});  // 도형4
		que.offer(new int[][] {{0, 1}, {1, 1}, {1, 0}});  // 도형4-2
		que.offer(new int[][] {{0, 1}, {0, 1}, {1, 1}});  // 도형3-2
		que.offer(new int[][] {{1, 1, 1}, {0, 1, 0}});  // 도형5
		que.offer(new int[][] {{0, 1, 0}, {1, 1, 1}});  // 도형5
		
		while(!que.isEmpty()) {
			int[][] curr = que.poll();
			check(curr);
			direc4(curr, 0);
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	
	public static void direc4(int[][] miro, int d) {
		if(d < 3) {
			int[][] newmiro = new int[miro[0].length][miro.length];// 90도 돌린 도형
			for(int i=0; i<miro[0].length; i++) {
				for(int j=miro.length-1; j>=0; j--) {
					newmiro[i][miro.length-j-1] = miro[j][i];
				}
			}
			check(newmiro);
			direc4(newmiro, d+1);
		}
	}
	
	public static void check(int[][] miro) {
		for(int i=0; i<=N-miro.length; i++) {
			for(int j=0; j<=M-miro[0].length; j++) {
				int temp = 0;
				
				for(int k=0; k<miro.length; k++) {
					for(int l=0; l<miro[0].length; l++) {
						if(miro[k][l] == 1) {
							temp += map[i+k][j+l];
						}
					}
				}
				if(answer < temp)
					answer = temp;
				
			}
		}
	}

}

//class Miro{
//	int[][] miro;
//	boolean flag =false;  // 뒤집기 함
//	Miro(int[][] miro){
//		this.miro = miro;
//	}
//}