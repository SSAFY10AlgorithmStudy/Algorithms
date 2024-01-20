package KSY.personal.Practice;

import java.util.*;
import java.io.*;

//11744KB/	84ms

public class S2667_단지번호붙이기 {
	
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					list.add(BFS(new Node(i, j)));
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int BFS(Node start) {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(start);
		int temp =0;
		visited[start.r][start.c] = true;
		while(!que.isEmpty()) {
			Node curr = que.poll();
			temp++;
			
			for(int d=0; d<4; d++) {
				int row = curr.r + dr[d];
				int col = curr.c + dc[d];
				if(-1 < row && row < N && -1 < col && col < N && map[row][col] == 1 && !visited[row][col]) {
					visited[row][col]= true;
					que.offer(new Node(row, col));
				}
			}
		}
		return temp;
	}
	
}

class Node{
	int r, c;
	Node(int r, int c){
		this.r = r; this.c = c;
	}
}