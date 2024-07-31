package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.*;

public class Leetcode2933 {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String,List<Integer>> map = new HashMap();
        List<String> ans = new ArrayList();
        for(List<String> i:access_times){
            if(map.containsKey(i.get(0))){
                List<Integer> t = map.get(i.get(0));
                t.add(Integer.parseInt(i.get(1)));
                map.put(i.get(0),t);
            }else{
                List<Integer> t = new ArrayList();
                t.add(Integer.parseInt(i.get(1)));
                map.put(i.get(0),t);
            }
        }
        for(Map.Entry<String,List<Integer>> m : map.entrySet()){
            List<Integer> temp = m.getValue();
            if(temp.size()<3){continue;}
            Collections.sort(temp);
            for(int i=0;i<temp.size()-2;i++){
                if((temp.get(i+2)-temp.get(i))<=99 && !ans.contains(m.getKey())){
                    ans.add(m.getKey());
                    continue;
                }
            }
        }
        return ans;
    }
}
