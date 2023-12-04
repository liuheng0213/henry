package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.routes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc588 {
    public static void main(String[] args) {

    }

    File root;

    public lc588() {
        this.root = new File("");
    }

    public String readContentFromFile(String name){
        File cur = this.root;
        String[] strs = name.split("/");
        int n = strs.length;

        for(int i = 1;i< n;i++){
            if(!cur.children.containsKey(strs[i])){
                return "";
            }
            cur = cur.children.get(strs[i]);
        }

        if(cur.isDir){
            return "";
        }else{
            return cur.content;
        }
    }

    public List<String> ls(String name){
        File cur = this.root;
        String[] strs = name.split("/");
        int n = strs.length;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (!cur.children.containsKey(strs[i])) {
               return res;
            }
            cur = cur.children.get(strs[i]);
        }
        if(!cur.isDir){
            res.add(cur.name);
        }else{
            for(String key : cur.children.keySet()){
                res.add(key);
            }
        }

        return res;
    }

    public void addContentToFile(String name, String content) {
        File cur = this.root;
        String[] strs = name.split("/");
        int n = strs.length;

        for (int i = 1; i < n; i++) {
            if (!cur.children.containsKey(strs[i])) {
                cur.children.put(strs[i], new File(strs[i]));
            }
            cur = cur.children.get(strs[i]);
        }
        cur.content += content;
        cur.isDir = false;
    }

    public void mkdir(String name) {
        File cur = this.root;
        String[] strs = name.split("/");
        int n = strs.length;
        for (int i = 1; i < n; i++) {
            if (!cur.children.containsKey(strs[i])) {
                cur.children.put(strs[i], new File(strs[i]));
            }
            cur = cur.children.get(strs[i]);
        }
        cur.isDir = true;
    }

    class File {
        boolean isDir;
        String content;
        HashMap<String, File> children;

        String name;

        public File(String name) {
            this.children = new HashMap<>();
            this.isDir = true;
            this.name = name;
            this.content = "";
        }

    }

}
