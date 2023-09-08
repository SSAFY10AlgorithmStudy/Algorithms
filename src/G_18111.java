import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G_18111 {
    static int N,M,B;
    static int [][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        B = Integer.parseInt(s[2]);
        int time = Integer.MAX_VALUE; // 걸리는 시간
        int high = Integer.MAX_VALUE; // 높이
        
        map = new int[N][M];
        for (int i = 0; i <N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        int h = -1; 
        while(h++ <257){//0부터 시작
            int remove=0,add=0; //제거 블록과 추가 블록
            for (int i = 0; i < N; i++) { //
                for (int j = 0; j < M; j++) {
                    if(map[i][j] > h){ //h보다 현재 높이가 클 경우
                        remove += (map[i][j]- h);  //h만큼 깎아주기
                    }else{ //같거나 크면
                        add += (h- map[i][j]); //현재 높이만큼 더해주기
                    }
                }
            }
            //제거한 블록과 가지고 있던 블록개수가 추가한 것 보다 크거나 같을 때
            // 평탄화 가능함
            if(remove+B >= add){
                int tempTime = remove * 2 + add; //시간 계산해놓고
                if(time >= tempTime){ // 만약에 정답 시간이 더 클 경우 업데이트 작은 시간으로 같을때도 높이 갱신 
                    time = tempTime; //시간 업데이트
                    high = h; //높이 업데이트
                }
            }
        }
        System.out.println(time + " " +high); //출력
    }

}
