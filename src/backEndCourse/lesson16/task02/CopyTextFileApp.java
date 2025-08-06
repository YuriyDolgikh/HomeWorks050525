package backEndCourse.lesson16.task02;

import utils.UserInputStatic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextFileApp {
    public static void main(String[] args) throws IOException {
        String sourceFileName = UserInputStatic.inputText("Enter the source text file name:");
        String targetFileName = UserInputStatic.inputText("Enter the target text file name:");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileName));
        FileWriter fileWriter = new FileWriter(targetFileName);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileWriter.write(line);
        }
        bufferedReader.close();
        fileWriter.close();
        System.out.println("The file was copied successfully");
    }
}