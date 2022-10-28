package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._09others;

public class _24KMP {
    public static void main(String[] args) {
        _24KMP kmp = new _24KMP();
        int indexOf = kmp.getIndexOf("abcbcc", "bcc");
        System.out.println(indexOf);

        int i = "abcbcc".indexOf("bcc");
        System.out.println(i);

    }

    public int getIndexOf(String str, String pat) {
        if (str == null || pat == null || pat.length() == 0 || str.length() < pat.length()) {
            return -1;
        }

        char[] chs = str.toCharArray();
        char[] chp = pat.toCharArray();

        int si = 0;
        int pi = 0;

        int[] nextArr = getNext(chp);

        while (si < chs.length && pi < chp.length) {
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

    private int[] getNext(char[] chp) {
        if (chp.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[chp.length];

        next[0] = -1;
        next[1] = 0;

        int pos = 2;
        int cn = 0;
        while (pos < chp.length) {
            if (chp[pos - 1] == chp[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }

        return next;
    }
}
