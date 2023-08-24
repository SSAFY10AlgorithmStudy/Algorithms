package KSY.personal.AlgoURa.주차8;

import java.util.Arrays;

public class DisjoinSetTest {
	
	static int N;  // 초기 집합의 개수
	static int parents[];
	
	private static void make() {
		parents = new int[N];
		for(int i=0; i< N; i++) {
			parents[i] = i;  // 모든 요소는 자기만 원소로 갖는 단위 서로소 집합이 되게 한다.(자신이 곧 대표자, 루트로 표현)
		}
	}
	
	private static int find(int a) {
		// path compression 1
//		if(a != parents[a]) {
//			parents[a] = find(parents[a]);  // path compression
//		}
//		return parents[a];
		
		// path compression 2
		// 경로압축이 일어난다고 Rank에 변화가 생기지 않는다.
		// Rank 관리가 쉽지 않다 => 매번 find에서 변경시 오버헤드가 생길 수 있다.
		// Rank 관리를 Union에서 하고, find할 때는 수행하지 않는 것이 대부분의 코딩 방식이다.
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
		
		
		// Before 최적화
//		if(a == parents[a]) return a;
//		return find(parents[a]);
	}
	
	private static boolean union(int a, int b) {  // a가 속한 집합과 b가 속한 집합을 합칠 수 있다면 합치고 true 반환, 아니면 false 반
		int aRoot = find(a);
		int bRoot = find(b);
		
		//teacher
		if(aRoot == bRoot) return false; // 서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음.
		//union 처리( bRoot를 aRoot 아래로 붙이기!! : 임의로 ...)
		parents[bRoot] = aRoot;
		return true;
		
	}
	 

	public static void main(String[] args) {
		N = 5;
		make();
//		System.out.println("find(0) :" + find(0));
//		System.out.println("find(1) :" + find(1));
//		System.out.println("find(2) :" + find(2));
//		System.out.println("find(3) :" + find(3));
//		System.out.println("find(4) :" + find(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(parents));
		
		System.out.println("\n=======find========");
		System.out.println(find(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(find(1));
		System.out.println(Arrays.toString(parents));

	}

}
