package lesson07.task01;

public class Employee {

    private String name;
    private int hoursWorked;
    private double hourlyRate;
    private double monthlySalary;

    public Employee(String name, int hoursWorked, double hourlyRate) {
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
        this.monthlySalary = hoursWorked * hourlyRate;
    }

    public void calcSalary() {
        monthlySalary = hoursWorked * hourlyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    @Override
    public String toString() {
        return "Employee " + name + ": worked out " + hoursWorked + " hours, rate " + hourlyRate + ", monthly salary " + monthlySalary;
    }
}
