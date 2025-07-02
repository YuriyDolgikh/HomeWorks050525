package workInClasses.lessonPro07.task2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee employee1 = new Employee(101, "John", 1000, "IT");
        Employee employee2 = new Employee(23, "Mary", 2000, "HR");
        Employee employee3 = new Employee(305, "Peter", 3000, "Marketing");
        Employee employee4 = new Employee(4, "Mike", 4000, "Sales");

        Comparator<Employee> employeeComparatorById = new EmployeeComparatorById();
        Comparator<Employee> employeeComparatorByDepartmentAndId = new EmployeeComparatorByDepartment().thenComparing(new EmployeeComparatorById());
        Comparator<Employee> employeeComparatorByDepartmentAndName = new EmployeeComparatorByDepartment().thenComparing(new EmployeeComparatorByName());
        Comparator<Employee> employeeComparatorBySalary = new EmployeeComparatorBySalary();

        Set<Employee> employeesById = new TreeSet<>(employeeComparatorById);
        employeesById.add(employee1);
        employeesById.add(employee2);
        employeesById.add(employee3);
        employeesById.add(employee4);

        System.out.println("Employees by ID:");
        for (Employee employee : employeesById) {
            System.out.println(employee);
        }
        System.out.println();

        Set<Employee> employeesByDepartmentAndId = new TreeSet<>(employeeComparatorByDepartmentAndId);
        employeesByDepartmentAndId.addAll(employeesById);

        System.out.println("Employees by department and ID:");
        for (Employee employee : employeesByDepartmentAndId) {
            System.out.println(employee);
        }
        System.out.println();

        Set<Employee> employeesByDepartmentAndName = new TreeSet<>(employeeComparatorByDepartmentAndName);
        employeesByDepartmentAndName.addAll(employeesById);


        System.out.println("Employees by department and name:");
        for (Employee employee : employeesByDepartmentAndName) {
            System.out.println(employee);
        }
        System.out.println();

        Set<Employee> employeesBySalary = new TreeSet<>(employeeComparatorBySalary);
        employeesBySalary.addAll(employeesById);


        System.out.println("Employees by salary:");
        for (Employee employee : employeesBySalary) {
            System.out.println(employee);
        }
    }
}
