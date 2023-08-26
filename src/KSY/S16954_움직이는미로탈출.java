package KSY;

import java.io.*;
import java.util.*;

// 964940KB/	1520ms

public class S16954_움직이는미로탈출 {
	static int[] dr = new int[] {1, -1, 0, 0, 0, 1, 1, -1, -1};  // down, up, right, left, stay, ...대각선...
	static int[] dc = new int[] {0, 0, 1, -1, 0, 1, -1, -1, 1};
	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	System.setIn(new FileInputStream("src/KSY/testcase.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        char[][] map = new char[8][8]; // map 
//        boolean[][] visited = new boolean[8][8]; // visited
        List<Wall> walls = new ArrayList<>();
        
        for(int i=0; i<8; i++) {
        	String line = br.readLine();
        	for(int j=0; j<8; j++) {
        		map[i][j] = line.charAt(j);
        		if(map[i][j] == '#') {
        			walls.add(new Wall(i, j));  // 벽 정보 입력 
        		}
        	}
        }
        
        List<char[][]> maps = new ArrayList<>();  // 9개의 map 정보 저장
        maps.add(map);  // 첫번째 맵
        for(int i=1; i<=8; i++) {
        	char[][] preMap = maps.get(i-1);
        	char[][] temp = new char[8][8];
        	
        	//map 복사
        	Arrays.fill(temp[0], '.');
        	for(int j=0; j<7; j++) {
        		temp[j+1] = preMap[j].clone();
        	}
        	maps.add(temp);
        }
        
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {7, 0, 0});  // r, c, map no.
        while(!que.isEmpty()) {
        	int[] curr = que.poll();
        	int mapIdx = curr[2];
        	if(curr[2] > 8)
        		mapIdx = 8;
        	if(curr[0] == 0 && curr[1] == 7) {
        		System.out.println(1);;
        		return;
        	}
        	if(maps.get(mapIdx)[curr[0]][curr[1]] == '#')
        		continue;
        		
        	for(int d=0; d<9; d++) {
        		int row = curr[0] + dr[d];
        		int col = curr[1] + dc[d];
        		if(-1 < row && row < 8 && -1 < col && col <8 && maps.get(mapIdx)[row][col] == '.') { //&& !visited[row][col]
//        			visited[row][col] = true;
        			que.offer(new int[] {row, col, mapIdx+1});
        		}
        		
        	}
//        	visited[7][0] = true;
//        		// move wall
//        		for(int w=walls.size()-1; w>= 0 ; w--) {
//        			Wall wall = walls.get(w);
//        			if(wall.r + 1 > 7)
//        				walls.remove(w);
//        			else {
//        				map[wall.r][wall.c] = '.';
//        				wall.r++;
//        				map[wall.r][wall.c] = '#';
//        			}
//        			
//        		}
        }
        System.out.println(0);
        
	}

}
 
class Wall{
	int r, c;
	Wall(int r, int c){
		this.r = r; this.c = c;
	}
}