package backEndCourse.lesson01.incapsulation.task3;

public class SystemConfigurationDemo {
    public static void main(String[] args) {
        SystemConfiguration cfg = new SystemConfiguration("INFO",  "C:\\TEMP\\LOG");
        cfg.printConfiguration();
        System.out.println();
        System.out.println("Change log level to TEST");
        System.out.println("Log level " + (cfg.setLogLevel("TEST") ? "changed" : "not changed"));
        System.out.println("Change log level to DEBUG");
        System.out.println("Log level " + (cfg.setLogLevel("DEBUG") ? "changed" : "not changed"));
        System.out.println("Change log file to C:\\System\\info");
        System.out.println("Log file " + (cfg.setLogPath("C:\\System\\info") ? "changed" : "not changed"));
        System.out.println("Change log file to C:\\");
        System.out.println("Log file " + (cfg.setLogPath("C:\\") ? "changed" : "not changed"));
        System.out.println("Change log file to C:\\System\\log\\site");
        System.out.println("Log file " + (cfg.setLogPath("C:\\System\\log\\site") ? "changed" : "not changed"));
        System.out.println();
        cfg.printConfiguration();
    }
}
