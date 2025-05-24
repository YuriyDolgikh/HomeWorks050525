package lesson09.car;

public class CarApp {
    public static void main(String[] args) {
        CarService carService = new CarService();

        Producer producer1 = carService.createProducer();
        Producer producer2 = carService.createProducer();

        Car car1 = carService.createCar(producer1);
        Car car2 = carService.createCar(producer2);
        Car car3 = carService.createCar(producer1);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

    }
}
