package BitOperations;

public class ReverseBits {
    int reverseBits(int x) {
        int i = 0;
        int j = 31;
        while (i < j) {
            x = reversePair(x, i, j);
            i++;
            j--;
        }
        return x;
    }

    int reversePair(int x, int i, int j) {
        int left = x & (1 << i);
        int right = x & (1 << j);
        if (left != right) {
            x ^= ((1 << i) | (1 << j));
        }
        return x;
    }

}
