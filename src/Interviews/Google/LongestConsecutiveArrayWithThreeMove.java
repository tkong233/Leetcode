package Interviews.Google;

public class LongestConsecutiveArrayWithThreeMove {
//    int longest(int[] A) {
//        int longest = 0;
//        for (int start = 0; start < A.length; start++) {
//            int move = 0;
//            int cur = start;
//            int curLength = 0;
//            while (cur < A.length && move <= 3) {
//                move = A[cur] != A[start] ? move + 1 : move;
//                curLength++;
//                cur++;
//                longest = curLength > longest ? curLength : longest;
//            }
//        }
//
//        return longest;
//    }

    int longest(int[] A) {
        int longest = 0;

        for (int i = 0; i < A.length; i++) {
            for (int leftMoveLimit = 0; leftMoveLimit <= 3; leftMoveLimit++) {
                int curLongest = getLongest(A, i, leftMoveLimit, 3 - leftMoveLimit);
                longest = curLongest > longest ? curLongest : longest;
            }
        }

        return longest;
    }

    int getLongest(int[] A, int i, int leftMoveLimit, int rightMoveLimit) {
        int longest = 0;
        int left = i - 1;
        int right = i;
        int leftMove = 0;
        int rightMove = 0;

        while (right < A.length && rightMove < rightMoveLimit) {
            if (A[right] != A[i]) {
                rightMove++;
            }
            right++;
            longest++;
        }

        while (right < A.length && A[right] == A[i]) {
            right++;
            longest++;
        }

        while (left >= 0 && leftMove < leftMoveLimit) {
            if (A[left] != A[i]) {
                leftMove++;
            }
            left--;
            longest++;
        }

        while (left >= 0 && A[left] == A[i]) {
            left--;
            longest--;
        }

        return longest;
    }



    public static void main(String[] args) {
        LongestConsecutiveArrayWithThreeMove solution = new LongestConsecutiveArrayWithThreeMove();
        int result = solution.longest(new int[] {3, 3, 2, 1, 2, 2, 9, 3, 3});
        System.out.println(result);
    }
}
