package backEndCourse.vacationTasks.homeTask.generics.task05;

import java.util.LinkedList;
import java.util.List;

public class Stack<E> {
    List<E> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    public void push(E element) {
        stack.add(element);
    }

    public E pop() {
        return stack.removeLast();
    }

    public E peek() {
        return stack.getLast();
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return "Stack: [" + stack +"]";
    }
}
