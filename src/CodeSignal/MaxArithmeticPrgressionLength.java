package CodeSignal;
import java.util.*;

public class MaxArithmeticPrgressionLength {
    private static int maxLength(int[] a, int[] b) {
        Set<Integer> gcds = findGcd(a);
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            setB.add(b[i]);
        }
        int result = -1;
        for (int gcd : gcds) {
            int length = insert(a, setB, gcd);
            result = Math.max(result, length);
        }
        
        return result;
    }

    private static int insert(int[] a, Set<Integer> setB, int gcd) {
        int i = 1;
        int prev = a[0];
        int length = 1;
        while (i < a.length) {
            int cur = prev + gcd;
            if (a[i] == cur) {
                i++;
                length++;
                prev = cur;
                continue;
            }
            if (setB.contains(cur)) {
                length++;
                prev = cur;
                continue;
            }
            return -1;
        }
        // try extend tail
        int cur = prev + gcd;
        while (setB.contains(cur)) {
            length++;
            cur += gcd;
        }

        // try extend head
        cur = a[0] - gcd;
        while (setB.contains(cur)) {
            length++;
            cur -= gcd;
        }
        return length;
    }

    private static Set<Integer> findGcd(int[] a) {
        Set<Integer> gcds = new HashSet<>();
        Set<Integer> diffs = new HashSet<>();
        for (int i = 1; i < a.length; i++) {
            diffs.add(a[i] - a[i - 1]);
        }
        int gcd = 1;
        int maxDiff = Collections.max(diffs);
        while (gcd <= maxDiff) {
            boolean isGcd = true;
            for (int diff : diffs) {
                if (!(diff % gcd == 0)) {
                    isGcd = false;
                    break;
                }
            }
            if (isGcd) {
                gcds.add(gcd);
            }
            gcd++;
        }
        return gcds;
    }

    public static void main(String[] args) {
        maxLength(new int[] {0, 4, 8, 20}, new int[] {5, 7, 12, 16, 22});
    }
}
