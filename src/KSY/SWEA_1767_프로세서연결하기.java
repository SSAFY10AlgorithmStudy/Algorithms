package KSY;

import java.io.*;
import java.util.*;

public class SWEA_1767_프로세서연결하기 {
	
	static List<Core> cores = new ArrayList<>();
	static int answer = 0, N;
	
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/testcase.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) { // test case
			int answer = 0;  // 전선의 총 길이 
			N = Integer.parseInt(br.readLine());  // map 크기 
			int[][] map = new int[N][N];  // map
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {  // core is
						cores.add(new Core(i, j));
					}
				}
			}
			
			Backtracking(map, 0, 0);
			
			
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		} // end test case
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void Backtracking(int[][] map, int coreIndex, int sum) {
		if(sum > answer)  // backtracking : 지금까지 발견된 것보다 크다면 더이상 탐색 x
			return;
		if(coreIndex >= cores.size()) {  // 기저조건 : 모든 core를 연결함 
			if(answer > sum)
				answer = sum;
			return;
		}
		//map copy
		int[][] tempMap = new int[N][N];
		for(int i=0; i<N; i++)
			tempMap[i] = map[i].clone();
		
		for(int d=0; d<4; d++) {  //4방향
			int check = checkConnection(tempMap, coreIndex, d);
			if( check == -1) { // 실패
				// map 그대로 사용 
			} else {  // 성공 
				//tempMap 사용 
				Backtracking(tempMap, coreIndex+1, sum+check);
				
			}
			
		}
		
		//해당 코어 선택 안 함 
		checkConnection(map, coreIndex+1, sum);
	}
	
	private static int checkConnection(int[][] tempMap, int coreIndex, int dir) {
		Core core = cores.get(coreIndex);
		int cnt=0;
		int row =core.r + dr[dir];
		int col =core.c + dc[dir];
		while(-1 < row && row < N && -1 < col && col < N && tempMap[row][col] ==0) {
			tempMap[row][col] = 2; 
			cnt++;
			row += dr[dir];
			col += dc[dir];
		}
		if(row < 0 || row > N-1 || col < 0 || col > N-1)
			return cnt;
		else
			return -1;
	}

}

class Core{
	int r, c;
	Core(int r, int c){
		this.r = r; this.c = c;
	}
}