package javaBasicCourse.lesson04.task02;

    /*
    Найдите в Интернете данные по температуре в вашем городе за прошедшую неделю.
    Вычислите среднюю температуру за неделю и выведете ее на печать.
     */

public class Temperature {
    public static void main(String[] args) {
        byte[] temperatures = {13, 12, 8, 10, 10, 12, 16};
        int sum = 0;
        for(byte temp : temperatures){
            sum += temp;
        }
        System.out.println("Average temperature: " + ((float)sum / temperatures.length));
    }
}
