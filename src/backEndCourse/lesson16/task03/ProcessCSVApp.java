package backEndCourse.lesson16.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessCSVApp {
    public static void main(String[] args) throws IOException {
        String fileName = "src/backEndCourse/lesson16/task03/dataFile.csv";
        List<String[]> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length > 2) {
                lines.add(line.split(","));
            }
        }
        bufferedReader.close();
        System.out.println("The file was read successfully");
        System.out.println("The quantity of correct lines = " + lines.size());
        for (String[] arrLine : lines) {
            System.out.println(Arrays.toString(arrLine));
            System.out.println(lineProcessing(arrLine));
        }
    }

    public static String lineProcessing(String[] line) {
        if (line[0].equalsIgnoreCase("Integer")){
            List<Integer> numbers = new ArrayList<>();
            for (int i = 2; i < line.length; i++) {
                numbers.add(Integer.parseInt(line[i]));
            }
            if (line[1].equalsIgnoreCase("sum")){
                return "Summa = " + numbers.stream().mapToInt(Integer::intValue).sum();
            } else if (line[1].equalsIgnoreCase("mult")){
                return "Multiplication = " + numbers.stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
            }
        }
        if (line[0].equalsIgnoreCase("Double")){
            List<Double> numbers = new ArrayList<>();
            for (int i = 2; i < line.length; i++) {
                numbers.add(Double.parseDouble(line[i]));
            }
            if (line[1].equalsIgnoreCase("sum")){
                return "Summa = " + numbers.stream().mapToDouble(Double::doubleValue).sum();
            } else if (line[1].equalsIgnoreCase("avg")){
                return "Average = " + numbers.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            }else if (line[1].equalsIgnoreCase("max")){
                return "Max number = " + numbers.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
            }else if (line[1].equalsIgnoreCase("min")){
                return "Mim number = " + numbers.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
            }
        }
        if (line[0].equalsIgnoreCase("String")){
            List<String> strings = new ArrayList<>();
            for (int i = 2; i < line.length; i++) {
                strings.add(line[i]);
            }
            if (line[1].equalsIgnoreCase("count")){
                return "Number of elements = " + strings.size();
            }else if (line[1].equalsIgnoreCase("print")){
                return "All elements as string = " + String.join(", ", strings);
            }
        }
        return "Wrong file format";
    }
}
