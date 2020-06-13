package NineChapters.TwoPointers;

public class AllZeroSubstring {
    public int stringCount(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int fast = 1; // fast = first non-zero element to the right of slow
        int result = 0;
        for (int slow = 0; slow < str.length(); slow++) {
            if (str.charAt(slow) != '0') {
                continue;
            }
            fast = Math.max(fast, slow + 1);
            while (fast < str.length() && str.charAt(fast) == '0') {
                fast++;
            } // fast = first non-zero, or out of bound
            result += (fast - slow);
        }

        return result;
    }

    public static void main(String[] args) {
        AllZeroSubstring solution = new AllZeroSubstring();
        int result =  solution.stringCount("00010011");
        System.out.println(result);
    }
}
