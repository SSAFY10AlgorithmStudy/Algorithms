package S_0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//	38304kb	596ms
public class G_14500 {
    static int N, M,answer;
    static int map[][];
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //5개 블록 넣어본다
                int 일번 = 일자(j,i);
                int 이번 = 네모(j,i);
                int 삼번 = 니은자(j,i);
                int 사번 = 이상한거(j,i);
                int 오번 = 반(j,i);
//                System.out.print("i = " + i + "  j  = "+ j + "   ");
//                System.out.println(일번 + " "+ 이번 + " " + 삼번 +" "+ 사번 + " " + 오번);
                answer = Math.max(Math.max(Math.max(Math.max(일번,이번),Math.max(삼번,사번)),오번),answer);
            }
        }
        System.out.println(answer);

    }

    private static int 반(int x, int y) {
        int temp = map[y][x];
        if(check(x-1,y) && check(x+1,y) && check(x,y+1)){
            temp += map[y][x - 1];
            temp += map[y][x + 1];
            temp += map[y + 1][x];
        }
        int temp2 = map[y][x];
        if(check(x+1,y) && check(x,y-1) && check(x,y+1)){
            temp2 += map[y][x + 1];
            temp2 += map[y - 1][x];
            temp2 += map[y + 1][x];
        }

        int temp3 = map[y][x];
        if(check(x-1,y) && check(x,y-1) && check(x,y+1)){
            temp3 += map[y][x - 1];
            temp3 += map[y - 1][x];
            temp3 += map[y + 1][x];
        }
        int temp4 = map[y][x];
        if(check(x-1,y) && check(x+1,y) && check(x,y-1)){
            temp4 += map[y][x - 1];
            temp4 += map[y][x + 1];
            temp4 += map[y - 1][x];
        }
        return Math.max(Math.max(temp,temp2),Math.max(temp3, temp4));
    }


    private static int 이상한거(int x, int y) {
        int temp = 0;

        temp += map[y][x];
        if(check(x-1,y-1)){
            temp += map[y][x-1];
            temp += map[y-1][x-1];
            if(check(x,y+1)) temp+= map[y+1][x];
        }
        int temp2 = 0;

        temp2 += map[y][x];
        if(check(x+1,y-1)){
            temp2 += map[y][x+1];
            temp2 += map[y-1][x+1];
            if(check(x,y+1)) temp2+= map[y+1][x];
        }

        int max = Math.max(temp,temp2);
        temp = 0;

        temp += map[y][x];
        if(check(x+1,y-1)){
            temp += map[y-1][x];
            temp += map[y][x+1];
            if(check(x-1,y-1)) temp+= map[y-1][x-1];
        }
        temp2 = 0;

        temp2 += map[y][x];
        if(check(x-1,y-1)){
            temp2 += map[y][x-1];
            temp2 += map[y-1][x];
            if(check(x+1,y-1)) temp2+= map[y-1][x+1];
        }
        int max2 = Math.max(temp,temp2);
        return Math.max(max,max2);
    }

    private static int 니은자(int x, int y) {
        int 가로 = 0;
        int 세로 = 0;
        for (int i = 0; i < 3; i++) {
            if(!check(x+i,y)) break;
            가로+= map[y][x+i];
        }

        for (int i = 0; i < 3; i++) {
            if(!check(x,y+i)) break;
            세로+= map[y+i][x];
        }
        int a = 가로,b = 가로,c = 가로,d = 가로;
        if(check(x,y+1)){
            a += map[y+1][x];
        }
        if(check(x,y-1)){
            b += map[y-1][x];

        }if(check(x+2,y-1)){
            c += map[y-1][x+2];
        }if(check(x+2,y+1)){
            d += map[y+1][x+2];
        }
        int max = Math.max(Math.max(a,b),Math.max(c,d));
        a = 세로;
        b = 세로;
        c = 세로;
        d = 세로;
        if(check(x+1,y)){
            a += map[y][x+1];
        }

        if(check(x-1,y)){
            b += map[y][x-1];

        }
        if(check(x-1,y+2)){
            c += map[y+2][x-1];
        }
        if(check(x+1,y+2)){
            d += map[y+2][x+1];
        }
        int max2 = Math.max(Math.max(a,b),Math.max(c,d));

        return Math.max(max,max2);

    }

    private static int 네모(int x, int y) {
        int temp = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if(!check(x+j,y+i)) return 0;
                temp += map[y+i][x+j];
            }
        }
        return temp;
    }

    private static int 일자(int x, int y) {
        int temp = 0,temp2=0;

        for (int j = 0; j < 4; j++) {
            if (!check(x + j, y)) {
                break;
            }
            temp += map[y][x+j];
        }
        for (int j = 0; j < 4; j++) {
            if (!check(x, y + j)) {
                break;
            }
            temp2 += map[y+j][x];
        }
        return Math.max(temp,temp2);
    }
    private static boolean check(int x,int y){
        if(x>=0 && x<M && y>=0 && y<N){
            return true;
        }
        return false;
    }
}
