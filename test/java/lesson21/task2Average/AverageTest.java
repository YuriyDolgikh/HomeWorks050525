package lesson21.task2Average;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    Average average = new Average();

    @Test
    void testGetAverageArrayIsExists() {
        double[] sourceArray = {45, 678, 234, 879, 45, 23, -3, 0, 34};
        double result = 215.0;
        assertEquals(result, average.getAverage(sourceArray));
    }

    @Test
    void testGetAverageArrayIsEmpty() {
        double[] sourceEmptyArray = {};
        double result = 215.0;
        assertTrue(Double.isNaN(average.getAverage(sourceEmptyArray)));
    }

    @Test
    void testGetAverageArrayIsNull() {
        double[] sourceNull = null;
        double result = 215.0;
        assertThrows(NullPointerException.class, () -> average.getAverage(sourceNull));
    }
}