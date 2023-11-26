package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.HashMap;

public class FileSystem {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.createPath("/bar", 2);
        fileSystem.createPath("/bar/qu", 2);
        System.out.println(fileSystem.createPath("/bar/qu/ert", 1)); // true
        System.out.println(fileSystem.createPath("/bar/qu/ert/ssh", 2)); // true
        System.out.println(fileSystem.createPath("/bar/qu/ert", 3)); // false (path already exists)
        System.out.println(fileSystem.createPath("/bar/qu/xyz", 4)); // true
        System.out.println(fileSystem.get("/bar/qu/ert")); // 1
        System.out.println(fileSystem.get("/bar/*/ert")); // 1
        System.out.println(fileSystem.get("/bar/*/*/ssh")); //2 (using wildcard)
        System.out.println(fileSystem.get("/bar/*/*/*")); //2 (using wildcard)
        System.out.println(fileSystem.get("/bar/qu/xyz")); // 4
        System.out.println(fileSystem.get("/bar/*/xyz")); // 4
        System.out.println(fileSystem.get("/bar/qu")); // 2 (path doesn't exist)
        System.out.println(fileSystem.get("/")); // -1

    }

    TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        String[] nodes = path.split("/");
        int n = nodes.length;
        TrieNode cur = root;
        for (int i = 1; i < n; i++) {
            if (!cur.children.containsKey(nodes[i])) {
                if (i != n - 1) return false;
                cur.children.put(nodes[i], new TrieNode());
            }
            cur = cur.children.get(nodes[i]);
        }
        if (cur.isEnd) {// if the path already exists
            return false;
        }
        cur.isEnd = true;
        cur.val = value;
        return true;
    }


    private int get(String path) {
        String[] nodes = path.split("/");
        int n = nodes.length;
        TrieNode curr = root;
        for (int i = 1; i < n; i++) {
            if (!curr.children.containsKey(nodes[i]) && !nodes[i].equals("*")) {
                return -1;
            } else if (nodes[i].equals("*")) {
                for (String key : curr.children.keySet()) {
                    int tmp = findByWildCard(curr.children.get(key), i + 1, nodes);
                    if (tmp != -1) {
                        return tmp;
                    }
                }
                return -1;
            } else {
                curr = curr.children.get(nodes[i]);
            }
        }
        if (!curr.isEnd) return -1;
        return curr.val;

    }

    private int findByWildCard(TrieNode curr, int idx,String[] nodes) {

        int n = nodes.length;
        for (int i = idx; i < n; i++) {
            if (!curr.children.containsKey(nodes[i])&& !nodes[i].equals("*")) {
                return -1;
            } else if (nodes[i].equals("*")) {
                for (String key : curr.children.keySet()) {
                    int tmp = findByWildCard(curr.children.get(key), i + 1,nodes);
                    if (tmp != -1) {
                        return tmp;
                    }
                }
                return -1;
            } else {
                curr = curr.children.get(nodes[i]);
            }
        }
        if (!curr.isEnd) return -1;
        return curr.val;
    }

    class TrieNode {
        HashMap<String, TrieNode> children;
        boolean isEnd;
        int val;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }
}
