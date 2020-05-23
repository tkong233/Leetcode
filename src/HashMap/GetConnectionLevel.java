package HashMap;

import java.util.*;

public class GetConnectionLevel {
    /*
    given data like this:
    user_ids = ['A', 'B', 'C', 'D', 'E', 'F']
    connections = [('A', 'B'),
            ('A', 'C'),
            ('B', 'C'),
            ('C', 'E'),
            ('E', 'F'),
            ('D', 'F')]
            - write function:

    def get_connection_level(user_id1, user_id2):
            """
    input are two users
    return connection level, like 1st connection or 2nd or no connection

    input A, B
    return 1
    input A, E
    return 2
    input A, G
    return 0 no conneciton
    """
            // Assumptions: all input users are valid
            // return 0 if id1 == id2
            // if there are two paths to a same user, choose the shorter one

    */



    int getConnectionLevel(int id1, int id2, List<List<Integer>> connections) {
        // assumption: both id1 and id2 are valid
        if (id1 == id2) {
            return 0;
        }
        Map<Integer, List<Integer>> connectionMap = createConnectionMap(connections);
        List<Integer> list = connectionMap.get(id1);
        if (list != null) {
            if (list.contains(id2)) {
                return 1;
            } else {
                int level = 2;
                List<Integer> nextLevel = traverseList(list, connectionMap);
                while (nextLevel != null && nextLevel.size() > 0) {
                    if (nextLevel.contains(id2)) {
                        return level;
                    } else {
                        level++;
                        nextLevel = traverseList(nextLevel, connectionMap);
                    }
                }
            }
        }
        // if id1 and id2 are not connected, return -1
        return -1;
    }

    // given a list of user ids,
    // return a list of user ids that are directly connected to this list of users,
    // excluding ids that exist in the input list
    List<Integer> traverseList(List<Integer> list, Map<Integer, List<Integer>> connections) {
        Set<Integer> nextLevelId = new HashSet<>();
        for (Integer id : list) {
            List<Integer> nextList = connections.get(id);
            if (nextList != null) {
                for (int i : nextList) {
                    if (!list.contains(i)) {
                        nextLevelId.add(i);
                    }
                }
            }
        }
        return new LinkedList<>(nextLevelId);
    }

    // given a list of connections <<1, 3>, <2, 3>>
    // return a map where key is an id, value is a list of ids connected to this id
    Map<Integer, List<Integer>> createConnectionMap(List<List<Integer>> connections) {
        Map<Integer, List<Integer>> connectionMap = new HashMap<>();
        for (List l : connections) {
            Integer id1;
            Integer id2;
            if (l.size() >= 2) {
                id1 = (Integer) l.get(0);
                id2 = (Integer) l.get(1);
                List<Integer> connectionList1 = connectionMap.get(id1);
                List<Integer> connectionList2 = connectionMap.get(id2);
                if (connectionList1 != null) {
                    connectionList1.add(id2);
                } else {
                    List<Integer> newConnectionList = new LinkedList<>();
                    newConnectionList.add(id2);
                    connectionMap.put(id1, newConnectionList);
                }
                if (connectionList2 != null) {
                    connectionList2.add(id1);
                } else {
                    List<Integer> newConnectionList = new LinkedList<>();
                    newConnectionList.add(id1);
                    connectionMap.put(id2, newConnectionList);
                }
            }
        }
        return connectionMap;
    }

    public static void main(String[] args) {
        GetConnectionLevel solution = new GetConnectionLevel();
        List<List<Integer>> connections = new LinkedList<>();
        List<Integer> c1 = Arrays.asList(1, 3);
        List<Integer> c2 = Arrays.asList(2, 3);
        List<Integer> c3 = Arrays.asList(3, 5);
        List<Integer> c4 = Arrays.asList(5, 6);
        connections.add(c1);
        connections.add(c2);
        connections.add(c3);
        connections.add(c4);

        int result = solution.getConnectionLevel(6, 1, connections);
        System.out.println(result);
    }
}
