package basic.knowledge.henry.algorithm.InterviewExperience;

import java.util.HashMap;

public class FluentCommerce {
    public static void main(String[] args) {
        String properties = "firstName=John\nlastName=Smith\nfullName=0firstName 0lastName\nhello=Hello 0fullName";
        String template = "0hello\nWelcome to Fluent Commerce!";
        System.out.print(outputTemplateResult(properties, template));
    }

    public static String outputTemplateResult(String properties, String template) {
        String[] s = properties.split("\n");
        HashMap<String,String> map =new HashMap<>();
        for(String str: s){
            String[] split = str.split("=");
            map.put(split[0], split[1]);
        }
        String[] ts = template.replaceAll("\n"," ").split(" ");
        String str = template;
        for(String t: ts){
            String newT = replaceStr(t,map);
            if(!newT.equals(t)){
                str = template.replaceAll("0" + t.substring(1), newT);
            }
        }
        return str;
    }

    private static String replaceStr(String t, HashMap<String, String> map) {
        if(!t.startsWith("0")|| !map.containsKey(t.substring(1))){
            return t;
        }
        String v = map.get(t.substring(1));
        if(v.indexOf("0") == -1){
            return v;
        }
        String[] ts = v.replaceAll("\n"," ").split(" ");
        String strNew= v;
        for(String subT: ts){
            String newT = replaceStr(subT,map);
            if(!newT.equals(subT)){
                String regex = "0"+ subT.substring(1);
                strNew = strNew.replaceAll(regex, newT);
            }
        }
        return strNew;
    }


}
