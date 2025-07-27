package backEndCourse.vacationTasks.miniProjects.employeesManagement.controller;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.DepartmentService;
import utils.UserInputStatic;

import java.util.Optional;
import java.util.Set;

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getAllDepartments() {
        StringBuilder sb = new StringBuilder("Departments list:").append(System.lineSeparator());
        if (departmentService.getAll().isEmpty()) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY.getMessage()).append(System.lineSeparator());
        } else {
            for (Department department : departmentService.getAll()) {
                sb.append(department.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getDepartmentById() {
        int id = UserInputStatic.inputInt("Please enter the department id: ");
        Optional<Department> department = departmentService.getById(id);
        if (department.isEmpty()) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return department.get().toString();
    }

    public String getDepartmentByName() {
        String departmentName = UserInputStatic.inputText("Please enter the department name: ");
        Optional<Department> department = departmentService.getByName(departmentName);
        if (department.isEmpty()) {
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND.getMessage();
        }
        return department.get().toString();
    }

    public String getDepartmentByEmployeeId() {
        int employeeId = UserInputStatic.inputInt("Please enter the employee id: ");
        Optional<Department> department = departmentService.getByEmployeeId(employeeId);
        if (department.isEmpty()) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return department.get().toString();
    }

    public String getEmployeesByDepartmentId() {
        int departmentId = UserInputStatic.inputInt("Please enter the department id: ");
        Optional<Set<Employee>> employees = departmentService.getEmployeesByDepartmentId(departmentId);
        if (employees.isEmpty()) {
            return ResponseCode.ERR_NO_RECORDS_FOUND.getMessage();
        }
        StringBuilder sb = new StringBuilder("Employees by department list:").append(System.lineSeparator());
        for (Employee employee : employees.get()) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
