package backEndCourse.vacationTasks.homeTask.collections.difficult.task10;

/*
    10 Создать класс Employee со свойствами name, department и salary, затем создать отображение TreeMap,
       где ключом является отдел, а значением - список сотрудников, работающих в этом отделе.
       Затем добавить несколько сотрудников в каждый отдел и вывести на консоль среднюю зарплату для каждого отдела.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DepartmentsApp {
    public static void main(String[] args) {
        Department hr = new Department("HR");
        Department finance = new Department("Finance");
        Department accounting = new Department("Accounting");

        Employee employee1 = new Employee("Williams", hr, 4000);
        Employee employee2 = new Employee("Smith", hr, 3000);
        Employee employee3 = new Employee("Johnson", hr, 2500);
        Employee employee4 = new Employee("Jones", finance, 2000);
        Employee employee5 = new Employee("Brown", finance, 3600);
        Employee employee6 = new Employee("Wilson", accounting, 1800);
        Employee employee7 = new Employee("Jameson", accounting, 3500);

        Map<Department, List<Employee>> departments = new TreeMap<>();
        addEmployeeToDepartment(departments, employee1);
        addEmployeeToDepartment(departments, employee2);
        addEmployeeToDepartment(departments, employee3);
        addEmployeeToDepartment(departments, employee4);
        addEmployeeToDepartment(departments, employee5);
        addEmployeeToDepartment(departments, employee6);
        addEmployeeToDepartment(departments, employee7);

        printAverageSalaryByDepartment(departments);
    }

    private static void addEmployeeToDepartment(Map<Department, List<Employee>> departments, Employee employee) {
        Department department = employee.getDepartment();
        if (departments.containsKey(department)) {
            departments.get(department).add(employee);
        } else {
            List<Employee> newList = new ArrayList<>();
            newList.add(employee);
            departments.put(department, newList);
        }
        department.getEmployees().add(employee);
    }

    private static void printAverageSalaryByDepartment(Map<Department, List<Employee>> departments) {
        for (Department department : departments.keySet()) {
            System.out.println("Department " + department.getDepartmentName() + " => Average salary = " + department.getAverageSalary());
        }
    }
}
