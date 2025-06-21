package backEndCourse.lesson01.inheritance.task3;

public class Developer extends Employee {
    String[] projects;

    public Developer(String name, String email, String phone, String[] projects) {
        super(name, email, phone);
        this.projects = projects;
    }
    public String[] getProjects() {
        return projects;
    }
    public void setProjects(String[] projects) {
        this.projects = projects;
    }

    void printDeveloper(){
        System.out.println("Developer: Name: " + getName() + "\n" +
                           "           Email: " + getEmail() + "\n" +
                           "           Phone: " + getPhone() + "\n" +
                           "      Projects:");
        for (String project : projects) {
            System.out.println("           " + project);
        }

    }
}
