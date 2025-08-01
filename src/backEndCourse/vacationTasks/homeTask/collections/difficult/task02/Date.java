package backEndCourse.vacationTasks.homeTask.collections.difficult.task02;

import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Date date)) return false;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        String monthStr = month < 10 ? "0" + month : "" + month;
        String dayStr = day < 10 ? "0" + day : "" + day;
        return "Time: " + dayStr + "." + monthStr + "." + year;
    }
}
