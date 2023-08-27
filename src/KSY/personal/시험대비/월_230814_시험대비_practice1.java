package KSY.personal.시험대비;

import java.io.*;
import java.util.Arrays;

//순조부 

public class 월_230814_시험대비_practice1 {
	    static int totalCnt, N, R, T;
	    static String[] input, result;
	    static StringBuilder sb;

	    public static void main(String[] args) throws Exception {

	        System.setIn(new FileInputStream("input.txt"));
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	        

	        input = br.readLine().split(" "); // 학생들
	        T = Integer.parseInt(br.readLine().trim());

	        for (int i = 0; i < T; i++) {
	            String line[] = br.readLine().split(" ");

	            N = Integer.parseInt(line[1]);// N은 19반 인원
	            R = Integer.parseInt(line[2]);// R은 뽑을 수
	            result = new String[R];// 뽑힌 학생들
	            sb = new StringBuilder();

	            long startTime = System.nanoTime();
	            totalCnt = 0;

	            switch (line[0]) {

	            case "M1":
	                M1_노래부를순서정하기_순열(0, 0);
	                break;
	            case "M2":
	                M2_노래부를순서정하기_순열_NP();
	                break;
	            case "M3":
	                M3_노래부를팀만들기_조합(0, 0);
	                break;
	            case "M4":
	                M4_노래부를팀만들기_조합_NP();
	                break;
	            case "M5":
	                M5_노래부를팀만들기_부분집합();
	                break;

	            }
	            after(startTime);
	            wr.write(sb.toString());
	            wr.flush();
	        }

	        

	    }

	    private static void after(long startTime) {
	        sb.append(totalCnt).append("\n");
	        long endTime = System.nanoTime();
	        sb.append(((endTime - startTime) * 0.000000001)).append("초\n");
	    }

	    ////////////////
	    private static void M1_노래부를순서정하기_순열(int cnt, int flag) {
	        ++totalCnt;
	        if(cnt == R) {
//	        	sb.append(Arrays.toString(result)).append("\n");
	        	
	        } else {
	        	for(int i=0; i<N; i++) {
	        		if((flag & 1 << i) != 0)
	        			continue;
	        		result[cnt] = input[i];  // cnt번째에 i번째 입력을 삽입
	        		M1_노래부를순서정하기_순열(cnt+1, flag | 1 << i);
	        	}
	        }
	    }

	    //////////////////////
	    private static void M2_노래부를순서정하기_순열_NP() {
	    	int[] p =  new int[R];
	    	for(int i=0; i<R; i++)
	    		p[i] = i;
	    	do {
	    		totalCnt++;
	    		for(int i=0; i<R; i++) {
//	    			sb.append(input[p[i]]).append(" ");
	    		}
//	    		sb.append("\n");
	    	} while(NP(p));
	    }

	    
	    ///////////////////////
	    private static void M3_노래부를팀만들기_조합(int cnt, int start) {
	        ++totalCnt;
	        if(cnt == R)
//	        	sb.append(Arrays.toString(result)).append("\n")
	        	;
	        else {
	        	for(int i=start; i<N; i++) {
	        		result[cnt] = input[i];
	        		M3_노래부를팀만들기_조합(cnt+1, i+1);
	        	}
	        }
	    }

	    /////////////////////
	    private static void M4_노래부를팀만들기_조합_NP() {        
	        
	        // 배열 뒤부터 R개수만큼 1로 만듦 : 5C2라면 00011 이런형태로
	    	int[] p = new int[N];
	    	int i=N-1;
	    	while(i>=N-R) p[i--] = 1;
	    	
	    	do {
	    		totalCnt++;
	    		for(int j=0; j<N; j++) {
	    			if(p[j] == 1) {
//	    				sb.append(input[j]).append(" ");
	    			}
	    		}
//	    		sb.append("\n");
	    	} while(NP(p));

	    }
	    
	    
	    /////////////////////
	    private static void M5_노래부를팀만들기_부분집합() {
	    	for(int i=0; i< (1<<N) ; i++) {
	    		for(int j=0; j<N; j++) {
	    			if((i & (1 << j)) != 0) {
	    				sb.append(input[j]).append(" ");
	    			}
	    		}
	    		sb.append("\n");
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    private static boolean NP(int[] p) {
	    	int i = N-1;
	    	while(i > 0 && p[i-1] >= p[i]) i--;
	    	if(i == 0) return false;
	    	
	    	int j= N-1;
	    	while(p[i-1] >= p[j]) j--;
	    	swap(p, i-1, j);
	    	
	    	int k=N-1;
	    	while(k>i)
	    		swap(p, k--, i++);
	    	
	    	return true;
	    }

	    private static void swap(int[] p, int a, int b) {
	        int temp = p[a];
	        p[a] = p[b];
	        p[b] = temp;
	    }

}
