package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//11664KB/	76ms

public class S7568_덩치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Person[] people = new Person[N];
		int[] ranking = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			people[i] = new Person(x, y);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(people[i].x > people[j].x && people[i].y > people[j].y)
					ranking[j]++;
				else if(people[i].x < people[j].x && people[i].y < people[j].y)
					ranking[i]++;
			}
		}
		
		for(int i=0; i<N; i++)
			sb.append(ranking[i]+1).append(" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}

class Person{
	int x, y;
	Person(int x, int y){
		this.x = x; this.y = y;
	}
}