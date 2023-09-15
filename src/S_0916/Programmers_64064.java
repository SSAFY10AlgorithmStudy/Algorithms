package S_0916;

import java.util.stream.Collectors;
import java.util.*;

class Programmers_64064 {
    static HashSet<ArrayList<String>> data;
    public void perm(boolean visited[],int cnt,String [] arr,int len, String []user_id ){
        if(cnt == len ){
            List<String> collect = Arrays.stream(arr).collect(Collectors.toList());
            data.add((ArrayList) collect); 

            return;
        }

        for(int i=0 ; i<len; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = user_id[i];
            perm(visited, cnt + 1, arr, len, user_id);
            visited[i] = false;

        }
    }
    public int solution(String[] user_id, String[] banned_id) {
    	//순열로 뽑은거 저장하기 위한 해시셋
    	data = new HashSet<ArrayList<String>>(); 
        
    	//순열 돌리기
        perm(new boolean[user_id.length], 0, new String[user_id.length], user_id.length, user_id);
        
        //정답 해시셋
        HashSet<ArrayList> real = new HashSet<ArrayList>();
        
        //한줄씩 비교 
        for (ArrayList<String> list :data) {
        	//비교한 결과 저장하는 리스트
            ArrayList<String> temp = new ArrayList<String>();
            
            //벤아이디 배열길이 만큼 반복
            for (int i = 0; i < banned_id.length; i++) {
            	//단어 길이 세기
                int cnt  =0;
                //유저아이디 첫번째랑 벤아이디 첫번째랑 문자열 길이 다르면 break
                if(list.get(i).length() != banned_id[i].length()) break;
                
                //같으면 문자열비교
                for (int j = 0; j < banned_id[i].length(); j++) {
                	//둘이 같거나
                    if(list.get(i).charAt(j) == banned_id[i].charAt(j)){
                        cnt++;
                    }
                    //별이면 cnt ++
                    else if(list.get(i).charAt(j) != banned_id[i].charAt(j) && banned_id[i].charAt(j) == '*'){
                        cnt++;
                    }
                    //아니면 break
                    else break;
                }
                //길이 같으면 list에 추가
                if(cnt == banned_id[i].length()){
                    temp.add(list.get(i));
                }
            }
            //둘이 길이 같으면
            if(temp.size() == banned_id.length){
            	//정렬 후 헤시셋에 저장
                Collections.sort(temp);
                real.add(temp);
            }
        }
        return real.size();
    }


}