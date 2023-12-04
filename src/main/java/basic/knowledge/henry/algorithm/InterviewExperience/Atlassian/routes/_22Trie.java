package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.routes;

import java.util.HashMap;

//实现字典树的增删改查功能  做之前需看看书里的数据结构 Index  代表某一个字符 而trienode 并不代表字符
//trienode 字段并没有字符  所以root 一定要有path++ 因为那根线代表一个字符
//todo   重写  root 要跟path   path要算在父节点上  而且要算在子节点上
public class _22Trie {

    public static void main(String[] args) {
        _22Trie trie = new _22Trie();
        String str1 = "abc";
        String str2 = "cdc";
        String str3 = "bdce";
        String str4 = "adcf";
        String str5 = "abcm";
        trie.insert(str1);
        trie.insert(str2);
        trie.insert(str3);
        trie.insert(str4);
        trie.insert(str5);

        System.out.println(trie.prefixNum("abc"));
        System.out.println(trie.search(str4));
        boolean delete = trie.delete(str4);
        System.out.println(delete);
        System.out.println(trie.search(str4));
        System.out.println(trie.search(str1));
        boolean delete1 = trie.delete(str1);
        System.out.println(delete1);
        System.out.println(trie.search(str1));
        System.out.println(trie.delete("abd"));
    }

    Node root;

    public _22Trie() {
        root = new Node();
    }

    private boolean delete(String str) {
        char[] arr = str.toCharArray();
        Node cur = this.root;
        cur.path--;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (!cur.childs.containsKey(ch)) {
                return false;
            } else {
                cur.path--;
                if (cur.path >= 1) {
                    cur = cur.childs.get(ch);
                } else {
                    cur.childs.remove(ch);
                }
            }
        }
        cur.end--;
        return true;
    }

    private boolean search(String str) {
        char[] arr = str.toCharArray();
        Node cur = this.root;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (!cur.childs.containsKey(ch)) {
                return false;
            } else {
                cur = cur.childs.get(ch);
            }
        }
        return cur.end != 0;
    }

    private int prefixNum(String str) {
        char[] arr = str.toCharArray();
        Node cur = this.root;

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (!cur.childs.containsKey(ch)) {
                return 0;
            } else {
                cur = cur.childs.get(ch);
            }
        }
        return cur.path;
    }

    public void insert(String str) {
        char[] arr = str.toCharArray();
        Node cur = this.root;
        cur.path++;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (!cur.childs.containsKey(ch)) {
                cur.childs.put(ch, new Node());
            }
            cur = cur.childs.get(ch);
            cur.path++;
        }
        cur.end++;
    }


    class Node {
        Character ch;
        HashMap<Character, Node> childs;
        int path;
        int end;

        public Node() {
            path = 0;
            end = 0;
            childs = new HashMap<>();
        }
    }
}


