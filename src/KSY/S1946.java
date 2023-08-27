package KSY;

import java.io.*;
import java.util.*;

//300400KB/	1560ms

public class S1946 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/KSY/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {  // test case
			int N = Integer.parseInt(br.readLine());
			List<Candidate> candidates = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				candidates.add(new Candidate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
//			Arrays.sort(candidates);  //정렬 
			Collections.sort(candidates);
			
			int min = candidates.get(0).b; // 서류기준 오름차순 정렬된 것 중 1등 (index 0)d
			int answer = 1;  // 서류 1등 1명 카운트 
			for(int i=1; i<N; i++) {  // 2등부터 면접 결과확인 
				if(min > candidates.get(i).b) {  // 서류에서 큰 값을 가진 면접 점수와 비교 
					answer++;
					min = candidates.get(i).b;
				}
			}
			
//			sb.append(Arrays.toString(candidates)).append("\n");  // 답 입력 
			sb.append(answer).append("\n");  // 답 입력 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

class Candidate implements Comparable<Candidate>{
	int a, b;
	Candidate(int a, int b){
		this.a = a; this.b = b;
	}
	@Override
	public int compareTo(Candidate o) {  // 서류 기준으로 내림차순 정렬 
		if(a > o.a) return 1;
		else if(a < o.a) return -1;
		return 0;
	}
	@Override
	public String toString() {
		return a + " " + b;
	}
	
}