package S_0930;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

//11680kb	80ms
public class G_16928 {
    static boolean visited [];
    static int N,M; // N은 사다리 개수 , M 은 뱀의 수
    static HashSet<Point> nm; //뱀이랑 사다리 좌표 저장
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        nm = new HashSet<Point>();
        visited = new boolean[101];
        visited[1] = true;

        for (int i = 0; i < N + M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            nm.add(new Point(x,y)); //뱀 사다리 좌표 저장
        }
        ArrayDeque<Point> dq = new ArrayDeque<Point>();
        dq.add(new Point(1,0)); //x는 위치 y는 카운트 값 저장
        while (!dq.isEmpty()) {
            Point p = dq.poll();
            if(p.x == 100){
                System.out.println(p.y); //100일 때 카운트센거 출력
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int x = p.x + i; //1~6
                if(x >100) continue; //100아래일떄
                if(!visited[x]){ //방문안한곳있으면
                    visited[x] = true; //방문처리
                    Point next = new Point(x,p.y+1); //카운트 하나 세주고
                    for (Point nxt: nm) { //nm에서 하나씩 꺼내보면서 좌표 같으면
                        if(nxt.x == x){
                            next.x = nxt.y; //바꿔주고
                            break;
                        }
                    }
                    dq.add(next); //데크에 넣어주기
                }
            }
        }
    }
}