public class Test {

    public static void main(String[] args) {
        int a = 1234;
        while (a > 0) {
            int digit = a % 10;
            System.out.println(digit);
            a /= 10;
        }
    }
}
