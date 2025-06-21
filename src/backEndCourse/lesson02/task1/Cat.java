package backEndCourse.lesson02.task1;

public class Cat implements Animal{

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Cat";
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }

}
