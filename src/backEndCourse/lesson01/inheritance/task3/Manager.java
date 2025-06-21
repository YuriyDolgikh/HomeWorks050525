package backEndCourse.lesson01.inheritance.task3;

public class Manager extends Employee{
    Employee[] department;

    public Manager(String name, String email, String phone, Employee[] department) {
        super(name, email, phone);
        this.department = department;
    }
    public Employee[] getDepartment() {
        return department;
    }
    public void setDepartment(Employee[] department) {
        this.department = department;
    }
    void printDepartment(){
        System.out.println("Manager: Name: " + getName() + "\n" +
                           "         Email: " + getEmail() + "\n" +
                           "         Phone: " + getPhone() + "\n" +
                           "    Department:");
        for (Employee employee : department) {
            System.out.println("         Name: " + employee.getName() + "  Email: " + employee.getEmail() + "  Phone: " + employee.getPhone());
        }

    }
}
