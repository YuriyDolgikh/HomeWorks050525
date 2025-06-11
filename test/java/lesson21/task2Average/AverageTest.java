package lesson21.task2Average;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    double[] sourceArray = {45, 678, 234, 879, 45, 23, -3, 0, 34};
    double[] sourceEmptyArray = {};
    double[] sourceNull = null;
    Average average = new Average();

    @Test
    void testGetAverage() {
        double result = 215.0;
        assertEquals(result, average.getAverage(sourceArray));
        assertTrue(Double.isNaN(average.getAverage(sourceEmptyArray)));
        assertThrows(NullPointerException.class, () -> average.getAverage(sourceNull));
    }
}