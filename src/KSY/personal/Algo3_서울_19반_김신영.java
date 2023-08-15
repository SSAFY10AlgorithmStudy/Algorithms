package KSY.personal;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo3_서울_19반_김신영 {  // 클래스 시작

	public static void main(String[] args) throws IOException {  // 메인 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //입력받기 위한 BR
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());  // 2^K 크기의 K값
		StringTokenizer st = new StringTokenizer(br.readLine());  // 2*k개의 연산 입력
		String[] Operater = new String[2*K];
		
		for(int i=0; i<2*K; i++) {  // 연산 수행
			Operater[i] = st.nextToken();   //연산
		}
		int[][] paper = new int[1][1];
		paper[0][0] = Integer.parseInt(br.readLine());  // 구멍 뚫기
		
		for(int i=2*K-1; i >= 0; i--) {  //반대로 연산
			paper = DFS(paper, Operater[i]);
		}
			//paper 출력
			for(int j=0; j<paper.length; j++) {
				for(int k=0; k<paper[0].length; k++)
					sb.append(paper[j][k]).append(" ");			
				sb.append("\n");
			}
			System.out.println(sb);

	}  // 메인 끝
	
	public static int[][] DFS(int[][] paper, String op) {
		int[][] newPaper = paper;  // 기존 2배만큼 배열 생성
		switch(op) {
		case "R":  // 왼쪽으로 펴기
			newPaper = new int[paper.length][paper[0].length*2];
			//원배열 복사
			for(int i=0; i<paper.length; i++) {
				System.arraycopy(paper[i], 0, newPaper[i], newPaper[0].length/2, paper[0].length); // paper vs paper[0] 주의
			}
			// 반대편 수행
			for(int i=paper.length-1; i>=0; i--) {
				for(int j=paper[0].length-1; j>=0; j--) {
					switch(paper[i][j]) {
					case 0:
						newPaper[i][paper[0].length-j-1] = 1;
						break;
					case 1:
						newPaper[i][paper[0].length-j-1] = 0;
						break;
					case 2:
						newPaper[i][paper[0].length-j-1] = 3;
						break;
					case 3:
						newPaper[i][paper[0].length-j-1] = 2;
						break;
					}
				}
			}
			
			break;
		case "L": // 오른쪽으로 펴기
			newPaper = new int[paper.length][paper[0].length*2];
			
			//원배열 복사
			for(int i=0; i<paper.length; i++) {
				System.arraycopy(paper[i], 0, newPaper[i], 0, paper[0].length); // paper vs paper[0] 주의
			}
			// 반대편 수행
			for(int i=paper.length-1; i>=0; i--) {
				for(int j=0; j<paper[0].length; j++) {
					switch(paper[i][j]) {
					case 0:
						newPaper[i][newPaper[0].length-j-1] = 1;
						break;
					case 1:
						newPaper[i][newPaper[0].length-j-1] = 0;
						break;
					case 2:
						newPaper[i][newPaper[0].length-j-1] = 3;
						break;
					case 3:
						newPaper[i][newPaper[0].length-j-1] = 2;
						break;
					}
				}
			}			
			
			break;
		case "D":  // 위로 펴기
			newPaper = new int[paper.length*2][paper[0].length];
			
			//원배열 복사
			for(int i=0; i<paper.length; i++) {
				System.arraycopy(paper[i], 0, newPaper[paper.length+i], 0, paper[0].length); // paper vs paper[0] 주의
			}
			// 반대편 수행
			for(int i=0; i<paper.length; i++) {
				for(int j=0; j<paper[0].length; j++) {
					switch(paper[i][j]) {
					case 0:
						newPaper[paper.length-i-1][j] = 2;
						break;
					case 1:
						newPaper[paper.length-i-1][j] = 3;
						break;
					case 2:
						newPaper[paper.length-i-1][j] = 0;
						break;
					case 3:
						newPaper[paper.length-i-1][j] = 1;
						break;
					}
				}
			}		
			
			break;
		case "U":  // 아래로 펴기
			newPaper = new int[paper.length*2][paper[0].length];
			
			//원배열 복사
			for(int i=0; i<paper.length; i++) {
				System.arraycopy(paper[i], 0, newPaper[i], 0, paper[0].length); // paper vs paper[0] 주의
			}
			// 반대편 수행
			for(int i=0; i<paper.length; i++) {
				for(int j=0; j<paper[0].length; j++) {
					switch(paper[i][j]) {
					case 0:
						newPaper[newPaper.length-i-1][j] = 2;
						break;
					case 1:
						newPaper[newPaper.length-i-1][j] = 3;
						break;
					case 2:
						newPaper[newPaper.length-i-1][j] = 0;
						break;
					case 3:
						newPaper[newPaper.length-i-1][j] = 1;
						break;
					}
				}
			}
			
			break;
		}
		return newPaper;
	}

} // 클래스 끝
