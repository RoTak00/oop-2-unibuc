package lab9.ex1;

import java.util.ArrayList;

public class ListHelper {

    public static<T> T getNth(ArrayList<T> list, int n) {

        if (list.size() < n) {
            return null;
        }

        return list.get(n - 1);
    }
}
