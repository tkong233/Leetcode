package Interviews.Intuit;

import java.util.*;

public class Aa_FindCommonCourses {
    /*
        输入学生的ID和他上的课程，找到每两个学生上的相同的课程。

        例如，输入{{"58", "A"}, {"94", "B"}, {"17", "A"}, {"58", "B"}, {"17", "B"}, {"58", "C"}}

        输出:[58, 94]: [B]

        [58, 17]: [A, B]

        [94, 17]: [B]
     */

    /*
        clarification:
        1. students, courses not null?
        2. students == 2?
        3. students are valid? (appeared in courses)
        4. what to return in these corner cases?
     */

    /*
        Time = O(s + c)
        Space = O(s + c)

        where s = total number of students,
              c = total number of courses
     */

    List<String> findCommonCourses(List<String> students, List<List<String>> courses) {
        List<String> commonCourses = new LinkedList<>();
        if (courses == null || courses.size() == 0 || students == null || students.size() < 2) {
            return commonCourses;
        }

        Map<String, Set<String>> courseMap = new HashMap<>(); // space O(s + c)
        getCourseMap(courseMap, courses); // time O(s + c)

        Set<String> courses1 = courseMap.get(students.get(0));
        Set<String> courses2 = courseMap.get(students.get(1));

        if (courses1 == null || courses2 == null) {
            return commonCourses;
        }

        for(String s : courses1) { // worst case: time = O(c)
            if (courses2.contains(s)) {
                commonCourses.add(s);
            }
        }

        return commonCourses;
    }

    private void getCourseMap(Map<String, Set<String>> courseMap, List<List<String>> courses) {
        for (List<String> course : courses) {
            courseMap.put(course.get(0), new HashSet<>());
        } // time: O(s)

        for (List<String> studentCourse : courses) {
            String student = studentCourse.get(0);
            Set<String> course = courseMap.get(student);
            course.add(studentCourse.get(1)); // O(c)
            courseMap.put(student, course);
        }
    }

    public static void main(String[] args) {
        List<String> course1 = Arrays.asList("58", "A");
        List<String> course2 = Arrays.asList("94", "B");
        List<String> course3 = Arrays.asList("17", "A");
        List<String> course4 = Arrays.asList("58", "B");
        List<String> course5 = Arrays.asList("17", "B");
        List<String> course6 = Arrays.asList("58", "C");

        List<List<String>> courses = new LinkedList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);

        Aa_FindCommonCourses solution = new Aa_FindCommonCourses();
        List<String> result = solution.findCommonCourses(Arrays.asList("94", "17"), courses);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
