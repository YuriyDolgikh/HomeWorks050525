package backEndCourse.vacationTasks.homeTask.generics.task07;

public class Optional <T> {
    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        return value;
    }

    public T orElse(T defaultValue){
        return (value != null) ? value : defaultValue;
    }


}
