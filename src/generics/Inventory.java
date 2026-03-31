package generics;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {
    private List<T> items = new ArrayList();

    public void add(T item) {
        items.add(item);
    }

    public T getFirst() {
        if(!items.isEmpty()) {
            return items.get(0);
        }else{
            return null;
        }
    }
    public int size() {
        return items.size();
    }
}