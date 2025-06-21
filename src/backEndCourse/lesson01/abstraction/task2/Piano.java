package backEndCourse.lesson01.abstraction.task2;

public class Piano extends MusicalInstrument{

    public Piano(String note) {
        super(note);
    }

    @Override
    public void playNote() {
        System.out.println("Piano playing '" + note + "'");
    }
}
