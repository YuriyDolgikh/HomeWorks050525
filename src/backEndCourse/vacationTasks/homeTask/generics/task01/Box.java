package backEndCourse.vacationTasks.homeTask.generics.task01;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> items;

    public Box() {
        this.items = new ArrayList<>();
    }

    public void put(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Box{" +
                "items=" + items +
                '}';
    }
}
