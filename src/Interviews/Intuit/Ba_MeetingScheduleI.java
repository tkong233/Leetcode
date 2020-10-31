package Interviews.Intuit;

import java.util.ArrayList;
import java.util.List;

public class Ba_MeetingScheduleI {
    /*
        类似meeting rooms，输入是一个int[][] meetings, int start, int end,
        每个数都是时间，13：00 => 1300， 9：30 => 930， 看新的meeting 能不能安排到meetings

        ex:
        {[1300, 1500], [930, 1200],[830, 845]},
        新的meeting[820, 830], return true; [1450, 1500] return false;
     */

    /*
        clarification:
        1. times are in 24 hours
        2. all times are within a day, 00:00 - 23:59
        3. meeting is not null. empty?
        4. all times are valid (e.g. won't have 27:00)
        5. all end > start
     */

    boolean meetingSchedule(int[][] meetings, int start, int end) {
        if (meetings == null || start < 0 || end > 2359) {
            return false;
        }

        List<int[]> schedule = new ArrayList<>();
        for (int[] meeting : meetings) {
            addToSchedule(schedule, meeting[0], meeting[1]);
        }

        return addToSchedule(schedule, start, end);
    }

    boolean addToSchedule(List<int[]> schedule, int start, int end) {
        if (schedule.size() == 0) {
            schedule.add(new int[] {start, end});
            return true;
        }

        for (int i = 0; i < schedule.size(); i++) {
            int[] cur = schedule.get(i);
            int[] next = (i < schedule.size() - 1) ? schedule.get(i + 1) : new int[2];

            if (isBefore(start, end, cur[0], cur[1]) && i == 0) {
                schedule.add(i, new int[] {start, end});
                return true;
            }

            if (isAfter(start, end, cur[0], cur[1]) &&
                    ((i == schedule.size() - 1)) ||
                    (isBefore(start, end, next[0], next[1])))
                     {
                schedule.add(i + 1, new int[] {start, end});
                return true;
            }

            if (isOverlapBefore(start, end, cur[0], cur[1])) {
                int[] newSchedule = new int[] {start, cur[1]};
                schedule.set(i, newSchedule);
                return false;
            }

            if (isOverlapAfter(start, end, cur[0], cur[1]) &&
                    ((i == schedule.size() - 1) ||
                    (!isOverlapBefore(start, end, next[0], next[1])))
                    ) {
                int[] newSchedule = new int[] {cur[0], end};
                schedule.set(i, newSchedule);
                return false;
            }

            if (isOverlapAfter(start, end, cur[0], cur[1]) && isOverlapBefore(start, end, next[0], next[1])) {
                int[] newSchedule = new int[] {cur[0], next[1]};
                schedule.set(i, newSchedule);
                schedule.remove(i + 1);
                return false;
            }
        }

        return false;
    }

    boolean isBefore(int newStart, int newEnd, int start, int end) {
        return newEnd < start;
    }

    boolean isAfter(int newStart, int newEnd, int start, int end) {
        return newStart > end;
    }

    boolean isOverlapBefore(int newStart, int newEnd, int start, int end) {
        return newStart < start && newEnd > start && newEnd < end;
    }

    boolean isOverlapAfter(int newStart, int newEnd, int start, int end) {
        return newStart > start && newStart < end && newEnd > end;
    }

    public static void main(String[] args) {
        Ba_MeetingScheduleI solution = new Ba_MeetingScheduleI();
        int[][] meetings = new int[][] {
                new int[] {1300, 1500},
                new int[] {930, 1200},
                new int[] {830, 845},
        };

        boolean result = solution.meetingSchedule(meetings, 1450, 1500);
        System.out.println(result);
    }
}
