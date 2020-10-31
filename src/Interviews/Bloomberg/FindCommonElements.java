package Interviews.Bloomberg;
import java.lang.reflect.Array;
import java.util.*;

public class FindCommonElements {
    List<Integer> findCommonElements(List<List<Integer>> input) {
        List<Integer> result = new LinkedList<>();
        if (input == null || input.size() == 0) {
            return result;
        }

        Map<Integer, Integer> commonElementsToCount = new HashMap<>();
        List<Integer> firstList = input.get(0);
        for (int element : firstList) {
            int count = commonElementsToCount.getOrDefault(element, 0);
            commonElementsToCount.put(element, count + 1);
        }

        Map<Integer, Integer> curCommonElementsToCount = new HashMap<>();
        for (int i = 1; i < input.size(); i++) {
            curCommonElementsToCount.clear();
            List<Integer> curList = input.get(i);
            getCurCommonElementsCount(curList, curCommonElementsToCount, commonElementsToCount);
            updateCommonElementsCount(curCommonElementsToCount, commonElementsToCount);
        }

        return convertElementsCountToResult(commonElementsToCount);
    }

    private void getCurCommonElementsCount(List<Integer> list,
                                           Map<Integer, Integer> curCommonElementsToCount,
                                           Map<Integer, Integer> commonElementsToCount) {
        for (int element : list) {
            if (!commonElementsToCount.containsKey(element)) {
                continue;
            }
            int count = curCommonElementsToCount.getOrDefault(element, 0);
            curCommonElementsToCount.put(element, count + 1);
        }
    }

    private void updateCommonElementsCount(Map<Integer, Integer> curCommonElementsToCount,
                                           Map<Integer, Integer> commonElementsToCount) {
        Iterator<Map.Entry<Integer, Integer>> iterator = commonElementsToCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int element = entry.getKey();
            int count = entry.getValue();
            if (!curCommonElementsToCount.containsKey(element)) {
                iterator.remove();
                continue;
            }
            count = Math.min(count, curCommonElementsToCount.get(element));
            commonElementsToCount.put(element, count);
        }
    }

    private List<Integer> convertElementsCountToResult(Map<Integer, Integer> commonElementsToCount) {
        List<Integer> result = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : commonElementsToCount.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindCommonElements solution = new FindCommonElements();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> ls1 = Arrays.asList(1, 1, 1, 3, 6);
        List<Integer> ls2 = Arrays.asList(1, 1, 3, 5, 8);
        List<Integer> ls3 = Arrays.asList(1, 1, 3, 4, 6);
        input.add(ls1);
        input.add(ls2);
        input.add(ls3);
        List<Integer> result = solution.findCommonElements(input);
        for (int element : result) {
            System.out.print(element + " ");
        }
    }
}
