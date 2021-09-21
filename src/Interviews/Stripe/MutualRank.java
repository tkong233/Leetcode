package Interviews.Stripe;

import java.util.List;
import java.util.Map;

public class MutualRank {
    public boolean hasMutualRank(Map<String, List<String>> userMap, String user) {
        List<String> ranks = userMap.getOrDefault(user, null);
        if (ranks == null || ranks.size() == 0) {
            return false;
        }
        String first = ranks.get(0);
        List<String> firstRanks = userMap.getOrDefault(first, null);
        if (firstRanks == null || firstRanks.size() == 0) {
            return false;
        }
        return firstRanks.get(0).equals(user);
    }


}
