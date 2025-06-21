package backEndCourse.lesson01.abstraction.task3;

public class CarNavigationSystem extends NavigationSystem{

    public CarNavigationSystem(String brand, String model, boolean isNavigationStarted) {
        super(brand, model, isNavigationStarted);
    }

    @Override
    public void startNavigation() {
        System.out.println("The car's engine is started");
        setNavigationStarted(true);
    }

    @Override
    public void stopNavigation() {
        setNavigationStarted(false);
        System.out.println("The car's engine is stopped");
    }


}
