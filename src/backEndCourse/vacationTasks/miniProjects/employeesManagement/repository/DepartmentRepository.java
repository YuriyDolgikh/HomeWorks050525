package backEndCourse.vacationTasks.miniProjects.employeesManagement.repository;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository {
    private final Set<Department> departments;

    public DepartmentRepository() {
        this.departments = new HashSet<>();
    }

    public boolean add(Department department) {
        return departments.add(department);
    }

    public Set<Department> getAll() {
        return departments;
    }

    public Department getById(int id) {
        for (Department department : departments) {
            if (department.getId() == id) {
                return department;
            }
        }
        return null;
    }

    public Department getByName(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    public Department getByEmployeeId(int employeeId) {
        for (Department department : departments) {
            Set<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                if (employee.getId() == employeeId) {
                    return department;
                }
            }
        }
        return null;
    }

    public Set<Employee> getEmployeesByDepartmentId(int DepartmentId) {
        Department department = getById(DepartmentId);
        if (department == null) {
            return null;
        }
        return department.getEmployees();
    }

    public boolean deleteById(int id) {
        Department departmentForDelete = getById(id);
        if (departmentForDelete == null) {
            return false;
        }
        Set<Employee> employees = departmentForDelete.getEmployees();
        departments.remove(departmentForDelete);
        for (Employee employee : employees) {
            employee.setDepartment(null);
        }
        return true;
    }
}
