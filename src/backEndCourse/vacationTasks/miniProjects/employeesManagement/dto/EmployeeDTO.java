package backEndCourse.vacationTasks.miniProjects.employeesManagement.dto;

public class EmployeeDTO {
    private final String name;
    private final String surname;

    public EmployeeDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
