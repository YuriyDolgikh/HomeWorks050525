package lesson04.task03;

    /*
    Какие числа могут получаться в качестве остатка от деления какого-либо целого числа на 2? На 3?
    Покажите это на конкретных примерах.
    */

import java.util.HashSet;
import java.util.Set;

public class RemainsOfDivision {
    public static void main(String[] args) {
        int numberOfAttempts = 100;
        Set<Byte> remainsTwo = new HashSet<>();
        Set<Byte> remainsThree = new HashSet<>();
        for (int number = 0; number <= numberOfAttempts; number++) {
            remainsTwo.add((byte) (number % 2));
            remainsThree.add((byte) (number % 3));
        }
        System.out.println("The remains of the division by 2: ");
        for (byte item : remainsTwo){
            System.out.println(item);
        }
        System.out.println("The remains of the division by 3: ");
        for (byte item : remainsThree){
            System.out.println(item);
        }
    }
}
