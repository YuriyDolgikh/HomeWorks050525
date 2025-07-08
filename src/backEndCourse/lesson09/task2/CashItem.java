package backEndCourse.lesson09.task2;

public class CashItem {
    private String name;
    private int lifetime;

    public CashItem(String name, int lifetime) {
        this.name = name;
        this.lifetime = lifetime;
    }

    public String getName() {
        return name;
    }

    public int getLifetime() {
        return lifetime;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Lifetime: %d", name, lifetime);
    }
}
