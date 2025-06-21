package backEndCourse.lesson01.abstraction.task2;

/*
    Определите абстрактный класс MusicalInstrument с абстрактным методом playNote,
    который должен имитировать звучание ноты.
    От этого класса создайте производные классы Guitar, Piano, и Violin,
    реализующие метод playNote для имитации звука соответствующего инструмента.
 */

abstract class MusicalInstrument {
    protected String note;

    public MusicalInstrument(String note) {
        this.note = note;
    }

    public abstract void playNote();
}
