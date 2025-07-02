package javaBasicCourse.lesson05.task03;

public class Temperature {
    double celsius;
    double fahrenheit;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public void toFahrenheit() {
        fahrenheit = this.celsius * 1.8 + 32;
    }

    public void printTemperatureInFahrenheit() {
        System.out.println("Fahrenheit: " + fahrenheit);
    }

}
