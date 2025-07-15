package backEndCourse.vacationTasks.homeTask.collections.difficult.task10;

public class Employee {
    private String name;
    private Department department;
    private int salary;

    public Employee(String name, Department department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee => Name: " + name + ", Department: " + department.getDepartmentName() + ", Salary=" + salary;
    }
}
