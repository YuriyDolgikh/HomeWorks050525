package workInClasses.lessonPro07.task1;

import java.util.Comparator;

public class BookComparatorByYear implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getYear() - o2.getYear();
    }
}
