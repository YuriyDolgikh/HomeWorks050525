package backEndCourse.lesson01.abstraction.task2;

public class Violin extends MusicalInstrument{

    public Violin(String note) {
        super(note);
    }

    @Override
    public void playNote() {
        System.out.println("Violin playing '" + note + "'");
    }
}
