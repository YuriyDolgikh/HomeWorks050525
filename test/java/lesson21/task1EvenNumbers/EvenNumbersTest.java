package lesson21.task1EvenNumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class EvenNumbersTest {

    int[] numbersCommonCase = {1, 22, -32, 0, 52, 161, -77, 58, 99, -201};
    int[] numbersAllEven = {4, 66, 34, -346, -98, 0};
    int[] numbersAllOdd = {5, 67, 213, 49, -333};
    EvenNumbers evenNumbers = new EvenNumbers();

    @Test
    void testGetEvenNumbers() {
        int[] resultArrayCommonCase = {22, -32, 0, 52, 58};
        int[] resultArrayAllEven = {4, 66, 34, -346, -98, 0};
        int[] resultArrayAllOdd = {};
        assertArrayEquals(resultArrayCommonCase, evenNumbers.getEvenNumbers(numbersCommonCase));
        assertArrayEquals(resultArrayAllEven, evenNumbers.getEvenNumbers(numbersAllEven));
        assertArrayEquals(resultArrayAllOdd, evenNumbers.getEvenNumbers(numbersAllOdd));
        assertNull(evenNumbers.getEvenNumbers(null));
    }
}