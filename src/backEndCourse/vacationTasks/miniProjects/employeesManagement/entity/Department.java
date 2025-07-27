package backEndCourse.vacationTasks.miniProjects.employeesManagement.entity;

import java.util.*;

public class Department {
    private final int id;
    private final String name;
    private final Set<Employee> employees;
    private static int nextId = 1;

    public Department(String name) {
        this.id = nextId++;
        this.name = name;
        this.employees = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Department that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Department: id= " + id + ", name= " + name + ", quantity of employees: " + employees.size();
    }

}
