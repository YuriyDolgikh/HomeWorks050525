package backEndCourse.vacationTasks.homeTask.collections.difficult.task07;

import java.util.Objects;

public class Time implements Comparable<Time> {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Time time)) return false;
        return hour == time.hour && minute == time.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    @Override
    public String toString() {
        String hourString = hour < 10 ? "0" + hour : "" + hour;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        return "Time: " + hourString + ":" + minuteString;
    }

    @Override
    public int compareTo(Time o) {
        int result = hour - o.hour;
        if (result == 0) {
            result = minute - o.minute;
        }
        return result;
    }
}
