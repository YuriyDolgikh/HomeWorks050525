package backEndCourse.vacationTasks.miniProjects.employeesManagement.controller;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.CompanyService;
import utils.UserInputStatic;

import java.util.Map;
import java.util.Optional;

public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String addDepartmentToCompany() {
        String departmentName = UserInputStatic.inputText("Please enter the department name: ");
        return companyService.addDepartmentToCompany(departmentName).getMessage();
    }

    public String getCompany() {
        StringBuilder sb = new StringBuilder("Company:").append(System.lineSeparator());
        if (companyService.getCompany().isEmpty()) {
            sb.append(ResponseCode.ERR_DB_IS_EMPTY.getMessage()).append(System.lineSeparator());
            return sb.toString();
        }
        for (Map.Entry<String, Department> entry : companyService.getCompany().entrySet()) {
            sb.append("-- Department: ").append(entry.getKey()).append(": ").append(System.lineSeparator());
            for (Employee employee : entry.getValue().getEmployees()) {
                sb.append("    Employee: id=").append(employee.getId()).append(", name= ").append(employee.getName()).
                        append(", surname= ").append(employee.getSurname()).
                        append(", position= ").append(employee.getPosition()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getMainCompanyInfo() {
        StringBuilder sb = new StringBuilder("Main company info:").append(System.lineSeparator());
        sb.append("Departments quantity: ").append(companyService.getNumberOfDepartments()).append(System.lineSeparator());
        sb.append("Employees quantity: ").append(companyService.getNumberOfEmployees()).append(System.lineSeparator());
        return sb.toString();
    }

    public String getDepartmentByName() {
        String departmentName = UserInputStatic.inputText("Please enter the department name: ");
        Optional<Department> department = companyService.getDepartmentByName(departmentName);
        if (department.isEmpty()) {
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND.getMessage();
        }
        return department.get().toString();
    }

    public String deleteDepartmentFromCompany() {
        String departmentName = UserInputStatic.inputText("Please enter the department name: ");
        return companyService.deleteDepartmentFromCompany(departmentName).getMessage();
    }
}
