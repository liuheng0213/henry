package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._09others;

public class _24KMP_including {
    public static void main(String[] args) {
        _24KMP_including kmp = new _24KMP_including();
        int indexOf = kmp.getIndexOf("abcbcc", "bcc");
        System.out.println(indexOf);

        int i = "abcbcc".indexOf("bcc");
        System.out.println(i);

    }

    private int getIndexOf(String str, String pat) {
        if (str == null || pat == null || pat.length() == 0 || str.length() < pat.length()) {
            return -1;
        }

        char[] chs = str.toCharArray();
        char[] chp = pat.toCharArray();

        int si = 0;
        int pi = 0;

        int[] nextArr = getNext(pat);

        while (si < str.length() && pi < pat.length()) {
            if (chs[si] == chp[pi]) {
                si++;
                pi++;
            } else if (pi == 0) {
                si++;
            } else {
                pi = nextArr[pi];
            }
        }


        return pi == chp.length ? si - pi : -1;

    }

    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                next[i++] = j;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        return next;
    }
}
