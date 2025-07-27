package backEndCourse.vacationTasks.miniProjects.employeesManagement.entity;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.dto.EmployeeDTO;

import java.util.Objects;

public class Employee {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final String surname;
    private String position;
    private Department department;

    public Employee(String name, String surname, String position, Department department) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.department = department;
    }

    public static Employee of(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getName(), employeeDTO.getSurname(), null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        String departmentName = department == null ? "Not in department" : department.getName();
        String positionName = position == null ? "No position" : position;
        return "Employee: id=" + id + ", name= " + name + ", surname= " + surname + " , position= " + positionName + " , department= " + departmentName;
    }
}
