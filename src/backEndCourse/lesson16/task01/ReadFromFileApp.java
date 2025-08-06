package backEndCourse.lesson16.task01;

//   Чтение данных из текстового файла и вывод на экран
//   Описание: Написать программу на Java, которая будет читать данные из текстового файла,
//   используя классы FileReader и BufferedReader, и выводить их на экран.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileApp {
    public static void main(String[] args) throws IOException {
        String fileName = "src/backEndCourse/lesson16/task01/data.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}