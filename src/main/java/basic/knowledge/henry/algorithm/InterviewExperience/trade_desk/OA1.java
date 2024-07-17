package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an empty array that should contain integers numbers, your task is to process a list of queries on it. Specifically, there are two types of queries:
 *
 * "+x" - append x to numbers. numbers may contain multiple instances of the same integer.
 * "-x" - remove all the instances of x from numbers.
 * After processing each query, count the number of triples (x, y, z) in numbers which meet this condition: both x - y and y - z are equal to a given diff. Note that elements in numbers can be rearranged to form triples to meet the condition. The final output should be an array of counts after each query in queries.
 *
 * Notes:
 *
 * All integers in queries are guaranteed to be in the range of [-109, 109]. It is also guaranteed that for each "-x" query, the specified x exists in numbers.
 * It is guaranteed that the answer for each query fits into a 32-bit integer type.
 * Example
 *
 * For queries = ["+4", "+5", "+6", "+4", "+3", "-4"] and diff = 1, the output should be solution(queries, diff) = [0, 0, 1, 2, 4, 0].
 *
 * First, process queries[0] = "+4" and append 4 to numbers, resulting in numbers = [4]. There are no triples yet, so append 0 to the output.
 * Next, process queries[1] = "+5" and append 5 to numbers, resulting in numbers = [4, 5]. There are no triples yet, so append 0 to the output.
 * Process queries[2] = "+6" and append 6 to numbers, resulting in numbers = [4, 5, 6]. These can form the triple (6, 5, 4) which meets the condition (6 - 5 = 5 - 4 = 1 = diff), so append 1 to the output.
 * Process queries[4] = "+3" and add 3 to numbers, resulting in numbers = [4, 5, 6, 4, 3]. Now, there are two ways to form the triple (6, 5, 4) and two ways to form the triple (5, 4, 3) which meet the condition, so append 4 to the output.
 * Process queries[5] = "-4" and remove all instances of 4 from numbers, resulting in numbers = [5, 6, 3]. There are no way to form triples which can meet the condition, so append 0 to the output.
 * Finally, the output is [0, 0, 1, 2, 4, 0].
 */
public class OA1 {
    public static void main(String[] args) {
        OA1 oa1 = new OA1();
        List<Integer> solution = oa1.solution(new String[]{"+4", "+5", "+6", "+4", "+3", "-4"}, 1);
        System.out.println(solution.size());
    }

    public List<Integer> solution(String[] queries, int diff){
        HashMap<Integer,Integer> countMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(String q : queries){
            String op = q.substring(0,1);
            int num = Integer.valueOf(q.substring(1));

            int c = countMap.getOrDefault(num,0);
            if(op.equals("+")){
                countMap.put(num,c+1);
            }else{
                countMap.remove(num);
            }

            int stat = 0;
            for(Integer key : countMap.keySet()){
                stat += countMap.getOrDefault(key - diff,0)
                        * countMap.getOrDefault(key,0)
                        * countMap.getOrDefault(key + diff,0);
            }
            res.add(stat);

        }

        return res;


    }

}
