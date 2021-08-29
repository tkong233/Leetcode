package CodeSignal;

public class ReverseDigitsInPairs {
    static int reverseDigitsInPairs(int n) {
        char[] array = String.valueOf(n).toCharArray();
        for (int i = 0; i < array.length; i+= 2) {
            if (i + 1 < array.length) {
                char temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        return Integer.valueOf(new String(array));
    }

    public static void main(String[] args) {
        int result = reverseDigitsInPairs(123456);
        System.out.println(result);
    }
}
