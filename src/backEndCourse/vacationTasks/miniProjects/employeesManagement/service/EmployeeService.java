package backEndCourse.vacationTasks.miniProjects.employeesManagement.service;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.config.ResponseCode;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.dto.EmployeeDTO;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Department;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.entity.Employee;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.EmployeeRepository;

import java.util.Optional;
import java.util.Set;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }

    public ResponseCode add(EmployeeDTO employeeDTO) {
        ResponseCode checkDTO = checkDTO(employeeDTO);
        if (!checkDTO.equals(ResponseCode.MSG_OK)) {
            return checkDTO;
        }
        boolean result = employeeRepository.add(Employee.of(employeeDTO));
        return result ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    public Set<Employee> getAll() {
        return employeeRepository.getAll();
    }

    public Optional<Employee> getById(int id) {
        return Optional.ofNullable(employeeRepository.getById(id));
    }

    public Optional<Set<Employee>> getByFullName(EmployeeDTO employeeDTO) {
        ResponseCode checkDTO = checkDTO(employeeDTO);
        if (!checkDTO.equals(ResponseCode.MSG_OK)) {
            return Optional.empty();
        }
        return Optional.of(employeeRepository.getByFullName(employeeDTO.getName(), employeeDTO.getSurname()));
    }

    public Optional<Set<Employee>> getByPosition(String position) {
        if (position == null || position.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(employeeRepository.getByPosition(position));
    }

    public Optional<Set<Employee>> getByDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(employeeRepository.getByDepartmentName(departmentName));
    }

    public ResponseCode updateDepartmentByEmployeeId(int employeeId, int newDepartmentId) {
        Optional<Department> newDepartment = departmentService.getById(newDepartmentId);
        if (newDepartment.isEmpty()) {
            return ResponseCode.ERR_DEPARTMENT_NOT_FOUND;
        }
        if (employeeRepository.getById(employeeId) == null) {
            return ResponseCode.ERR_EMPLOYEE_NOT_FOUND;
        }
        boolean result = employeeRepository.updateDepartmentByEmployeeId(employeeId, newDepartment.get());
        return result ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    public ResponseCode updatePositionByEmployeeId(int employeeId, String newPosition) {
        if (employeeRepository.getById(employeeId) == null) {
            return ResponseCode.ERR_EMPLOYEE_NOT_FOUND;
        }
        boolean result = employeeRepository.updatePositionByEmployeeId(employeeId, newPosition);
        return result ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    public ResponseCode deleteById(int id) {
        if (employeeRepository.getById(id) == null) {
            return ResponseCode.ERR_EMPLOYEE_NOT_FOUND;
        }
        boolean result = employeeRepository.deleteById(id);
        return result ? ResponseCode.MSG_OK : ResponseCode.ERR_SOMETHING_WENT_WRONG;
    }

    private ResponseCode checkDTO(EmployeeDTO employeeDTO) {
        if (employeeDTO == null || employeeDTO.getName() == null || employeeDTO.getSurname() == null) {
            return ResponseCode.ERR_IS_NULL;
        }
        if (employeeDTO.getName().isBlank() || employeeDTO.getSurname().isBlank()) {
            return ResponseCode.ERR_IS_BLANC;
        }
        return ResponseCode.MSG_OK;
    }
}
