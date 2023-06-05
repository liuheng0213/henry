package basic.knowledge.henry.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AirwallexTest {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 0, 5, 0, 6, 0, 1};
        solve(arr);


        List<String> input = new ArrayList<>();
        input.add("cat");
        input.add("tca");
        input.add("STUDY");
        input.add("DUSTY");
        input.add("tab");
        input.add("tac");
        input.add("bat");
        input.add("dog");

        AirwallexTest airwallexTest = new AirwallexTest();
        List<List<String>> res = airwallexTest.getRes(input);

        System.out.println("haha");

    }

    private List<List<String>> getRes(List<String> input) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == null) {
                continue;
            }
            String str = input.get(i);
            List<String> subList = new ArrayList<>();
            subList.add(str);
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(j) == null) {
                    continue;
                }
                String newStr = sort(str);
                String newStr_later = sort(input.get(j));
                if(newStr.equals(newStr_later)){
                    subList.add(input.get(j));
                    input.set(j,null);
                }
            }
            res.add(subList);
        }

        return res;
    }

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static void solve(int[] arr) {
        int j = 1;
        int i = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                int original_j = j;
                while (i < j) {
                    change(j, j - 1, arr);
                    j--;
                }
                j = original_j + 1;
                i++;
            } else {
                j++;
            }
        }
    }

    private static void change(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
