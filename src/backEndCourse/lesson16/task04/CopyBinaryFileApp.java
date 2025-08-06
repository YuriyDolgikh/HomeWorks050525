package backEndCourse.lesson16.task04;

import utils.UserInputStatic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBinaryFileApp {
    public static void main(String[] args) throws IOException {
        String sourceFileName = UserInputStatic.inputText("Enter the source file name:");
        String targetFileName = UserInputStatic.inputText("Enter the target file name:");
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFileName);
        int data;
        while ((data = fileInputStream.read()) != -1) {
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("The file was copied successfully");
    }
}