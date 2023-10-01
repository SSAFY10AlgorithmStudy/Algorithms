package KSY;

import java.util.*;
import java.io.*;

//37968KB	1992ms

public class S2179_비슷한단어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Map<String, List<Candi>> map = new HashMap<>();
		String maxString = "";
		int minIndex = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());  // 문자 개수 
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Candi candi = new Candi(i, str);
			for(int j=0; j<=str.length(); j++) {  // 해당 문자열의 subString
				String sub = str.substring(0, j);
				List<Candi> list = map.putIfAbsent(sub, new ArrayList<>());
				if(list == null || !list.contains(candi))  // 같은 단어 제외 
					map.get(sub).add(candi);
				}
			}
		
		for(Map.Entry<String, List<Candi>> m: map.entrySet()) {
//			System.out.println("key : " + m.getKey() + " value : " + m.getValue());
			if(1 < m.getValue().size()) {  // 리스트 크기가 1이상 
				if(m.getKey().length() > maxString.length() || (m.getKey().length() == maxString.length() && m.getValue().get(0).idx < minIndex)) {
				// 문자열의 크기가 가장 크고, 해당하는 단어가 2개 이상일 때
//				System.out.println(maxString);
				maxString = m.getKey();
				minIndex = m.getValue().get(0).idx;
				}
			}
			
		
		}
		sb.append(map.get(maxString).get(0).str).append("\n");
		sb.append(map.get(maxString).get(1).str);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

class Candi{ // implements Comparable<Candi>{
	int idx;
	String str;
	Candi(int idx, String str){
		this.idx = idx; this.str = str;
	}
	@Override
	public boolean equals(Object obj) {
		return str.equals(((Candi)obj).str);
	}
	
}