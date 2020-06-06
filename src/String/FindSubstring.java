package String;

public class FindSubstring {
    // method 1: KMP
    // assume s1.length() >= s2.length()
    int findSubstring(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()
                || s1.length() <= 0 || s2.length() <= 0) {
            return -1;
        }
        // calculate s2's hash value
        char[] a2 = s2.toCharArray();
        int hash2 = 0;
        for (int i = 0; i < a2.length; i++) {
            hash2 += ((int) a2[i]) * Math.pow(26, a2.length - i - 1);
        }
        // calculate hash for the first substring of s1
        int hash1 = 0;
        char[] a1 = s1.toCharArray();
        for (int i = 0; i < a2.length; i++) {
            hash1 += ((int) a1[i]) * Math.pow(26, a2.length - i - 1);
        }
        if (hash1 == hash2) {
            return 0;
        } else {
            for (int i = 1; i < a1.length; i++) {
                hash1 -= a1[i-1] * Math.pow(26, a2.length - 1);
                hash1 *= 26;
                hash1 += a1[i + a2.length - 1];
                if (hash1 == hash2) {
                    return i;
                }
            }
            return -1;
        }
    }

    // method 2: naive.
    // 过去错误1：can't just use two pointers to make a linear scan.
    // consider input: source = "mississippi" target = "issip"; source = "targtarget" target = "target"
    // 过去错误2：需要clarify：当有multiple occurrences时，return哪一次？
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }

        if (target == "") {
            return 0;
        }

        int result = -1;
        for (int i = 0; i <= source.length() - target.length(); i++) {
            if (isSubstring(source, target, i)) {
                result = i;
            }
        }

        return result;
    }

    boolean isSubstring(String source, String target, int start) {
        int i = start;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) != target.charAt(j)) {
                break;
            }
            i++;
            j++;
        }

        return j == target.length();
    }

    public static void main(String[] args) {
        FindSubstring solution = new FindSubstring();
        System.out.println(solution.strStr("a", ""));
    }
}
