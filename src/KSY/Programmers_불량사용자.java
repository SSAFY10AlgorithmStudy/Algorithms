package KSY;

import java.util.*;
class Programmers_불량사용자 {
    static int answer=0;
    static Set<String> set = new HashSet<>();
    static Set<Set<String>> setset = new HashSet<>();
    static List<String>[] list;
    
    public int main(String[] user_id, String[] banned_id) {
        list = new ArrayList[banned_id.length];
        for(int i=0; i<banned_id.length; i++)
            list[i] = new ArrayList<>();
        
        for(int i=0; i<banned_id.length; i++){
            String banned = banned_id[i];
            for(int j=0; j<user_id.length; j++){
                String user = user_id[j];
                
                if(banned.length() == user.length()){
                    boolean flag = true;
                    for(int k=0; k<banned.length(); k++){
                        char ch = banned.charAt(k);
                        if(ch != '*' && ch != user.charAt(k)){
                                flag = false;
                                break;
                        }
                    }
                    if(flag){  // 후보
                        list[i].add(user);
                    }
                }
            }
        }
        //
        DFS(0, banned_id.length);
        
        
        //출력 확인
        // for(int i=0; i<banned_id.length; i++){
        //     System.out.println(list[i].toString());
        // }
        return answer;
    }
    
    public void DFS(int depth, int banned_id_length){
        if(depth == banned_id_length){  // 다 고름
            if(!setset.contains(set)){
                setset.add(new HashSet(set));
                answer++;
            }
            return;
        }
        for(String str: list[depth]){
            if(!set.contains(str)){
                set.add(str);
                DFS(depth+1, banned_id_length);
                set.remove(str);
            }
        }
    }
}