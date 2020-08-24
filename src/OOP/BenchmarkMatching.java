package OOP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
/*

    **测试输入下载测试 1 输入**

    Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10

    Vodafone,STOCK,10|Google,STOCK,15
    Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10

    **预期输出下载测试 1 输入**

    SELL,Google,STOCK,5
    BUY,Vodafone,BOND,10
    BUY,Vodafone,STOCK,5

 */

public class BenchmarkMatching {
    public static void main(String[] args) throws IOException {

//        Asset a = new Asset("Google", AssetType.BOND);
//        Asset b = new Asset("Google", AssetType.BOND);
//        System.out.println(a.equals(b));

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            matchBenchmark(line);
        }
    }



    public enum AssetType {
        BOND, STOCK;
    }

    public static class Asset {
        String name;
        AssetType type;

        public Asset(String name, AssetType type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o instanceof Asset)) {
                return false;
            }

            Asset c = (Asset) o;

            return this.name.equals(c.name) && this.type.equals(c.type);
        }

        @Override
        public int hashCode() {
            int result = 0;
            for (int i = 0; i < this.name.length(); i++) {
                result += this.name.charAt(i);
            }


            return this.type == AssetType.BOND ? result : result + 1;
        }
    }

    public static void matchBenchmark(String input) {
        Map<Asset, Integer> portfolio = new HashMap<>();
        Map<Asset, Integer> benchmark = new HashMap<>();


        parseInput(portfolio, benchmark, input);

        for (Map.Entry<Asset, Integer> entry : portfolio.entrySet()) {
            String name = entry.getKey().name;
            AssetType type = entry.getKey().type;
            int share = entry.getValue();

            Integer benchmarkShare = benchmark.get(entry.getKey());
            if (benchmarkShare != null && benchmarkShare != share) {
                String action = (share > benchmarkShare) ? "SELL" : "BUY";
                int amount = Math.abs(share - benchmarkShare);
                System.out.println(action + "," + name + "," + type + "," + amount);
                benchmark.remove(entry.getKey());
                continue;
            }

            System.out.println("SELL" + "," + name + "," + type + "," + share);
        }

        for (Map.Entry<Asset, Integer> entry : benchmark.entrySet()) {
            String name = entry.getKey().name;
            AssetType type = entry.getKey().type;
            int share = entry.getValue();

            System.out.println("BUY" + "," + name + "," + type + "," + share);
        }

    }


    private static void parseInput(Map<Asset, Integer> portfolio, Map<Asset, Integer> benchmark, String input) {
        String[] portfolioBenchmark = input.split(":");
        String[] portfolioInput = portfolioBenchmark[0].split("\\|");
        String[] benchmarkInput = portfolioBenchmark[1].split("\\|");



        for (String trade : portfolioInput) {
            String[] s = trade.split(",");
            String name = s[0];
            AssetType type = AssetType.valueOf(s[1]);
            int share = Integer.parseInt(s[2]);
            portfolio.put(new Asset(name, type), share);
        }

        for (String trade : benchmarkInput) {
            String[] s = trade.split(",");
            String name = s[0];
            AssetType type = AssetType.valueOf(s[1]);
            int share = Integer.parseInt(s[2]);
            benchmark.put(new Asset(name, type), share);
        }
    }
}
