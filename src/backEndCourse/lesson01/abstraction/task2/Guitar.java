package backEndCourse.lesson01.abstraction.task2;

public class Guitar extends MusicalInstrument{

    public Guitar(String note) {
        super(note);
    }

    @Override
    public void playNote() {
        System.out.println("Guitar playing '" + note + "'");
    }
}
