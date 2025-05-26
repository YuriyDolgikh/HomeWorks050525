package lesson13.task01Cars;

import utils.UserInputStatic;

public class CarApp {
    public static void main(String[] args) {
        int numberOfCars = UserInputStatic.inputInt("Number of cars: ");
        UserInputStatic.skipLineSeparator();
        StringBuilder textForCatalog = new StringBuilder();
        for (int i = 0; i < numberOfCars; i++) {
            String producer = UserInputStatic.inputText("Input the brand: ");
            String model = UserInputStatic.inputText("Input the model: ");
            int power = UserInputStatic.inputInt("Input the power of the car: ");
            UserInputStatic.skipLineSeparator();
            System.out.println("_______________________________________________");
            Car car = new Car(producer, model, power);
            textForCatalog.append(car).append(System.lineSeparator());
        }
        System.out.println(textForCatalog);
        UserInputStatic.close();
    }
}
