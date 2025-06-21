package backEndCourse.lesson01.abstraction.task3;

public class NavigationSystemDemo {
    public static void main(String[] args) {
        NavigationSystem carNavSystem = new CarNavigationSystem("Garmin", "LGV1000", false);
        carNavSystem.printNavigationSystemInfo();
        carNavSystem.startNavigation();
        carNavSystem.printNavigationSystemInfo();
        carNavSystem.stopNavigation();
        System.out.println("-------------------------------------------");
        NavigationSystem shipNavSystem = new MarineNavigationSystem("Lowrance", "LCX-112C", false);
        shipNavSystem.printNavigationSystemInfo();
        shipNavSystem.startNavigation();
        shipNavSystem.printNavigationSystemInfo();
        shipNavSystem.stopNavigation();
    }
}
