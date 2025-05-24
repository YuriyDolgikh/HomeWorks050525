package lesson09.car;

import utils.UserInput;

import java.util.Scanner;

public class CarService {
    Scanner sc = new Scanner(System.in);

    public Producer createProducer() {
        UserInput userInput = new UserInput();
        String brand = userInput.inputText("Brand:");
        String country = userInput.inputText("Country:");
        return new Producer(brand, country);
    }

    public Car createCar(Producer producer) {
        UserInput userInput = new UserInput();
        String model = userInput.inputText("Model:");
        String color = userInput.inputText("Color:");
        return new Car(model, producer, color);
    }

}
