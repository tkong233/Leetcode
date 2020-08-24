package OOP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CalculateChange {


        /**
         * Iterate through each line of input.
         */
        public static void main(String[] args) throws IOException {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(reader);

            try {
                double purchasePrice = Double.parseDouble(in.readLine());
                double cash = Double.parseDouble(in.readLine());
                CalculateChange.calculateChange(purchasePrice, cash);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public enum CoinType {
            FIFTY_POUNDS(50, "Fifty Pounds"),
            TWENTY_POUNDS(20, "Twenty Pounds"),
            TEN_POUNDS(10, "Ten Pounds"),
            FIVE_POUNDS(5, "Five Pounds"),
            TWO_POUNDS(2, "Two Pounds"),
            ONE_POUND(1, "One Pound"),
            FIFTY_PENCE(0.5, "Fifty Pence"),
            TWENTY_PENCE(0.2, "Twenty Pence"),
            TEN_PENCE(0.1, "Ten Pence"),
            FIVE_PENCE(0.05, "Five Pence"),
            TWO_PENCE(0.02, "Two Pence"),
            ONE_PENCE(0.01, "One Pence");


            public final double value;
            public final String label;

		    private CoinType(double value, String label) {
		        this.value = value;
		        this.label = label;
            }
        }

        public static void calculateChange(double purchasePrice, double cash) {
            if (purchasePrice == cash) {
                System.out.println("Zero");
                return;
            }
            if (purchasePrice > cash) {
                System.out.println("ERROR");
                return;
            }

            StringBuilder sb = new StringBuilder();
            double change = cash - purchasePrice;

            for (CoinType coin : CoinType.values()) {
                System.out.println("coin: " + coin.label + " change: " + change);
                int coinCount = (int) (change / coin.value);
                for (int i = 0; i < coinCount; i++) {
                    sb.append(coin.label + ", ");
                }
                change -= Math.round(coin.value * coinCount * 100.0) / 100.0;
                change = Math.round(change * 100.0) / 100.0;
            }

            sb.delete(sb.length() - 2, sb.length());
            System.out.print(sb.toString());
        }
}
