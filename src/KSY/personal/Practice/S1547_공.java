package KSY.personal.Practice;

import java.io.*;
import java.util.*;

public class S1547_공 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int answer = 1;
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == answer) {
				if(a == 1 | a == 2 | a == 3)
					answer = b;
				else {
					System.out.print(-1);
					return;
				}
					
			} else if(b == answer) {
				if(b == 1 | b == 2 | b == 3)
					answer = a;
				else {
					System.out.print(-1);
					return;
				}
			}
		}
		System.out.print(answer);

	}

}
