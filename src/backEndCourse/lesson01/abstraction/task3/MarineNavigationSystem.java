package backEndCourse.lesson01.abstraction.task3;

public class MarineNavigationSystem extends NavigationSystem{

    public MarineNavigationSystem(String brand, String model, boolean isNavigationStarted) {
        super(brand, model, isNavigationStarted);
    }

    @Override
    public void startNavigation() {
        System.out.println("The ship's engines are running");
        setNavigationStarted(true);
    }

    @Override
    public void stopNavigation() {
        System.out.println("The ship's engines are stopped");
        setNavigationStarted(false);
    }


}
