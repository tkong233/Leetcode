package BitOperations;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {
    /*
        Determine if a string contains only unique characters
     */

//    Method 1: use a hash set
    boolean uniqueCharacters(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }

//    Method 2: use bits in an int to record characters
    boolean uniqueCharacters1(String s) {
        int bits = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            if ((bits & (1 << k)) == 1) {
                return false;
            } else {
                bits |= (1 << k);
            }
        }
        return true;
    }

//  Method 3: work for 0~255 characters set. use a bit vector.
    boolean uniqueCharacters2(String word) {
        int[] bit_vector = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int ch = (int) word.charAt(i);
            int row = ch / 32;
            int col = ch % 32;
            int bit = (bit_vector[row] >>> col) & 1;
            if (bit == 1) {
                return false;
            } else {
                bit_vector[row] |= (1 << col);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        UniqueCharacters solution = new UniqueCharacters();
        System.out.println(solution.uniqueCharacters2("aabc"));
    }
}
