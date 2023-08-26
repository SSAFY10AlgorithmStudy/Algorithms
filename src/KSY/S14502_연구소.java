package KSY;

import java.io.*;
import java.util.*;

//280624KB/	508ms

public class S14502_연구소 {
	static int index, N, M;
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	System.setIn(new FileInputStream("src/KSY/testcase.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];  // 후보가 될 수 있는 포인트 전부
        
        //map 입력
        List<Point> points = new ArrayList<>();
        Point[] candidates = new Point[N*M];
        index = 0;  // 후보 위치 개수
        int answer = 0;
        
        for(int i=0 ;i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 0) {
        			Point point = new Point(i, j);
        			points.add(point);
        			candidates[index++] = point;
        		}
        	}
        }
        
        
        // 후보 뽑기
        int[] p = new int[index];
        int idx = index-1;
        while(idx >= index-3) p[idx--] =1;
        do {
        	int tempAnswer = 0;
        	
        	//map copy
        	int[][] tempMap = new int[N][M];
        	for(int m=0; m<N; m++)
        		tempMap[m] = map[m].clone();
//        	for(int j=0; j<N; j++)
//        		System.out.println(Arrays.toString(tempMap[j]));
//        	System.out.println();
        	
        	// wall 3 up
        	for(int i=0; i<index; i++) {
        		if(p[i] == 1) {
        			Point point = points.get(i);
        			tempMap[point.r][point.c] = 1;
        		}
        	}
        	
        	// 탐색
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			if(tempMap[i][j] == 2) {  // 바이러스 발견 
        				BFS(tempMap, i, j);
        			}
        		}
        	}
        	
        	// safe zone count
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			if(tempMap[i][j] == 0) {
        				tempAnswer++;
        			}
        		}
        	}
        	
        	if(answer < tempAnswer)
        		answer = tempAnswer;
        	
        } while(NP(p));

        System.out.println(answer);
	}
    
    private static boolean NP(int[] p) {
    	int i = index-1;
    	while(i > 0 && p[i-1] >= p[i]) i--;
    	if(i == 0) return false;
    	
    	int j = index-1;
    	while(p[i-1] >= p[j]) j--;
    	swap(p, i-1, j);
    	
    	int k = index-1;
    	while(k > i)
    		swap(p, k--, i++);
    	return true;
    }
    
    private static void swap(int[] p, int i, int j) {
    	int temp = p[i];
    	p[i] = p[j];
    	p[j] = temp;
    }
    
    private static void BFS(int[][] map, int r, int c ) {
    	Queue<Point> que = new ArrayDeque<>();
    	que.offer(new Point(r, c));
    	while(!que.isEmpty()) {
    		Point curr = que.poll();
    		for(int d=0; d<4; d++) {
    			int row = curr.r + dr[d];
    			int col = curr.c + dc[d];
    			if(-1 < row && row < N && -1 < col && col < M && map[row][col] == 0) {
    				map[row][col] = 2;
    				que.offer(new Point(row, col));
    			}
    		}
    	}
    }

}

class Point{
	int r, c;
	Point(int r, int c){
		this.r = r; this.c = c;
	}
}