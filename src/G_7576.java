import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class G_7576 {
    static int n , m ;
    static int toma[][];
    static int dx[] ={1,-1,0,0} ,dy[] ={0,0,-1,1};
    static ArrayList<Point> p ; //토마토 좌표 다 저장하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[0]);
        toma = new int[n][m];
        p = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            s= br.readLine().split(" ");
            for (int j = 0; j <m ; j++) {
                toma[i][j] = Integer.parseInt(s[j]);
                if(toma[i][j] ==1){
                    p.add(new Point(j,i));
                }
            }
        }
        ArrayDeque<Point> dq = new ArrayDeque<>();
        for (int i = 0; i < p.size(); i++) { //토마토 좌표를 데크에 다 넣어주기
            dq.add(p.get(i));
        }

        while(!dq.isEmpty()){
            Point point = dq.poll();
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if(xx>=0 && xx<m && yy>=0 && yy<n){
                    if(toma[yy][xx] == -1) continue;
                    if(toma[yy][xx] ==0){
                        toma[yy][xx] += toma[point.y][point.x]+1; //토마토 갱신
                        dq.add(new Point(xx,yy));
                    }
                }
            }
        }
        int answer= 0 ;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(answer < toma[i][j]){
                    answer = Math.max(answer,toma[i][j]); //최댓값이 끝에 도달한거니깐 정답으로 설정
                }
                if(toma[i][j] == 0){ //토마토 안익은거 있으면 flag 설정
                    flag = true;
                    break;
                }
            }
        }
        if(flag) System.out.println(-1); //안익었으면 -1
        else  System.out.println(answer-1); //익었으면 1부터 시작하니깐 -1 해서 정답출력

    }





}