package backEndCourse.lesson14.task09;

public class Order {
    private final int id;
    private final String date;
    private double summa;
    private boolean status;

    public Order(int id, String date, double summa, boolean status) {
        this.id = id;
        this.date = date;
        this.summa = summa;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getSumma() {
        return summa;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", summa=" + summa +
                ", status=" + status +
                '}';
    }
}
