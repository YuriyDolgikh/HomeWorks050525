package backEndCourse.vacationTasks.miniProjects.employeesManagement.repository;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Company;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;

import java.util.Map;

public class CompanyRepository {
    private final Map<String, Department> company;
    private final DepartmentRepository departmentRepository;

    public CompanyRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.company = new Company().getCompany();
    }

    public boolean addDepartment(Department department) {
        return company.put(department.getName(), department) == null;
    }

    public Map<String, Department> getCompany() {
        return company;
    }

    public Department getDepartmentByName(String departmentName) {
        return company.get(departmentName);
    }

    public boolean deleteDepartmentFromCompany(String departmentName) {
        Department departmentToDelete = getDepartmentByName(departmentName);
        if (departmentToDelete == null) {
            return false;
        }
        company.remove(departmentName);
        departmentRepository.deleteById(departmentToDelete.getId());
        return true;
    }
}
