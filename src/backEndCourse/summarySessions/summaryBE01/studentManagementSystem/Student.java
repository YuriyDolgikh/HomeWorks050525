package backEndCourse.summarySessions.summaryBE01.studentManagementSystem;

/*
**Система управления студентами**

    - Реализуйте систему, которая хранит информацию о студентах и их оценках по различным предметам.
    - Используйте коллекцию для хранения информации.

    Технические требования:

        - Создайте класс Student, который содержит поля:
            имя студента,
            уникальный идентификатор (ID)
            HashMap<String, Integer>, где ключ - это название предмета, а значение - оценка по этому предмету.

        - Создайте класс StudentManagement, который будет управлять студентами.
          Этот класс должен содержать HashMap<Integer, Student>, где ключ - ID студента, а значение - объект Student.

        Реализуйте следующие методы в классе StudentManagement:
                void addStudent(int id, String name): добавление студента в систему.
                void addGrade(int id, String subject, int grade): добавление оценки студенту по определенному предмету.
                Student getStudent(int id): получение информации о студенте по ID.
                double getAverageGrade(int id): получение среднего балла студента по всем предметам.


 */

import java.util.HashMap;
import java.util.Map;

public class Student {
    private final int id;
    private final String name;
    private final Map<String, Integer> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
