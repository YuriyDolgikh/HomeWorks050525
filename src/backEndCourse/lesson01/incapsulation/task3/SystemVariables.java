package backEndCourse.lesson01.incapsulation.task3;

public class SystemVariables {
    private static String[] logLevels = {"INFO", "TRACE", "DEBUG", "ERROR", "WARN", "FATAL"};
    private static String[] pathPatterns = {"LOG", "EVENT"};

    public static String[] getLogLevels() {
        return logLevels;
    }

    public static boolean checkLogLevel(String level){
        for (String logLevel : logLevels) {
            if (logLevel.equalsIgnoreCase(level)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkLogPath(String path){
        boolean pathMarker = false;
        for (String logPathPart : pathPatterns) {
            if (path.toUpperCase().contains(logPathPart)){
                pathMarker = true;
                break;
            }
        }
        if (path != null && !path.contains(" ") && path.length() > 5 && pathMarker){
            return true;
        }else {
            return false;
        }
    }


}
