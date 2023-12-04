package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.routes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Follow up:
//
//1 Imagine you are given a real file system, how will you search files? DFS or BFS?
//2  If the file content is very large (GB level), how will you modify your solution?
//3  If you can only read the file by 1kb each time, how will you modify your solution?
//4 What is the time complexity of your modified solution? What is the most time-consuming part and memory-consuming part of it? How to optimize?
//5  How to make sure the duplicated files you find are not false positive?

//Answers:
//
//1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
//In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories,
// and therefore will probably be faster
//
//2. If the file content is very large (GB level), how will you modify your solution?
//In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size.
// Files with different sizes are guaranteed to be different.
// We will than hash a small part of the files with equal sizes (using MD5 for example).
// Only if the md5 is the same, we will compare the files byte by byte
//
//3. If you can only read the file by 1kb each time, how will you modify your solution?
//This won't change the solution. We can create the hash from the 1kb chunks,
// and then read the entire file if a full byte by byte comparison is required.
//
//What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
//Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size
//
//How to make sure the duplicated files you find are not false positive?
//We will use several filters to compare: File size, Hash and byte by byte comparisons.
public class lc609 {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : paths){
            String[] arr = str.split(" ");
            String start = arr[0] + "/";
            for(int i = 1;i< arr.length;i++){
                String[] strs = arr[i].split("\\(");
                String path = strs[0];
                String content = strs[1].split("\\)")[0];
                String abPath =  start+path;
                List<String> list = map.getOrDefault(content,new ArrayList<>());
                list.add(abPath);
                map.put(content,list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> value = map.get(key);
            if(value.size() > 1){
                res.add(value);
            }

        }

        return res;

    }
}
