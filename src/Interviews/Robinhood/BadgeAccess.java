package Interviews.Robinhood;
import java.util.*;

public class BadgeAccess {
    // given <name, timestamp> pairs, find people appeared >= 3 times within an hour
    // output: <B, 850, 890, 950>

    // max group that were in the room together during two or more separate time periods
    /*
       1. sort input based on timestamp
       2. maintain a hashmap: set of people in room together -> list of start time, end time
       3. traverse input entries, maintain set of people in room together & prevEnterTime
            for each entry (person, time, action)
            if enter => add person to set, update prevEnterTime = time
            if exit => add to hash map (cur set of people -> {prevEnterTime, time}),
                        check if there exists subset of cur group in hashmap key, add time as well
                        delete person from set
        4. find map entry with largest group that have at least two entries in time list
     */

    void findMaxGroup(List<String[]> input) {
        Collections.sort(input, (s1, s2) -> {
            int t1 = Integer.valueOf(s1[1]);
            int t2 = Integer.valueOf(s2[1]);
            if (t1 == t2) {
                return 0;
            }
            return t1 < t2 ? -1 : 1;
        });

        Set<String> group = new HashSet<>();
        int lastEnterTime = -1;
        Map<Set<String>, Set<List<Integer>>> groupToTimes = new HashMap<>();
        for (String[] s : input) {
            if (s[2].equals("enter")) {
                group.add(s[0]);
                lastEnterTime = Integer.valueOf(s[1]);
            } else {
                Set<List<Integer>> times = groupToTimes.getOrDefault(group, new HashSet<>());
                times.add(Arrays.asList(lastEnterTime, Integer.valueOf(s[1])));
                groupToTimes.put(new HashSet<>(group), times);
                for (Set<String> otherGroup : groupToTimes.keySet()) {
                    if (group.containsAll(otherGroup)) {
                        Set<List<Integer>> otherTimes = groupToTimes.get(otherGroup);
                        otherTimes.add(Arrays.asList(lastEnterTime, Integer.valueOf(s[1])));
                        groupToTimes.put(otherGroup, otherTimes);
                    }
                }
                group.remove(s[0]);
            }
        }

        Set<String> maxGroup = new HashSet<>();
        Set<List<Integer>> maxGroupTimes = null;
        for (Map.Entry<Set<String>, Set<List<Integer>>> entry : groupToTimes.entrySet()) {
            Set<String> curGroup = entry.getKey();
            Set<List<Integer>> curTimes = entry.getValue();
            if (curTimes.size() < 2) {
                continue;
            }
            if (curGroup.size() > maxGroup.size()) {
                maxGroup = curGroup;
                maxGroupTimes = curTimes;
            }
        }

        System.out.println(maxGroup.toString());
        for (List<Integer> times : maxGroupTimes) {
            System.out.println(times.toString());
        }
    }

    // better version: use a sliding window for each person
    List<List<String>> findFrequentAccess1(List<String[]> input) {
        Map<String, List<Integer>> nameToTimes = new HashMap<>();
        for (String[] s : input) {
            List<Integer> times = nameToTimes.getOrDefault(s[0], new ArrayList<>());
            times.add(Integer.valueOf(s[1]));
            nameToTimes.put(s[0], times);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : nameToTimes.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            int left = 0;
            int right = 0;
            while (right < times.size()) {
                if (times.get(right) - times.get(left) <= 100) {
                    right++;
                } else {
                    left++;
                }
                if (right - left + 1 >= 3) {
                    List<String> resultEntry = new ArrayList<>();
                    resultEntry.add(name);
                    for (int i = left; i <= right; i++) {
                        resultEntry.add(times.get(i) + "");
                    }
                    result.add(resultEntry);
                    break;
                }
            }
        }
        return result;
    }


    /*
       1. sort based on timestamp
       2. maintain a sliding window over one hour time window
          maintain a hashmap: {name -> list of access times within an hour}
          init: left, right both start at 0
          at each step:
            if right time - left time <= 100, add right entry to hashmap
                if size(access times) == 3 => add to result
            else: while right time - left time > 100, remove left entry from hashmap, left++.
     */
    class Pair {
        String name;
        int time;
        public Pair(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
    List<List<String>> findFrequentAccess(List<String[]> input) {
        List<List<String>> result = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        for (String[] s : input) {
            list.add(new Pair(s[0], Integer.valueOf(s[1])));
        }
        Collections.sort(list, (p1, p2) -> {
            if (p1.time == p2.time) {
                return 0;
            }
            return p1.time < p2.time ? -1 : 1;
        });

        Map<String, List<Integer>> nameToTimes = new HashMap<>();
        Set<String> addedNames = new HashSet<>();

        int left = 0;
        int right = 0;
        while (right < list.size()) {
            Pair leftPair = list.get(left);
            Pair rightPair = list.get(right);
            if (rightPair.time - leftPair.time <= 100) {
                List<Integer> times = nameToTimes.getOrDefault(rightPair.name, new LinkedList<>());
                times.add(rightPair.time);
                nameToTimes.put(rightPair.name, times);
                if (times.size() >= 3 && !addedNames.contains(rightPair.name)) {
                    result.add(Arrays.asList(rightPair.name, times.get(0) + "", times.get(1) + "", times.get(2) + ""));
                    addedNames.add(rightPair.name);
                }
                right++;
            } else {
                List<Integer> times = nameToTimes.get(leftPair.name);
                times.remove(0);
                nameToTimes.put(leftPair.name, times);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BadgeAccess solution = new BadgeAccess();
//        solution.findFrequentAccess1(Arrays.asList(
//                new String[] {"A", "1500"},
//                new String[] {"B", "900"},
//                new String[] {"B", "1200"},
//                new String[] {"B", "850"},
//                new String[] {"B", "950"},
//                new String[] {"A", "750"},
//                new String[] {"A", "720"},
//                new String[] {"A", "810"},
//                new String[] {"A", "820"},
//                new String[] {"A", "830"}
//            ));

        solution.findMaxGroup(Arrays.asList(
                new String[] {"Paul", "1214", "enter"},
                new String[] {"Paul", "830", "enter"},
                new String[] {"Curtis", "1100", "enter"},
                new String[] {"Paul", "903", "exit"},
                new String[] {"John", "908", "exit"},
                new String[] {"Paul", "1235", "exit"},
                new String[] {"Jennifer", "900", "exit"},
                new String[] {"Curtis", "1330", "exit"},
                new String[] {"John", "815", "enter"},
                new String[] {"Jennifer", "1217", "enter"},
                new String[] {"Curtis", "745", "enter"},
                new String[] {"John", "1230", "enter"},
                new String[] {"Jennifer", "800", "enter"},
                new String[] {"John", "1235", "exit"},
                new String[] {"Curtis", "810", "exit"},
                new String[] {"Jennifer", "1240", "exit"}
        ));
    }
}
