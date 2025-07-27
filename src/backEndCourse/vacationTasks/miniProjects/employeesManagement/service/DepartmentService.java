package backEndCourse.vacationTasks.miniProjects.employeesManagement.service;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.DepartmentRepository;

import java.util.Optional;
import java.util.Set;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ResponseCode add(String departmentName) {
        if (departmentRepository.getByName(departmentName) != null) {
            return ResponseCode.ERR_DEPARTMENT_ALREADY_EXISTS;
        }
        return departmentRepository.add(new Department(departmentName)) ?
                ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    public Set<Department> getAll() {
        return departmentRepository.getAll();
    }

    public Optional<Department> getById(int id) {
        return Optional.ofNullable(departmentRepository.getById(id));
    }

    public Optional<Department> getByName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(departmentRepository.getByName(departmentName));
    }

    public Optional<Department> getByEmployeeId(int employeeId) {
        return Optional.ofNullable(departmentRepository.getByEmployeeId(employeeId));
    }

    public Optional<Set<Employee>> getEmployeesByDepartmentId(int departmentId) {
        return Optional.ofNullable(departmentRepository.getEmployeesByDepartmentId(departmentId));
    }

    public ResponseCode deleteById(int id){
        if (departmentRepository.getById(id) == null){
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND;
        }
        return departmentRepository.deleteById(id) ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }
}
