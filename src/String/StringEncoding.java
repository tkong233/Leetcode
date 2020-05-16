package String;

public class StringEncoding {
    /*
        Encode a string
        aaabbcdddd => a3b2cd4
        abcd => abcd
     */
    String encodeString(String input) {
        char[] a = input.toCharArray();
        int s = 0;
        int count = 1;
        for (int f = 1; f < a.length; f++) {
            // 举一反三，这种类逻辑块中，最后一个character都可能被漏掉没处理
             if (a[f] == a[f - 1]) {
                count++;
            } else {
                a[s] = a[f - 1];
                if (count == 1) {
                    s++;
                } else {
                    // 注意这里如何把int转换成corresponding char
                    a[s + 1] = (char) ('0' + count);
                    s += 2;
                    count = 1;
                }
            }
        }
        // 这个算法只有在 a[f] != a[f-1] 时才会copy character到s pointer
        // 因此，最后一个character不会被copy
        //  process the last character here
        a[s] = a[a.length - 1];
        s++;
        if (count > 1) {
            a[s] = (char) ('0' + count);
            s++;
        }
        return new String(a, 0, s);
    }

    public static void main(String[] args) {
        StringEncoding solution = new StringEncoding();
        System.out.println(solution.encodeString("aaaaaa"));
    }
}
