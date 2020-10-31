import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    static int count = 0;
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add(2);
        System.out.println((list.get(0) instanceof Object));

        System.out.println((list.get(1) instanceof Integer));
    }
}
