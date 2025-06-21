package backEndCourse.lesson02.task1;

public class Dog implements Animal{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + '}';
    }
}
