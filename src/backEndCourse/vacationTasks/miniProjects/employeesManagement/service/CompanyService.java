package backEndCourse.vacationTasks.miniProjects.employeesManagement.service;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.CompanyRepository;

import java.util.Map;
import java.util.Optional;

public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public CompanyService(CompanyRepository companyRepository, EmployeeService employeeService, DepartmentService departmentService) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    public ResponseCode addDepartmentToCompany(String departmentName) {
        ResponseCode checkDepartment = departmentService.add(departmentName);
        if (!checkDepartment.equals(ResponseCode.MSG_OK)) {
            return checkDepartment;
        }
        Optional<Department> department = departmentService.getByName(departmentName);
        if (department.isEmpty()) {
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND;
        }
        return companyRepository.addDepartment(department.get()) ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    public Map<String, Department> getCompany() {
        return companyRepository.getCompany();
    }

    public Optional<Department> getDepartmentByName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return Optional.empty();
        }
        return Optional.ofNullable(companyRepository.getDepartmentByName(departmentName));
    }

    public ResponseCode deleteDepartmentFromCompany(String departmentName) {
        if (departmentName == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (departmentName.isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        if (!companyRepository.deleteDepartmentFromCompany(departmentName)) {
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND;
        }
        return ResponseCode.MSG_OK;
    }

    public int getNumberOfEmployees() {
        return employeeService.getAll().size();
    }

    public int getNumberOfDepartments() {
        return companyRepository.getCompany().size();
    }
}
