package Interviews.Robinhood;
import java.util.*;

public class FindMedianCourse {
    /*
        Clarification:
        1. for even number of courses, e.g. 0 -> 1, do we return 0 or 1? => assume 0

        Solution:
        1. traverse all courses, maintain two hash maps:
            1) hash map: preToCourse
            2) hash set: dependentCourses
        2. find the courses that's not a dependent course (i.e. doesn't have prereq, is head of dependency list),
            then construct course dependency list
        3. return middle node of list
     */
    private String findMedianCourseI(String[][] courses) {
        Map<String, String> preToCourse = new HashMap<>();
        Set<String> dependentCourses = new HashSet<>();

        for (String[] coursePair : courses) {
            String pre = coursePair[0];
            String cur = coursePair[1];
            preToCourse.put(pre, cur);
            dependentCourses.add(cur);
        }

        List<String> courseList = new ArrayList<>();
        for (String pre : preToCourse.keySet()) {
            if (!dependentCourses.contains(pre)) {
                while (pre != null) {
                    courseList.add(pre);
                    pre = preToCourse.get(pre);
                }
            }
        }

        return courseList.get((courseList.size() - 1) / 2);
    }

    /*
        Clarification:
        1. some courses may be median of multiple paths, do we return multiple copies of it, or do we return all distinct courses?
            => assume distinct

        Solution:
        1. construct course map
            traverse all courses,
            maintain a hash map: prerequisite -> list of dependent courses
            and a hash set: dependent courses
        2. start from each non-dependent courses, do dfs to find all paths start from it
            when reach end of a path (not a prerequisite of any course), add middle node of path to result set
     */
    private List<String> findMedianCourseII(String[][] courses) {
        Map<String, List<String>> preToCourses = new HashMap<>();
        Set<String> dependentCourses = new HashSet<>();
        for (String[] coursePair : courses) {
            String pre = coursePair[0];
            String cur = coursePair[1];
            List<String> dependents = preToCourses.getOrDefault(pre, new ArrayList<>());
            dependents.add(cur);
            preToCourses.put(pre, dependents);
            dependentCourses.add(cur);
        }
        Set<String> medianCourses = new HashSet<>();
        List<String> path = new ArrayList<>();
        for (String pre : preToCourses.keySet()) {
            if (!dependentCourses.contains(pre)) {
                path.add(pre);
                dfs(pre, preToCourses, path, medianCourses);
                path.clear();
            }
        }
        return new ArrayList<>(medianCourses);
    }

    private void dfs(String pre, Map<String, List<String>> preToCourses, List<String> path, Set<String> medianCourses) {
        if (!preToCourses.containsKey(pre)) {
            medianCourses.add(path.get((path.size() - 1) / 2));
            return;
        }
        for (String dependent : preToCourses.get(pre)) {
            path.add(dependent);
            dfs(dependent, preToCourses, path, medianCourses);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindMedianCourse solution = new FindMedianCourse();
        String result1 = solution.findMedianCourseI(new String[][] {
                {"ds", "algo"},
                {"robo", "me"},
                {"algo", "robo"}
        });
        System.out.println(result1);

        List<String> result2 = solution.findMedianCourseII(new String[][] {
                {"Logic", "COBOL"},
                {"Data Structures", "Algorithms"},
                {"Creative Writing", "Data Structures"},
                {"Algorithms", "COBOL"},
                {"Intro to Computer Science", "Data Structures"},
                {"Logic", "Compilers"},
                {"Data Structures", "Logic"},
                {"Graphics", "Networking"},
                {"Networking", "Algorithms"},
                {"Creative Writing", "System Administration"},
                {"Databases", "System Administration"},
                {"Creative Writing", "Databases"},
                {"Intro to Computer Science", "Graphics"}
        });
        System.out.println(result2);
    }
}
