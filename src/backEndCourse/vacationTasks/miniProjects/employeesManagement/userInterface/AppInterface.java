package backEndCourse.vacationTasks.miniProjects.employeesManagement.userInterface;

import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.CompanyController;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.DepartmentController;
import backEndCourse.vacationTasks.miniProjects.employeesManagement.controller.EmployeeController;
import utils.UserInputStatic;

public class AppInterface {
    private final EmployeeController employeeController;
    private final DepartmentController departmentController;
    private final CompanyController companyController;

    public AppInterface(EmployeeController employeeController, DepartmentController departmentController, CompanyController companyController) {
        this.employeeController = employeeController;
        this.departmentController = departmentController;
        this.companyController = companyController;
    }

    public void mainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showMainMenu();
            int choice = UserInputStatic.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> employeeMenu();
                case 2 -> departmentMenu();
                case 3 -> companyMenu();
                case 0 -> {
                    isRunning = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    public void employeeMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showEmployeeMenu();
            int choice = UserInputStatic.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> System.out.println(employeeController.addEmployee());
                case 2 -> System.out.println(employeeController.getAllEmployees());
                case 3 -> System.out.println(employeeController.getEmployeeById());
                case 4 -> System.out.println(employeeController.getEmployeesByFullName());
                case 5 -> System.out.println(employeeController.getEmployeesByPosition());
                case 6 -> System.out.println(employeeController.getEmployeesByDepartmentName());
                case 7 -> System.out.println(employeeController.updateEmployeeDepartnentByEmployeeId());
                case 8 -> System.out.println(employeeController.updateEmployeePositionByEmployeeId());
                case 9 -> System.out.println(employeeController.deleteEmployeeById());
                case 0 -> isRunning = false;
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    public void departmentMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showDepartmentMenu();
            int choice = UserInputStatic.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> System.out.println(departmentController.getAllDepartments());
                case 2 -> System.out.println(departmentController.getDepartmentById());
                case 3 -> System.out.println(departmentController.getDepartmentByName());
                case 4 -> System.out.println(departmentController.getDepartmentByEmployeeId());
                case 5 -> System.out.println(departmentController.getEmployeesByDepartmentId());
                case 0 -> isRunning = false;
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    public void companyMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showCompanyMenu();
            int choice = UserInputStatic.inputInt("Enter your choice: ");
            switch (choice) {
                case 1 -> System.out.println(companyController.addDepartmentToCompany());
                case 2 -> System.out.println(companyController.getCompany());
                case 3 -> System.out.println(companyController.getMainCompanyInfo());
                case 4 -> System.out.println(companyController.getDepartmentByName());
                case 5 -> System.out.println(companyController.deleteDepartmentFromCompany());
                case 0 -> isRunning = false;
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("Company Management System");
        System.out.println("Main menu:");
        System.out.println("1. Employee management");
        System.out.println("2. Department management");
        System.out.println("3. Company management");
        System.out.println("0. Exit");
    }

    private void showEmployeeMenu() {
        System.out.println("Employee menu:");
        System.out.println("1. Add employee");
        System.out.println("2. Show all employees");
        System.out.println("3. Show employee by id");
        System.out.println("4. Show employees by full name");
        System.out.println("5. Show employees by position");
        System.out.println("6. Show employees by department");
        System.out.println("7. Assign employee to department");
        System.out.println("8. Assign employee to position");
        System.out.println("9. Delete employee");
        System.out.println("0. Back to main menu");
    }

    private void showDepartmentMenu() {
        System.out.println("Department menu:");
        System.out.println("1. Show all departments");
        System.out.println("2. Show department by id");
        System.out.println("3. Show departments by name");
        System.out.println("4. Show department by employee");
        System.out.println("5. Show employees by department");
        System.out.println("0. Back to main menu");
    }

    public void showCompanyMenu() {
        System.out.println("Company menu:");
        System.out.println("1. Add department to company");
        System.out.println("2. Show company");
        System.out.println("3. Show main company info");
        System.out.println("4. Show department by name");
        System.out.println("5. Delete department from company");
        System.out.println("0. Back to main menu");
    }
}
