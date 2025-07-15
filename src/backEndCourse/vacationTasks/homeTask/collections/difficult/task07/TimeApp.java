package backEndCourse.vacationTasks.homeTask.collections.difficult.task07;

/*
    7 Создать отображение LinkedHashMap, где ключом является объект Time (время), а значением - список строк.
      Затем добавить несколько строк в список для каждого времени и вывести все элементы отображения на консоль
      в порядке возрастания времени.
 */

import java.util.*;

public class TimeApp {
    public static void main(String[] args) {
        Map<Time, List<String>> events = new LinkedHashMap<>();
        Time time1 = new Time(5, 5);
        Time time2 = new Time(18, 3);
        Time time3 = new Time(5, 3);

        addEventToTime(events, new Time(5, 3), "Event 1");
        addEventToTime(events, time1, "Event 2");
        addEventToTime(events, time2, "Event 3");
        addEventToTime(events, time3, "Event 4");
        addEventToTime(events, time2, "Event 5");
        addEventToTime(events, time3, "Event 6");
        addEventToTime(events, new Time(5, 5), "Event 7");

        Map<Time, List<String>> treeEvents = new TreeMap<>(events);
        events = new LinkedHashMap<>(treeEvents);

        printEvents(events);
    }

    private static void addEventToTime(Map<Time, List<String>> events, Time time, String event) {
        if (events.containsKey(time)) {
            events.get(time).add(event);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(event);
            events.put(time, newList);
        }
    }

    private static void printEvents(Map<Time, List<String>> events) {
        for (Map.Entry<Time, List<String>> entry : events.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
