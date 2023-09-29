package S_0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//11856kb	88ms
public class G_1043 {
    static int N,M;
    static ArrayList<Integer> party[]; //파티배열
    static ArrayList<Integer> KnowsPeople; //거짓말아는사람들
    static boolean[] visited; //파티 방문 체크

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        
        party = new ArrayList[M + 1];
        for (int i = 1; i <= M; i++) {
            party[i] = new ArrayList<>();
        }
        
        //거짓말 아는 사람들 추가
        KnowsPeople = new ArrayList<>();
        s = br.readLine().split(" ");
        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
            KnowsPeople.add(Integer.parseInt(s[i]));
        }
        //파티 입력 추가
        for (int i = 1; i <= M ; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(s[0]); j++) {
                party[i].add(Integer.parseInt(s[j]));
            }
        }

        visited = new boolean[M + 1];
        //거짓말아는 사람 하나 꺼내서 모든 파티에 있는지 확인
        for(int person : KnowsPeople){
            for(int i=1;i<=M;i++){
            	//거짓말 아는 사람 있으면서 i 파티 방문처리가 안되어있으면
                if(party[i].contains(person) && !visited[i]){
                    dfs(i);
                }
            }
        }

        int answer=0;
        //방문 안한파티카운트 세기
        for(int i=1;i<=M;i++){
            if(!visited[i]) answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int partyNum) {
    	//현재 파티 방문처리
        visited[partyNum] = true;
        //현재 파티에서 또 사람들 꺼내서
        for(int person : party[partyNum]){
            for(int j=1;j<=M;j++){
            	//다른파티에 현재파티 사람들이 있거나 방문 안했으면 재귀
                if(party[j].contains(person) && !visited[j]){
                    dfs(j);
                }
            }
        }
    }
}