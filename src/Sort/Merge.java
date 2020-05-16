package Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    public static List<Integer> merge(List<Integer> nums1, List<Integer> nums2) {
        if ((nums1 == null && nums2 == null) || nums1 == null || nums2 == null) {
            return new LinkedList<>();
        }
        if (nums1.size() == 0) {
            return nums2;
        }

        if (nums2.size() == 0) {
            return nums1;
        }

        List<Integer> result = new LinkedList<>();

        int p1 = 0, p2 = 0;
        while (p1 < nums1.size() && p2 < nums2.size()) {
            int n1 = nums1.get(p1);
            int n2 = nums2.get(p2);
            if (n1 < n2) {
                result.add(n1);
                p1 += 1;
            } else {
                result.add(n2);
                p2 += 1;
            }
        }
        if (p1 < nums1.size()) {
            for (int i = p1; i < nums1.size(); i++) {
                result.add(nums1.get(p1));
            }
        }
        if (p2 < nums2.size()) {
            for (int i = p2; i < nums2.size(); i++) {
                result.add(nums2.get(p2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Merge solution = new Merge();
        List<Integer> result = solution.merge(Arrays.asList(1), Arrays.asList(0, 1, 1));
        System.out.println(result.toString());
    }
}
