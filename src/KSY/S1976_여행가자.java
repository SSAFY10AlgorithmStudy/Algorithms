package KSY;
import java.io.*;
import java.util.*;

//17216KB/	212ms

public class S1976_여행가자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] adjMatrix = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=N; j++) {
        		adjMatrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // 플로이드-워샬
        for(int k=1; k<=N; k++) {
        	for(int i=1; i<=N; i++) {
        		for(int j=1; j<=N; j++) {
        			if(adjMatrix[i][j] == 0) {
        				if(adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1) {
        					adjMatrix[i][j] = 1;
        				}
        			}
        		}
        	}
        }
        
        // 여행계획 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int front = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i=1; i<M; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	if(front != a && adjMatrix[front][a] == 0) {
        		flag = false;
        		break;
        	}
        	front = a;
        }
        
        if(flag) {
        	sb.append("YES");
        } else {
        	sb.append("NO");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
        
	}

}
