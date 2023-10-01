package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//83912KB	2460ms

public class S1620_나는야포켓몬마스터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Map<Character, List<Monster>> dogam = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] monsters = new String[N+1];
		
		for(int i=1; i<=N; i++) {
			monsters[i] = br.readLine();
			char upper = Character.toUpperCase(monsters[i].charAt(0));
			dogam.putIfAbsent(upper, new ArrayList<>());
			dogam.get(upper).add(new Monster(i, monsters[i]));
		}
		for(int i=0; i<M; i++) {
			String question = br.readLine();
			try {
				int num = Integer.parseInt(question);
				sb.append(monsters[num]);
			} catch(Exception e) {
				char upper = Character.toUpperCase(question.charAt(0));
				for(Monster monster: dogam.get(upper)) {
					if(monster.name.equals(question)) {
						sb.append(monster.idx);
						break;
					}
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}

class Monster{
	int idx;
	String name;
	Monster(int idx, String name){
		this.idx = idx; this.name = name;
	}
}