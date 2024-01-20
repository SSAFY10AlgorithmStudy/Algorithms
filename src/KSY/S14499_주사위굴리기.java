package KSY;

import java.util.*;
import java.io.*;

public class S14499_주사위굴리기 {
	
	// 방향 (1:동, 2:서, 3:북, 4:남)
	static int[] dr = new int[] {0, 0, -1, 1};
	static int[] dc = new int[] {1, -1, 0, 0};
	
	// 주사위 위치
	static List<Point7> points = new ArrayList<>();
	// 각 주사위 위치별 방향 숫자
	int[] east = new int[] {4, };
	int[] west = new int[] {};
	int[] north = new int[] {};
	int[] south = new int[] {};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		points.add(new Point7(0, 0));  // 더미
		points.add(new Point7(1, 1));
		points.add(new Point7(0, 1));
		points.add(new Point7(1, 2));
		points.add(new Point7(1, 0));
		points.add(new Point7(2, 1));
		points.add(new Point7(3, 1));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//dice
		int[][] dice = new int[4][3];
		// dice의 상단/하단
		Point7 up = points.get(1);
		Point7 down = points.get(6);
		
		//map
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방향 (1:동, 2:서, 3:북, 4:남)
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int op = Integer.parseInt(st.nextToken());
			
		}

	}

}

class Point7{
	int r, c, value=0;
	Point7(int r, int c){
		this.r = r; this.c = c;
	}
}