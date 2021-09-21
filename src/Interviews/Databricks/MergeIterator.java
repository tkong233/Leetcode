package Interviews.Databricks;
import java.util.*;

public class MergeIterator {
    int next1;
    int next2;
    boolean valid1;
    boolean valid2;
    Iterator<Integer> iter1;
    Iterator<Integer> iter2;

    public MergeIterator(Iterator<Integer> iter1, Iterator<Integer> iter2) {
        this.iter1 = iter1;
        this.iter2 = iter2;
    }

    public int next() {
        if (!valid1 && iter1.hasNext()) {
            next1 = iter1.next();
            valid1 = true;
        }
        if (!valid2 && iter2.hasNext()) {
            next2 = iter2.next();
            valid2 = true;
        }
        // if one of the iter runs out of numbers
        if (!valid1 && !valid2) {
            return -1;
        } else if (!valid1) {
            valid2 = false;
            return next2;
        } else if (!valid2) {
            valid1 = false;
            return next1;
        }
        // if both iters still have numbers
        if (next1 < next2) {
            valid1 = false;
            return next1;
        } else {
            valid2 = false;
            return next2;
        }
    }

    public boolean hasNext() {
        return iter1.hasNext() || iter2.hasNext() || valid1 || valid2;
    }


    // i
    //  1 3 6 8 10
    // j
    //  0 1 2 4 5 7 8
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 6, 8, 10);
        List<Integer> list2 = Arrays.asList(0, 1, 2, 4, 5, 7, 8);
        Iterator iter1 = list1.iterator();
        Iterator iter2 = list2.iterator();

        MergeIterator iter = new MergeIterator(iter1, iter2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
