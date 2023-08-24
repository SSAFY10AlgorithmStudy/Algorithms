package KSY.personal.AlgoURa.주차7;

import java.util.Scanner;

// 같은 행에는 퀀을 놓지 않는 버전
// 놓아진 원의 열번호를 기록하는 버전
public class NQueenTest1 {
	
	static int N, col[], ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // static
		col = new int[N+1];  // 1열부터 사용
		ans = 0;  // 가능한 경우의 수

		setQueen(1);
		System.out.println(ans);
		}
	
	// 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
	private static void setQueen(int row) {  // 변하는 값  = 행 = 매개변수, row : 퀀을 놓으려는 행
		
		//가지치기 : 직전까지 놓아진 형태로
		if(!isPromissing(row-1))
			return;
		
		// 기저 조건
		if(row>N) {
			ans++;
			return;
		}
		
		// 유도파트
		for(int c=1; c<=N; c++) {  // 1열부터 N열까지 시도
			col[row] = c;
			setQueen(row+1);
		}
	}
	
	private static boolean isPromissing(int row) {  // row : 마지막으로 놓아진 퀀의 행
		for(int i=1; i<row; i++) {
			if(col[i] == col[row] || row-i == Math.abs(col[row]-col[i]))  // 대각선에 있다 = 행차이와 열차이가 같다
				return false;
		}
		return true;
	}

}
