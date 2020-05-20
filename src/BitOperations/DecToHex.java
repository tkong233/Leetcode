package BitOperations;

public class DecToHex {
    String decToHex(int x) {
        if (x == 0) {
            return "0x0";
        }
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int reminder = x % 16;
            sb.append(base[reminder]);
            x /= 16;
        }
        sb.append("x0");
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        DecToHex solution = new DecToHex();
        System.out.println(solution.decToHex(167));
    }
}
