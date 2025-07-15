package backEndCourse.vacationTasks.homeTask.collections.difficult.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements Comparable<Department>{
    private final String departmentName;
    private final List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary(){
        if (employees.isEmpty()) return 0.0;
        double averageSalary = 0.0;
        for (Employee employee : employees) {
            averageSalary += employee.getSalary();
        }
        return averageSalary / employees.size();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Department that)) return false;
        return Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departmentName);
    }

    @Override
    public int compareTo(Department o) {
        return departmentName.compareToIgnoreCase(o.departmentName);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
