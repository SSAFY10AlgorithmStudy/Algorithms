package KSY.personal.Prectice;

import java.util.*;
import java.io.*;

//62960KB	580ms

public class S2108_통계학 {
	
	class Number{
		int num, cnt;
		Number(int num, int cnt){
			this.num = num; this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
//		Map<Integer> map = new ArrayList<>();  //값, count
		double sum=0;
		
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			numbers[i] = num;
		}
		Arrays.sort(numbers);   //정렬
		
		//산술 평균
		sb.append(Math.round(sum/N)).append("\n");
		
		//중앙 값
		int index = N/2;  // 맞나?
		sb.append(numbers[index]).append("\n");
		
		//최빈 값
		if(N == 1) {
			sb.append(numbers[0]).append("\n");
		} else {
			int maxCnt = 0, tempCnt=0;
			int checkNum = numbers[0];
			List<Integer> answer[] = new ArrayList[N];
			
			for(int i=0; i<N; i++)
				answer[i] = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				if(numbers[i] == checkNum) {
					tempCnt++;
				} else {
					if(tempCnt >= maxCnt) {
						maxCnt = tempCnt;
						answer[tempCnt].add(numbers[i-1]);
					}
					checkNum = numbers[i];
					tempCnt = 1;
				}
				if(N != 1 && i == N-1)
					answer[tempCnt].add(numbers[i]);
			}
			
			for(int i=N-1; i>=0; i--) {
				if(answer[i].size() == 1) {
					sb.append(answer[i].get(0)).append("\n");
					break;
				} else if(answer[i].size() > 1) {
					sb.append(answer[i].get(1)).append("\n");
					break;
				}
			}
			
		}
		
		//범위
		sb.append(numbers[N-1] - numbers[0]);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
