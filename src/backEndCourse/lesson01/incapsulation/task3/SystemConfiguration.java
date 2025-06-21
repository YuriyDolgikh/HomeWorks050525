package backEndCourse.lesson01.incapsulation.task3;

/*
    Разработайте класс SystemConfiguration, который хранит конфигурационные параметры системы
    (например, уровень логирования, путь к файлам логов). Доступ к изменению этих параметров
    должен быть строго контролируемым через методы, предотвращающие установку некорректных значений.
 */

public class SystemConfiguration {
    private String logLevel;
    private String logPath;

    public SystemConfiguration(String logLevel, String logPath) {
        this.logLevel = logLevel;
        this.logPath = logPath;
    }

    public String getLogLevel() {
        return logLevel;
    }
    public String getLogPath() {
        return logPath;
    }

    public boolean setLogLevel(String logLevel) {
        if(SystemVariables.checkLogLevel(logLevel)){
            this.logLevel = logLevel.toUpperCase();
            return true;
        }
        return false;
    }

    public boolean setLogPath(String logPath) {
        if(SystemVariables.checkLogPath(logPath)){
            this.logPath = logPath;
            return true;
        }
        return false;
    }

    public void printConfiguration(){
        System.out.println("Log level: " + logLevel + "\nLog path: " + logPath);
    }
}
