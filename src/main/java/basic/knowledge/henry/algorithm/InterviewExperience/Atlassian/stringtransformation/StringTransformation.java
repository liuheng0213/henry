package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.stringtransformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StringTransformation {
    int max = 1;
    List<String> maxList = new ArrayList<>();

    public static void main(String[] argv) {
        String[] songs1 = {
                "Down By the River",
                "River of Dreams",
                "Take me to the River",
                "Dreams",
                "Blues Hand Me Down",
                "Forever Young",
                "American Dreams",
                "All My Love",
                "Cantaloop",
                "Take it All",
                "Love is Forever",
                "Young American",
                "Every Breath You Take"
        };
        String song1_1 = "Every Breath You Take";
        String song1_2 = "Dreams";
        String song1_3 = "Blues Hand Me Down";
        String song1_4 = "Cantaloop";

        String[] songs2 = {
                "Bye Bye Love",
                "Nothing at All",
                "Money for Nothing",
                "Love Me Do",
                "Do You Feel Like We Do",
                "Bye Bye Bye",
                "Do You Believe in Magic",
                "Bye Bye Baby",
                "Baby Ride Easy",
                "Easy Money",
                "All Right Now"
        };
        String song2_1 = "Bye Bye Bye";
        String song2_2 = "Bye Bye Love";

        String[] songs3 = {
                "Love Me Do",
                "Do You Believe In Magic",
                "Magic You Do",
                "Magic Man",
                "Man In The Mirror"
        };
        String song3_1 = "Love Me Do";

        StringTransformation stringTransformation = new StringTransformation();
        List<String> solution = stringTransformation.solution(songs2, song2_1);
        for (String str : solution) {
            System.out.println(str);
        }
    }

    public List<String> solution(String[] songs1, String song1_1) {
        HashMap<String, List<String>> graph = new HashMap<>();
        ArrayList<String>[] g = new ArrayList[songs1.length];
        for (int i = 0; i < songs1.length; i++) {
            String str1 = songs1[i];
            for (int j = 0; j < songs1.length; j++) {
                String str2 = songs1[j];
                if (!str1.equals(str2) && validation(str1, str2)) {
                    List<String> list = graph.getOrDefault(str1, new ArrayList<>());
                    list.add(str2);
                    graph.put(str1, list);
                }
            }
        }

        //dfs
        List<String> list = new ArrayList<>();
        HashSet<String> marked = new HashSet<>();
        list.add(song1_1);
        marked.add(song1_1);
        dfs(graph, marked, list, song1_1, 1);
        return maxList;
    }

    private void dfs(HashMap<String, List<String>> graph, HashSet<String> marked, List<String> list, String cur, int depth) {
        if (graph.get(cur) == null) {
            if (depth > max) {
                max = depth;
                maxList = new ArrayList<>(list);
            }
        }

        if (graph.get(cur) != null) {
            for (String next : graph.get(cur)) {
                if (!marked.contains(next)) {
                    list.add(next);
                    marked.add(next);
                    dfs(graph, marked, list, next, depth + 1);
                    list.remove(list.size() - 1);
                    marked.remove(next);
                }
            }
        }

    }

    private boolean validation(String str1, String str2) {
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");
        return s1[s1.length - 1].equals(s2[0]);
    }


}
