package backEndCourse.lesson01.inheritance.task3;

public class FirmaDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "John@firma.com", "123-45-6789");
        Employee employee2 = new Employee("Max", "Max@firma.com", "234-15-9734");
        Employee employee3 = new Employee("Jane", "Jane@firma.com", "456-12-");
        Employee employee4 = new Employee("Bill", "Bill@firma.com", "354-76-1112");
        Employee employee5 = new Employee("Katy", "Katy@firma.com", "123-45-3434");

        String project1 = "Project 1";
        String project2 = "Project 2";
        String project3 = "Project 3";

        Employee[] departments = {employee1, employee2, employee3, employee4, employee5};
        String[] projects = {project1, project2, project3};

        Manager manager = new Manager("Leon", "Leon@firma.com", "123-11-3333", departments);
        Developer developer = new Developer("Gates", "gates@firma.com", "111-22-3333", projects);

        manager.printDepartment();
        System.out.println();
        developer.printDeveloper();
    }
}
