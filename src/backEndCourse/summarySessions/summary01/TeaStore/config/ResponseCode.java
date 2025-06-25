package backEndCourse.summarySessions.summary01.TeaStore.config;

public enum ResponseCode {
    MSG_OK("OK"),
    ERR_ID_ALREADY_EXIST("ID is already exist"),
    ERR_NAME_ALREADY_EXIST("Name is already exist"),
    ERR_ID_NOT_FOUND("ID not found"),
    ERR_IS_BLANC("Some variable is blank"),
    ERR_IS_NULL("Some variable is NULL"),
    ERR_OBJECT_ALREADY_EXIST("Object is already exist"),
    ERR_NAME_NOT_FOUND("Name not found"),
    ERR_DB_IS_EMPTY("Database is empty"),
    ERR_NO_RECORDS_FOUND("No records found"),
    ERR_NO_FREE_SPACE("There is no free spase in database"),
    ERR_SOMETHING_WENT_WRONG("Something went wrong"),
    ERR_LINK_TO_OBJECT_EXIST_IN_ANOTHER_DB("The link to the object exists in another database. Impossible to delete");

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
