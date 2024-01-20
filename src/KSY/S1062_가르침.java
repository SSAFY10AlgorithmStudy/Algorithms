package KSY;

import java.util.*;
import java.io.*;

//35656KB/	472ms

public class S1062_가르침 {
	
	static int K, N, answer=0;
	static boolean[] alpha;
	static Set<List<Integer>> alph;  // 필요한 알파벳 모음의 set

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 5;  // 필수 문자 제외 가르칠 수 있는 문자
		
		alpha = new boolean[26];
		alpha[0] = true; // a
		alpha['c'-'a'] = true; // c
		alpha['n'-'a'] = true; // n
		alpha['t'-'a'] = true; // t
		alpha['i'-'a'] = true; // i
//		System.out.println(Arrays.toString(alpha));
		
		
		alph = new HashSet<>();
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			int wordLen = word.length();
			List<Integer> list = new ArrayList<>();
			for(int j=3; j<wordLen-4; j++) {
				list.add(word.charAt(j)-'a');
			}
			alph.add(list);
		}
		
		DFS(0, 1);
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
	
	private static void DFS(int cnt, int idx) {
		if(cnt == K) {
			int ans =checkword();
			if(ans > answer)
				answer = ans;
			return;
		}
		
		for(int i=idx; i<26; i++) {
			if(!alpha[i]) {  //선택하지 않은 알파벳이라면
				alpha[i] = true;
				DFS(cnt+1, i);
				alpha[i] = false;
			}
		}
		
	}
	
	private static int checkword() {
		int ans = 0;
		for(List<Integer> temp: alph) {
			boolean flag = false;
			for(int idx:temp) {
				if(!alpha[idx]) {  // 하나라도 없다면 불가능
					flag = true;
					break;
				}
			}
			if(!flag)
				ans++;
		}
		return ans;
	}
}
