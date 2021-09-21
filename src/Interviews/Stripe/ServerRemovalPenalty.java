package Interviews.Stripe;

public class ServerRemovalPenalty {
    public int getServerRemovalPenalty(String log, int removeTime) {
        int penalty = 0;
        for (int i = 0; i < log.length(); i++) {
            if (i + 1 < removeTime && log.charAt(i) == '1') {
                penalty++;
            } else if (i + 1 > removeTime && log.charAt(i) == '0') {
                penalty++;
            }
        }

        return penalty;
    }

    public static void main(String[] args) {
        ServerRemovalPenalty solution = new ServerRemovalPenalty();
        int result = solution.getServerRemovalPenalty("1110", 0);
        System.out.println(result);
    }
}
