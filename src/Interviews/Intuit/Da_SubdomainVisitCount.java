package Interviews.Intuit;
import java.util.*;

public class Da_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visitCount = new HashMap<>();

        for (String domain : cpdomains) {
            String[] pair = domain.split(" ");
            int count = Integer.parseInt(pair[0]);
            String[] subdomains = pair[1].split("\\.");

            String subdomain = subdomains[subdomains.length - 1];
            int subdomainCount = visitCount.getOrDefault(subdomain, 0);
            visitCount.put(subdomain, subdomainCount + count);

            for (int i = subdomains.length - 2; i>= 0; i--) {
                subdomain = subdomains[i] + "." + subdomain;
                subdomainCount = visitCount.getOrDefault(subdomain, 0);
                visitCount.put(subdomain, subdomainCount + count);
            }
        }

        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : visitCount.entrySet()) {
            String cur = entry.getValue() + " " + entry.getKey();
            result.add(cur);
        }

        return result;
    }
}
