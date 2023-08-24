package KSY.personal.AlgoURa.주차7;

import java.util.Scanner;

public class MakeSpaceTest {

	static int space[][];
	static int white, green; // 종료조건에 만족하면 값을 누적한다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		space = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c = 0; c<N; c++) {
				space[r][c] = sc.nextInt();
			}
		}
		
		
		makeSpace(0, 0, N);
		System.out.println(white);
		System.out.println(green);
	}
	
	private static void makeSpace(int sr, int sc, int size) {  // 영역의 좌상단 r, c, 영역크기 size
		int sum = 0;
		
		for(int r=sr; r<sr+size; r++) {
			for(int c = sc; c<sc+size; c++) {
				sum += space[r][c];
			}
		}

		if(sum == 0) {  // 모두 하얀색인 공간(기저조건)
			white++;
		} else if(sum == size*size) {  //모두 초록색인 공간(기저조건)
			green++;
		} else {  // 두 색이 공존하는 공간
			int half = size/2;
			makeSpace(sr, sc, half); // 1
			makeSpace(sr, sc+half, half); // 2
			makeSpace(sr+half, sc, half); // 3
			makeSpace(sr+half, sc+half, half); // 4
		}
	}

}
