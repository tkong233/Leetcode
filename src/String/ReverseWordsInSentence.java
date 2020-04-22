package String;

public class ReverseWordsInSentence {
    // assumption:
    // 1. words are separated by one white space character
    // 2. no leading / trailing spaces
    // 3. input is not null

    String reverseWords(String input) {
        char[] a = input.toCharArray();
        // step 1: reverse all characters
        reverse(a, 0, a.length - 1);

        // step 2: reverse each word
        int left = 0;
        for (int i = 0; i < a.length; i++) {
            // 过去错误：如果仅仅用white space识别words，没法涵盖最后一个word的情况
            if (a[i] != ' ' && (i == 0 || a[i -1] == ' ')) {
                left = i;
            }

            if (a[i] != ' ' && (i == a.length - 1 || a[i + 1] == ' ')) {
                reverse(a, left, i);
            }
        }
        return new String(a);
    }

    // reverse characters of a in [left, right]
    void reverse(char[] a, int left, int right) {
        while (left < right) {
            swap(a, left++, right--);
        }
    }

    void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ReverseWordsInSentence solution = new ReverseWordsInSentence();
        System.out.println(solution.reverseWords("my name is bob"));
    }
}
