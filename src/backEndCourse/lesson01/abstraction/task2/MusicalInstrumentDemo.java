package backEndCourse.lesson01.abstraction.task2;

public class MusicalInstrumentDemo {
    public static void main(String[] args) {
        MusicalInstrument guitar = new Guitar("A");
        MusicalInstrument piano = new Piano("C");
        MusicalInstrument violin = new Violin("E");
        guitar.playNote();
        piano.playNote();
        violin.playNote();
    }
}
