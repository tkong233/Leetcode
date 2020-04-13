package String;

public class RemoveChar {
    StringBuilder removeChar(StringBuilder input) {
        if (input == null || input.length() <= 0) {
            return input;
        }
        int i = 0;
        for (int j = 0; j < input.length(); j++) {
            if (!(input.charAt(j) == 'u' || input.charAt(j) == 'n')) {
                input.setCharAt(i, input.charAt(j));
                i++;
            }
        }
        return input.delete(i, input.length());
    }

    public static void main(String[] args) {
        StringBuilder input = new StringBuilder("studentuuuuann");
        RemoveChar solution = new RemoveChar();
        StringBuilder output = solution.removeChar(input);
        System.out.println(output);
    }
}
