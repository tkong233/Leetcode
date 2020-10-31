package Interviews.Duolingo;

public class StringSubsequences {
    int stringSubsequences(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return 0;
        }

        int hash1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            hash1 += (s1.charAt(i) - 'A') * Math.pow(26, i);
        }

        int count = 0;
        int hash2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            hash2 += (s2.charAt(i) - 'A') * Math.pow(26, i);
        }

        if (hash2 == hash1) {
            count++;
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            hash2 -= (s2.charAt(i - 1) - 'A');
            hash2 /= 26;
            hash2 += (s2.charAt(i + s1.length() - 1) - 'A') * Math.pow(26, s1.length() - 1);

            if (hash2 == hash1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        StringSubsequences solution = new StringSubsequences();
        int count = solution.stringSubsequences("ABC", "DABCDSABCA");
        System.out.println(count);
    }
}
