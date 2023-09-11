package KSY;

import java.util.*;
import java.io.*;

public class S2179_비슷한단어 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Map<String, List<String>> map = new HashMap<>();
		String maxString = "";
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<=str.length(); j++) {
				String sub = str.substring(0, j);
				List<String> list = map.putIfAbsent(sub, new ArrayList<>());
				if(list == null || !list.contains(str))
					map.get(sub).add(str);
				}
			}
		
		
		for(Map.Entry<String, List<String>> m: map.entrySet()) {
//			System.out.println("key : " + m.getKey() + " value : " + m.getValue());
			if(1 < m.getValue().size() && m.getKey().length() > maxString.length()) { // 문자열의 크기가 가장 크고, 해당하는 단어가 2개 이상일 때
//				System.out.println(maxString);
				maxString = m.getKey();
			}
		}
		
		sb.append(map.get(maxString).get(0)).append("\n");
		sb.append(map.get(maxString).get(1));
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
