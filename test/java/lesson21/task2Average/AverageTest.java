package lesson21.task2Average;

import javaBasicCourse.lesson21.task2Average.Average;
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
        assertTrue(Double.isNaN(average.getAverage(sourceEmptyArray)));
    }

    @Test
    void testGetAverageArrayIsNull() {
        double[] sourceNull = null;
        assertThrows(NullPointerException.class, () -> average.getAverage(sourceNull));
    }
}