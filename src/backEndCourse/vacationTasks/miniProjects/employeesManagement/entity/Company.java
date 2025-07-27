package backEndCourse.vacationTasks.miniProjects.employeesManagement.entity;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private final Map<String, Department> company;

    public Company() {
        this.company = new HashMap<>();
    }

    public Map<String, Department> getCompany() {
        return company;
    }
}
