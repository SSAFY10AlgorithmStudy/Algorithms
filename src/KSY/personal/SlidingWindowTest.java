package KSY.personal;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class SlidingWindowTest {
    
    static int A_limit, C_limit, G_limit, T_limit;
    static HashMap<Character, Integer> map, limit;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String [] line1=br.readLine().split(" ");
        
        int S=Integer.parseInt(line1[0]);
        int P=Integer.parseInt(line1[1]);
        
        String DNA_src=br.readLine();
        
        String line3[]=br.readLine().split(" ");
        
        A_limit=Integer.parseInt(line3[0]);
        C_limit=Integer.parseInt(line3[1]);
        G_limit=Integer.parseInt(line3[2]);
        T_limit=Integer.parseInt(line3[3]);
        
        limit=new HashMap<>();
        limit.put('A', A_limit);
        limit.put('C', C_limit);
        limit.put('G', G_limit);
        limit.put('T', T_limit);
        
        map=new HashMap<>();        
        map.put('A',0);
        map.put('C',0);
        map.put('G',0);
        map.put('T',0);
        
        
        //첫 비밀문자열에서 각 문자가 몇 개 포함되어 있는지 세어본다
        for (int i = 0; i < P; i++) {
            char pick=DNA_src.charAt(i);
            map.put(pick, map.get(pick)+1);
        }
        
        int result=0;
        if(check()) result++; //첫판에서 조건을 만족하면 1증가
        
        //이제 슬라이딩 윈도우 시작
        for (int i = 1; i+P-1 < S; i++) {
            char pre=DNA_src.charAt(i-1);//현재 윈도우의 직전 캐릭터
            char post=DNA_src.charAt(i+P-1);//새로 포함된 캐릭터
            map.put(pre, map.get(pre)-1);
            map.put(post, map.get(post)+1);
            if(check()) result++; 
        }
        
        System.out.println(result);
        
    }
    
    static boolean check() {
        return map.entrySet().stream().allMatch(e->e.getValue() >= limit.get(e.getKey()));
//        Set<Character> keys=map.keySet();
//        for(Iterator<Character> it=keys.iterator(); it.hasNext();) {
//            switch (it.next()) {
//            case 'A': if(map.get('A')<A_limit) return false;
//            case 'C': if(map.get('C')<C_limit) return false;
//            case 'G': if(map.get('G')<G_limit) return false;
//            case 'T': if(map.get('T')<T_limit) return false;        
//            }
//        }
//        
//        return true;
    }

}