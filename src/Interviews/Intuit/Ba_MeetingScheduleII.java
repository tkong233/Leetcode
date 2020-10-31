package Interviews.Intuit;

public class Ba_MeetingScheduleII {
    boolean meetingSchedule(int[][] meetings, int start, int end) {
        for (int[] meeting : meetings) {
            if (hasOverlap(start, end, meeting[0], meeting[1])) {
                return false;
            }
        }

        return true;
    }

    boolean hasOverlap(int start, int end, int curStart, int curEnd) {
        return (start > curStart && start < curEnd) || (end > curStart && end < curEnd);
    }

    public static void main(String[] args) {
        Ba_MeetingScheduleII solution = new Ba_MeetingScheduleII();
        int[][] meetings = new int[][] {
                new int[] {1300, 1500},
                new int[] {930, 1200},
                new int[] {830, 845},
        };

        boolean result = solution.meetingSchedule(meetings, 820, 830);
        System.out.println(result);
    }
}
