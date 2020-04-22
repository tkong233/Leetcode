package String;

public class FindSubstring {
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

    public static void main(String[] args) {
        FindSubstring solution = new FindSubstring();
        System.out.println(solution.findSubstring("aaacbdabc", "abc"));
    }
}
