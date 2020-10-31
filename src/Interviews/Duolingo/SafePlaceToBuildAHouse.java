package Interviews.Duolingo;

public class SafePlaceToBuildAHouse {
    int findPlace(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (heights[mid] < heights[mid - 1]) {
                right = mid;
            } else if (heights[mid] < heights[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }

        return heights[left] > heights[right] ? left : right;
    }

    public static void main(String[] args) {
        SafePlaceToBuildAHouse solution = new SafePlaceToBuildAHouse();
        int result = solution.findPlace(new int[] {2, 3, 4, 2, 1, 6, 4, 5, 8, 5, 3, 1});
        System.out.println(result);
    }
}
