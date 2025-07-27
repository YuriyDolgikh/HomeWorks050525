package backEndCourse.vacationTasks.miniProjects.employeesManagement.config;

public enum ResponseCode {
    MSG_OK("OK"),
    ERR_ID_NOT_FOUND("ID not found"),
    ERR_IS_BLANC("Some variable is blank"),
    ERR_IS_NULL("Some variable is NULL"),
    ERR_DB_IS_EMPTY("Database is empty"),
    ERR_NO_RECORDS_FOUND("No records found"),
    ERR_SOMETHING_WENT_WRONG("Something went wrong"),
    ERR_DEPARTMENT_NOT_FOUND("Department not found"),
    ERR_EMPLOYEE_NOT_FOUND("Employee not found"),
    ERR_DEPARTMENT_ALREADY_EXISTS("Department is already exists");

    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Status: " + message;
    }
}
