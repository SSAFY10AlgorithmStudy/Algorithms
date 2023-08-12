// https://www.acmicpc.net/problem/1525

package d0812;

import java.io.*;
import java.util.*;

// memory 118480kb time 1016ms
public class 퍼즐 {

	private static String goal;
	private static String curState;
	private static HashMap<String, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder goalbuilder = new StringBuilder();
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				goalbuilder.append(st.nextToken());
			}
		}
		goal = goalbuilder.toString();
		
		// bfs로 풀어보기
		Queue<String> q = new ArrayDeque<>();
		String firstState = "123456780"; 
		q.add(firstState);
		memo.put(firstState, 0);
		
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		int steps = 1;
		
		while (!q.isEmpty()) {
			curState = q.poll();
            steps = memo.get(curState)+1;
			if (curState.equals(goal)) {
				System.out.println(memo.get(goal));
                return;
			}
			
			
			int[][] curArr = buildArr(curState);

            // 4방향으로 bfs
			for (int r=0; r<3; r++) {
				for (int c=0; c<3; c++) {
					if (curArr[r][c] == 0) {
						for (int k=0; k<4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (nr >= 0 && nc >= 0 && nr < 3 && nc <3) {
                                // swapping
								curArr[r][c] = curArr[nr][nc];
								curArr[nr][nc] = 0;
								String nextArr = buildString(curArr); 
								if (memo.get(nextArr) == null || memo.get(nextArr) > steps) {
									q.add(nextArr);
									memo.put(nextArr,  steps);
								}
                                // swap back
                                curArr[nr][nc] = curArr[r][c];
                                curArr[r][c] = 0;
							}
						}
					}
				}
			}
			
		}
		
		if (memo.get(goal) == null) {
			System.out.println("-1");
		}

	}
	
	private static int[][] buildArr(String str2copy) {
		int[][] resarr = new int[3][3];
		
		for (int r=0; r<3; r++) {
			for (int c=0; c<3; c++) {
				resarr[r][c] = str2copy.charAt(r*3 + c) - '0';
			}
		}
		
		return resarr;
	}
	
	// 스트링 만들기
	private static String buildString(int[][] arr2copy) {
		StringBuilder arrbuilder = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arrbuilder.append(arr2copy[i][j]);
			}
		}
		
		return arrbuilder.toString();
	}
	
}