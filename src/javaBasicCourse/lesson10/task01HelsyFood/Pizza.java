package javaBasicCourse.lesson10.task01HelsyFood;

public class Pizza {
    private int diameter;
    private int caloriesProOneSm;
    private double caloriesTotal;

    public Pizza(int diameter, int caloriesProOneSm) {
        this.diameter = diameter;
        this.caloriesProOneSm = caloriesProOneSm;
        this.caloriesTotal = Math.PI * Math.pow(diameter / 2, 2) * caloriesProOneSm;
    }

    public double getCaloriesTotal() {
        return caloriesTotal;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "diameter=" + diameter +
                ", caloriesProOneSm=" + caloriesProOneSm +
                ", caloriesTotal=" + caloriesTotal +
                '}';
    }
}
