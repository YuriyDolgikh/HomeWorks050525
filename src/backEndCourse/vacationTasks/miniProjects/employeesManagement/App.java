package backEndCourse.vacationTasks.miniProjects.employeesManagement;

/*
    Вариант 3. Система управления персоналом компании

    Цель: Создать комплексную систему для управления сотрудниками и отделами компании.

    Задачи:
        - Создать классы Employee (с информацией об имени, фамилии, должности и отделе) и Department (с информацией
          о названии отдела и списке сотрудников).
        - Реализовать класс Company, который использует коллекцию для хранения отделов, где ключом является название
          отдела, а значением - объект Department.
        - В классе Company реализовать операции CRUD (добавление, поиск, удаление) для сотрудников и отделов,
          включая перевод сотрудников между отделами, обновление информации о сотрудниках и отделах, поиск сотрудников
          по различным критериям (отдел, должность, имя).
        - Добавить функционал для вывода отчетов, например, список всех сотрудников компании, сотрудники определенного
          отдела, количество сотрудников в компании.
 */

import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.CompanyController;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.DepartmentController;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.EmployeeController;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.CompanyRepository;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.DepartmentRepository;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.repository.EmployeeRepository;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.CompanyService;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.DepartmentService;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.service.EmployeeService;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.userInterface.AppInterface;

public class App {
    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        CompanyRepository companyRepository = new CompanyRepository(departmentRepository);

        DepartmentService departmentService = new DepartmentService(departmentRepository);
        EmployeeService employeeService = new EmployeeService(employeeRepository, departmentService);
        CompanyService companyService = new CompanyService(companyRepository, employeeService, departmentService);

        DepartmentController departmentController = new DepartmentController(departmentService);
        EmployeeController employeeController = new EmployeeController(employeeService);
        CompanyController companyController = new CompanyController(companyService);

        AppInterface appInterface = new AppInterface(employeeController, departmentController, companyController);
        appInterface.mainMenu();
    }
}
