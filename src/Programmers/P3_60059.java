package Programmers;

import java.awt.*;
import java.util.*;


class P3_60059 {
    public int[][] copyMap(int key[][]){ //맵복사
    int M = key.length;
    int temp[][] = new int[M][M];
    for(int i=0; i<M ; i++){
        for(int j=0;j<M ; j++){
            temp[i][j] = key[i][j];
        }
    }
    return temp;
    }
    public ArrayList<Point> find(int[][] key){ //열쇠 찾아서 리스트로 반환
        ArrayList<Point> temp = new ArrayList<Point>();
        int M = key.length;
        for(int i=0; i<M ; i++){
            for(int j = 0; j<M; j++){
                if(key[i][j] == 1){
                    temp.add(new Point(j,i));
                }
            }
        }
        
        return temp;
    }
    public boolean realCheck(int [][]lock){ //lock에서 1만 있는지 확인
        int N = lock.length;
        for(int i=0; i<N ; i++){
            for(int j=0;j<N;j++){
                if(lock[i][j]!= 1){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean Check(ArrayList<Point> keys , int [][] map){
        int N = map.length;
        for(int i =-20; i<=20; i++){ //처음부터 끝까지 맵 크기 + 열쇠크기
            for(int j =-20; j<=20; j++){
                for(int z = 0; z<keys.size();z++){ //열쇠 1인 위치 다 꺼내서 더해보기
                    Point key = keys.get(z);
                    int x = key.x + j;
                    int y = key.y + i;
                    if(x >=0 && x<N && y>=0 && y<N ){
                        map[y][x] += 1;
                    }
                }
                if(realCheck(map)) return true; //확인해봤는데 맵 전부 1이면 true
                for(int z = 0; z<keys.size();z++){ //다음을 위해 롤백
                    Point key = keys.get(z);
                    int x = key.x + j;
                    int y = key.y + i;
                    if(x >=0 && x<N && y>=0 && y<N ){
                        map[y][x] -= 1;
                    }
                }
            }
        }
        return false;
    }
    
    
    public boolean solution(int[][] key, int[][] lock) {
        
        int M = key.length;
        int [][]tempKey = new int[M][M];
        ArrayList<Point> keys = new ArrayList<Point>();
        //4번 돌리면서 확인
        for(int asd=0 ; asd<4 ; asd++){
            for(int i= 0 ; i<M; i++){
                for(int j = 0; j<M;j++){
                    tempKey[j][i] = key[M-i-1][j]; 
                }
            }
            keys = find(tempKey); //ArrayList<Point> 로 현재 키 값들 반환
            // System.out.println(keys);
            if(Check(keys,lock)) return true; //키 값으로 맵 전체 탐색
            key = copyMap(tempKey); //키맵 업데이트

        }
        
        return false;
    }
}