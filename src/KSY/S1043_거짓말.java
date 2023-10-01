package KSY;

import java.io.*;
import java.util.*;

//11752KB/	80ms

public class S1043_거짓말 {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int answer=0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		parents = new int[N+1]; // 속한 파티 집합
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 거짓말 아는 사람 수
		boolean[] knows = new boolean[N+1];
		for (int k = 0; k < K; k++) {
			knows[ Integer.parseInt(st.nextToken())] = true;  // 거짓말을 아는 사람 표시
		}
		
		List<List<Integer>> parties = new ArrayList<>();  // 파티 리스트
		for (int i = 0; i < M; i++) { // 파티 입력 받기
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // 파티 인원

			List<Integer> party = new ArrayList<>();
			for (int j = 0; j < cnt; j++) {
				int temp = Integer.parseInt(st.nextToken());
				party.add(temp);
				
				if(j < 1)  // 1개 이하
					continue;
				
				union(party.get(j-1), temp);  // 둘이 같은 집단에 속해있다
			}
			parties.add(party);
		}
		
		for(int i=0; i<M; i++) {  // 파티
			for(int person:parties.get(i)) {
				if(knows[person]) {
					for(int j=1; j<=N; j++) {
						if(find(j) == find(person)) {
							knows[j] = true;
						}
					}
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			boolean flag= false;
			for(int person:parties.get(i)) {
				if(knows[person]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				answer++;
			}
		}
		
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static boolean union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		if(rootx == rooty)
			return false;
		
		if(rootx < rooty) {
			parents[rooty] = rootx;
		} else {
			parents[rootx] = rooty;
		}
		return true;
	}
	
	public static int find(int x) {
		if(parents[x] != x) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}


}
