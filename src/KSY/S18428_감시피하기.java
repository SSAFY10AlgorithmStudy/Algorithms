package KSY;

import java.util.*;
import java.io.*;

public class S18428_감시피하기 {
	
	static char[][] map;
	static int candi_length, N;
	static List<Position> teachers;
	static Queue<Position> que ;
	
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		List<Position> candidate = new ArrayList<Position>();
		teachers = new ArrayList<Position>();
		
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = line[j].charAt(0);
				if(map[i][j] == 'X')  // 벽 후보지
					candidate.add(new Position(i, j));
				else if(map[i][j] == 'T') {  // 선생님
					teachers.add(new Position(i, j));
				}
			}
		}
		
		candi_length = candidate.size();
		int[] p = new int[candi_length];
		int cnt = candi_length-1;
		while(cnt>=candi_length-3) p[cnt--] = 1;
		boolean answer = false;
		
		do {
			// map copy
			char[][] temp = new char[N][N];
			for(int m=0; m<N; m++) {
				temp[m] = map[m].clone();
			}
			// 3개 벽세우기
			for(int i=0; i<candi_length; i++) {
				if(p[i] == 1) {
					Position pos = candidate.get(i);
					temp[pos.r][pos.c] = 'O';
				}
			}
			if(check(temp)) {
				sb.append("YES");
				answer = true;
				break;
			}
				
			
		} while(NP(p));
		
		if(!answer)
			sb.append("NO");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	public static boolean check(char[][] map) {
		// 선생님 위치 복사
		que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<teachers.size(); i++) {
			Position teacher = teachers.get(i);
			que.offer(teacher);
			visited[teacher.r][teacher.c] = true;
		}
		
		// 맵 돌아보기
		for(int t=0; t<teachers.size(); t++) {
			Position teacher = teachers.get(t);
			
			for(int d=0; d<4; d++) {
				int row = teacher.r + dr[d];
				int col = teacher.c + dc[d];
				while(-1 < row && row < N && -1 < col && col < N) {
					if(map[row][col] == 'S') {
						return false;
					} else {
						if(map[row][col] == 'X' && !visited[row][col]) {
							visited[row][col] = true;
						}
					}
					row += dr[d];
					col += dc[d];
				}
			}
		}
		return true;
	}
	
	public static boolean NP(int[] p) {
		int i = candi_length-1;
		while(i > 0 && p[i-1]>=p[i]) i--;
		if(i == 0)
			return false;
		
		int j = candi_length-1;
		while(p[i-1] >= p[j]) j--;
		swap(p, i-1, j);
		
		int k=candi_length-1;
		while(k>i)
			swap(p, i++, k--);
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}

class Position{
	int r, c;
	Position(int r, int c){
		this.r = r; this.c = c;
	}
}