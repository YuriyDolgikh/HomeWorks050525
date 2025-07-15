package backEndCourse.vacationTasks.homeTask.collections.difficult.task02;

/*
    2 Создать отображение TreeMap, где ключом является объект Time (дата), а значением - список строк.
      Затем добавить несколько строк в список для каждой даты и вывести все элементы отображения на консоль
      в порядке возрастания даты.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DateApp {
    public static void main(String[] args) {
        Map<Date, List<String>> events = new TreeMap<>(new DateComparator());
        Date date1 = new Date(5, 5, 2025);
        Date date2 = new Date(18, 3, 2025);
        Date date3 = new Date(5, 3, 2025);

        addEventToDate(events, new Date(5, 3, 2026), "Find new job )))");
        addEventToDate(events, date1, "Begin of Java course");
        addEventToDate(events, date2, "Begin of Front-end course");
        addEventToDate(events, date3, "Birthday!!!");
        addEventToDate(events, date2, "Online meeting with ...");
        addEventToDate(events, date3, "Call my mom");
        addEventToDate(events, new Date(05, 05, 2025), "Make daily schedule");

        printEvents(events);
    }

    private static void addEventToDate(Map<Date, List<String>> events, Date date, String event) {
        if (events.containsKey(date)) {
            events.get(date).add(event);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(event);
            events.put(date, newList);
        }
    }

    private static void printEvents(Map<Date, List<String>> events) {
        for (Map.Entry<Date, List<String>> entry : events.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
