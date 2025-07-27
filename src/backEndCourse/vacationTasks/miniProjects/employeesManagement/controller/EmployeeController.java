package backEndCourse.vacationTasks.miniProjects.employeesManagement.controller;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.dto.EmployeeDTO;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.EmployeeService;
import utils.UserInputStatic;

import java.util.Optional;
import java.util.Set;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String addEmployee() {
        String name = UserInputStatic.inputText("Please enter the employee name: ");
        String surname = UserInputStatic.inputText("Please enter the employee surname: ");
        return employeeService.add(new EmployeeDTO(name, surname)).getMessage();
    }

    public String getAllEmployees() {
        StringBuilder sb = new StringBuilder("Employees list:").append(System.lineSeparator());
        if (employeeService.getAll().isEmpty()) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY.getMessage()).append(System.lineSeparator());
        } else {
            for (Employee employee : employeeService.getAll()) {
                sb.append(employee.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getEmployeeById() {
        int id = UserInputStatic.inputInt("Please enter the employee id: ");
        Optional<Employee> employee = employeeService.getById(id);
        if (employee.isEmpty()) {
            return ResponseCode.ERR_ID_NOT_FOUND.getMessage();
        }
        return employee.get().toString();
    }

    public String getEmployeesByFullName() {
        String name = UserInputStatic.inputText("Please enter the employee name: ");
        String surname = UserInputStatic.inputText("Please enter the employee surname: ");
        EmployeeDTO employeeDTO = new EmployeeDTO(name, surname);
        Optional<Set<Employee>> employees = employeeService.getByFullName(employeeDTO);
        if (employees.isEmpty()) {
            return ResponseCode.ERR_NO_RECORDS_FOUND.getMessage();
        }
        StringBuilder sb = new StringBuilder("Employees by full name list:").append(System.lineSeparator());
        for (Employee employee : employees.get()) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getEmployeesByPosition() {
        String position = UserInputStatic.inputText("Please enter the employee position: ");
        Optional<Set<Employee>> employees = employeeService.getByPosition(position);
        if (employees.isEmpty()) {
            return ResponseCode.ERR_NO_RECORDS_FOUND.getMessage();
        }
        StringBuilder sb = new StringBuilder("Employees by position list:").append(System.lineSeparator());
        for (Employee employee : employees.get()) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getEmployeesByDepartmentName() {
        String departmentName = UserInputStatic.inputText("Please enter the department name: ");
        Optional<Set<Employee>> employees = employeeService.getByDepartmentName(departmentName);
        if (employees.isEmpty()) {
            return ResponseCode.ERR_NO_RECORDS_FOUND.getMessage();
        }
        StringBuilder sb = new StringBuilder("Employees by department list:").append(System.lineSeparator());
        for (Employee employee : employees.get()) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String updateEmployeeDepartnentByEmployeeId() {
        int employeeId = UserInputStatic.inputInt("Please enter the employee id to update: ");
        int newDepartmentId = UserInputStatic.inputInt("Please enter the ID of new department: ");
        return employeeService.updateDepartmentByEmployeeId(employeeId, newDepartmentId).getMessage();
    }

    public String updateEmployeePositionByEmployeeId() {
        int employeeId = UserInputStatic.inputInt("Please enter the employee id to update: ");
        String newPosition = UserInputStatic.inputText("Please enter the new position: ");
        return employeeService.updatePositionByEmployeeId(employeeId, newPosition).getMessage();
    }

    public String deleteEmployeeById() {
        int employeeId = UserInputStatic.inputInt("Please enter the employee id to delete: ");
        return employeeService.deleteById(employeeId).getMessage();
    }
}
