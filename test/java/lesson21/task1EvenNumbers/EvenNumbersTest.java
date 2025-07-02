package lesson21.task1EvenNumbers;

import javaBasicCourse.lesson21.task1EvenNumbers.EvenNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EvenNumbersTest {

    EvenNumbers evenNumbers = new EvenNumbers();

    @Test
    void testGetEvenNumbersCommonCase() {
        int[] numbersCommonCase = {1, 22, -32, 0, 52, 161, -77, 58, 99, -201};
        int[] resultArrayCommonCase = {22, -32, 0, 52, 58};
        assertArrayEquals(resultArrayCommonCase, evenNumbers.getEvenNumbers(numbersCommonCase));
    }

    @Test
    void testGetEvenNumbersAllEven() {
        int[] numbersAllEven = {4, 66, 34, -346, -98, 0};
        int[] resultArrayAllEven = {4, 66, 34, -346, -98, 0};
        assertArrayEquals(resultArrayAllEven, evenNumbers.getEvenNumbers(numbersAllEven));
    }

    @Test
    void testGetEvenNumbersAllOdd() {
        int[] numbersAllOdd = {5, 67, 213, 49, -333};
        int[] resultArrayAllOdd = {};
        assertArrayEquals(resultArrayAllOdd, evenNumbers.getEvenNumbers(numbersAllOdd));
    }

    @Test
    void testGetEvenNumbersArrayIsNull() {
        assertNull(evenNumbers.getEvenNumbers(null));
    }

}