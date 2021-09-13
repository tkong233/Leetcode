package Interviews.Robinhood;
import java.util.*;

public class ResourcesAccessLog {
    /*
        each log = [timestamp, username, resourceId]

        traverse each log entry, maintain a map: userToMinMax
     */
    List<List<String>> userMinMaxAccess(String[][] logs) {
        Map<String, List<Integer>> userToMinMax = new HashMap<>();

        for (String[] log : logs) {
            int time = Integer.valueOf(log[0]);
            String user = log[1];
            List<Integer> minMax = userToMinMax.getOrDefault(user, new ArrayList<>());
            if (minMax.size() == 0) {
                minMax.add(time);
                minMax.add(time);
            } else {
                if (minMax.get(0) > time) {
                    minMax.set(0, time);
                }
                if (minMax.get(1) < time) {
                    minMax.set(1, time);
                }
            }
            userToMinMax.put(user, minMax);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : userToMinMax.entrySet()) {
            String user = entry.getKey();
            String min = entry.getValue().get(0) + "";
            String max = entry.getValue().get(1) + "";
            result.add(Arrays.asList(user, min, max));
        }

        return result;
    }

    /*
        each log = [timestamp, username, resourceId]

        traverse each resource entry, construct a hash map: resource -> list of access times
        for each map entry: source access times, sliding window of 5min time span to find max access; update global max if necessary
     */
    private Map<String, Integer> findHotestResourceIn5Min(String[][] logs) {
        Map<String, List<Integer>> resourceToTimes = new HashMap<>();
        for (String[] log : logs) {
           int time = Integer.valueOf(log[0]);
           String resource = log[2];
           List<Integer> times = resourceToTimes.getOrDefault(resource, new ArrayList<>());
           times.add(time);
           resourceToTimes.put(resource, times);
        }

        int max = 0;
        String maxResource = "";
        for (Map.Entry<String, List<Integer>> entry: resourceToTimes.entrySet()) {
            String resource = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            int start = 0;
            int end = 0;
            while (end + 1 < times.size()) {
                if (times.get(end + 1) - times.get(start) <= 300) {
                    end++;
                    if (end - start + 1 > max) {
                        max = end - start + 1;
                        maxResource = resource;
                    }
                    max = Math.max(end - start + 1, max);
                } else {
                    start++;
                }
            }
        }
        Map<String, Integer> result = new HashMap<>();
        result.put(maxResource, max);
        return result;
    }

    /*
        [timestamp, username, resourceId]

        1. construct map of user -> list of resources accessed
        2. traverse all resource access list, build map of resource -> {next resource, count of this transition}
            for each resource access list:
                process start,
                    get first resource in list, add to map {start -> {res, count++}}
                process elements in between,
                    for each pair of res[i] and res[i + 1], add to map {res[i] -> {res[i + 1], count++}
                process end
                    get last resource in list, add to map {res -> {end, count++}}
        3. calculate probability
     */
    private Map<String, Map<String, Double>> resourcesTransitionGraph(String[][] logs) {
        Arrays.sort(logs, (log1, log2) -> {
           int time1 = Integer.valueOf(log1[0]);
           int time2 = Integer.valueOf(log2[0]);
           return time1 - time2;
        });
        // construct user profile
        Map<String, List<String>> userToRes = new HashMap<>();
        for (String[] log : logs) {
            String user = log[1];
            String res = log[2];
            List<String> resList = userToRes.getOrDefault(user, new ArrayList<>());
            resList.add(res);
            userToRes.put(user, resList);
        }

        // count transition frequency
        Map<String, Map<String, Double>> resToNext = new HashMap<>();
        for (List<String> resList : userToRes.values()) {
            // process start
            Map<String, Double> startMap = resToNext.getOrDefault("START", new HashMap<>());
            String start = resList.get(0);
            double count = startMap.getOrDefault(start, 0.0);
            startMap.put(start, count + 1);
            resToNext.put("START", startMap);

            // process mid
            for (int i = 0; i < resList.size() - 1; i++) {
                String cur = resList.get(i);
                String next = resList.get(i + 1);
                Map<String, Double> nextMap = resToNext.getOrDefault(cur, new HashMap<>());
                count = nextMap.getOrDefault(next, 0.0);
                nextMap.put(next, count + 1);
                resToNext.put(cur, nextMap);
            }

            // process end
            String end = resList.get(resList.size() - 1);
            Map<String, Double> endMap = resToNext.getOrDefault(end, new HashMap<>());
            count = endMap.getOrDefault("END", 0.0);
            endMap.put("END", count + 1);
            resToNext.put(end, endMap);
        }

        // calculate transition probability
        for (Map<String, Double> resToCount : resToNext.values()) {
            double total = 0.0;
            for (double count : resToCount.values()) {
                total += count;
            }
            for (Map.Entry<String, Double> entry : resToCount.entrySet()) {
                resToCount.put(entry.getKey(), entry.getValue() / total);
            }
        }

        return resToNext;
    }

    public static void main(String[] args) {
        ResourcesAccessLog solution = new ResourcesAccessLog();
        String[][] logs = new String[][] {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };

        String[][] logs2= new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        List<List<String>> result = solution.userMinMaxAccess(logs);
        for (List<String> r : result) {
            System.out.println(r);
        }

        Map<String, Integer> hotResource = solution.findHotestResourceIn5Min(logs);
        System.out.println(hotResource);

        Map<String, Map<String, Double>> transitionMap = solution.resourcesTransitionGraph(logs);
        System.out.println("Q3:");
        System.out.println(transitionMap);
    }
}
