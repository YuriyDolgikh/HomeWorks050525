package backEndCourse.lesson14.task04;

public class Student {
    private final String name;
    private final int age;
    private final Double avgGrade;
    private final int startYear;

    public Student(String name, int age, Double avgGrade, int startYear) {
        this.name = name;
        this.age = age;
        this.avgGrade = avgGrade;
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public int getStartYear() {
        return startYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", avgGrade=" + avgGrade +
                ", startYear=" + startYear +
                '}';
    }
}
