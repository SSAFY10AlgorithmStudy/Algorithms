package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//11568KB/	76ms

public class S1676_팩토리얼0의개수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		if(N == 0) sb.append(0);
		else {
			int answer=0;
			while(N >= 5) {
				answer += N / 5;
				N /= 5;
			}
			sb.append(answer);
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
