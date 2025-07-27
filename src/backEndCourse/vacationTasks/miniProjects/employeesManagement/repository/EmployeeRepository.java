package backEndCourse.vacationTasks.miniProjects.employeesManagement.repository;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository {
    private final Set<Employee> employees;

    public EmployeeRepository() {
        this.employees = new HashSet<>();
    }

    public boolean add(Employee employee) {
        return employees.add(employee);
    }

    public Set<Employee> getAll() {
        return employees;
    }

    public Employee getById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public Set<Employee> getByFullName(String name, String surname) {
        Set<Employee> result = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                result.add(employee);
            }
        }
        return result;
    }

    public Set<Employee> getByPosition(String position) {
        Set<Employee> result = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getPosition().equals(position)) {
                result.add(employee);
            }
        }
        return result;
    }

    public Set<Employee> getByDepartmentName(String departmentName) {
        Set<Employee> result = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().getName().equalsIgnoreCase(departmentName)) {
                result.add(employee);
            }
        }
        return result;
    }

    public boolean updateDepartmentByEmployeeId(int employeeId, Department newDepartment) {
        Employee employeeToUpdate = getById(employeeId);
        if (employeeToUpdate == null) {
            return false;
        }
        Department oldDepartment = employeeToUpdate.getDepartment();
        employeeToUpdate.setDepartment(newDepartment);
        if (oldDepartment != null) {
            oldDepartment.getEmployees().remove(employeeToUpdate);
        }
        newDepartment.getEmployees().add(employeeToUpdate);
        return true;
    }

    public boolean updatePositionByEmployeeId(int employeeId, String newPosition) {
        Employee employeeToUpdate = getById(employeeId);
        if (employeeToUpdate == null) {
            return false;
        }
        employeeToUpdate.setPosition(newPosition);
        return true;
    }

    public boolean deleteById(int id) {
        Employee employeeToDelete = getById(id);
        if (employeeToDelete == null) {
            return false;
        }
        Department departmentToChange = employeeToDelete.getDepartment();
        if (departmentToChange != null) {
            departmentToChange.getEmployees().remove(employeeToDelete);
        }
        employees.remove(employeeToDelete);
        return true;
    }
}
