package KSY.personal;

import java.util.*;
import java.io.*;

//public class Main {  // class start
public class Algo1_서울_19반_전자레인지 { // class start

	public static void main(String[] args) throws IOException { // main start
		Scanner sc = new Scanner(System.in); // 입력받기 위한 scanner
		int T = sc.nextInt(); // 맞춰야하는 시간
		int[] buttonValue = new int[] { 300, 60, 10 };

		// 만족하지 못 하는 경우
		if (T % 10 != 0) {
			System.out.println(-1);
			return;
		}

		// DFS(T); // T를 만족시키는 조합 찾기
		int[] answer = new int[3];
		for (int i = 0; i < 3; i++) {
			answer[i] += T / buttonValue[i];
			T %= buttonValue[i];
		}
		if (T == 0)
			System.out.println(answer[0] + " " + answer[1] + " " + answer[2]); // 출력
		else
			System.out.println(-1);
	} // main end

} // class end