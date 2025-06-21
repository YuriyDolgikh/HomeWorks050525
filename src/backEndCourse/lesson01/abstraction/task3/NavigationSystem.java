package backEndCourse.lesson01.abstraction.task3;

/*
    Создайте абстрактный класс NavigationSystem с абстрактными методами
    для старта навигации startNavigation и завершения навигации stopNavigation.
    Этот класс может также включать общие поля и методы, применимые ко всем системам навигации.
    Наследуйте от него классы CarNavigationSystem и MarineNavigationSystem,
    реализуя абстрактные методы для конкретных типов навигации.
 */

abstract class NavigationSystem {
    protected String brand;
    protected String model;
    protected boolean isNavigationStarted;

    public NavigationSystem(String brand, String model, boolean isNavigationStarted) {
        this.brand = brand;
        this.model = model;
        this.isNavigationStarted = isNavigationStarted;
    }

    public abstract void startNavigation();
    public abstract void stopNavigation();

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public boolean isNavigationStarted() {
        return isNavigationStarted;
    }

    public void setNavigationStarted(boolean navigationStarted) {
        isNavigationStarted = navigationStarted;
    }

    public void printNavigationSystemInfo() {
        System.out.println("Brand: " + brand + "    Model: " + model);
        System.out.println(this.getClass().getSimpleName() + (isNavigationStarted() ? " is started" : " is stopped"));
    }
}
