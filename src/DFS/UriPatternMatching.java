package DFS;

import java.nio.file.Path;
import java.util.*;

public class UriPatternMatching {
    List<PathRoute> registeredRoutes = Arrays.asList(
            new PathRoute("/hello/hi/foo/bar"),
            new PathRoute("/hello/:name"),
            new PathRoute("/*/hello/foo/:id/*")
    );


    class PathRoute {
        String path;
        String[] matchList;

        public PathRoute(String path) {
            this.path = path;
            this.matchList = initMatchList(path);
        }

        public String[] getMatchList() {
            return this.matchList;
        }

        private String[] initMatchList(String path) {
            String[] list = path.split("/");
            return list;
        }
    }

    private PathRoute mapPathToRoute(String path,
                                     Map<String, String> params,
                                     List<String> wildcards) {
        for (PathRoute pr : registeredRoutes) {
            params.clear();
            wildcards.clear();
            if (isMatch(pr, path, params, wildcards)) {
                return pr;
            }
        }

        params.clear();
        wildcards.clear();
        return null;
    }

    private boolean isMatch(PathRoute pr,
                            String path,
                            Map<String, String> params,
                            List<String> wildcards) {
        String[] pattern = pr.getMatchList();
        String[] input = path.split("/");

        int p = 0;
        for (p = 0; p < pattern.length; p++) {
            if (p >= input.length) {
                return false;
            }

            String curPattern = pattern[p];
            String curInput = input[p];
            if (curPattern.length() == 0) {
                if (curInput.length() != 0) {
                    return false;
                }
                continue;
            } else if (curPattern.charAt(0) == ':') {
                params.put(curPattern.substring(1), curInput);
            } else if (curPattern.equals("*")) {
                wildcards.add(curInput);
            } else {
                if (!curPattern.equals(curInput)) {
                    return false;
                }
            }
        }

        return p == input.length;
    }
//            new PathRoute("/hello/hi/foo/bar"),
//            new PathRoute("/hello/:name"),
//            new PathRoute("/*/hello/foo/:id/*")

    public static void main(String[] args) {
        UriPatternMatching solution = new UriPatternMatching();
        Map<String, String> params = new HashMap<>();
        List<String> wildcards = new ArrayList<>();

        PathRoute result = solution.mapPathToRoute("/hello/hello/foo/id/wiill", params, wildcards);
        if (result == null) {
            System.out.println("No match");
        } else {
            System.out.println(result.path);
        }

        System.out.println("params: ");
        for (Map.Entry<String, String> entry: params.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("wildcards: ");
        for (String s: wildcards) {
            System.out.println(s);
        }
    }
}
