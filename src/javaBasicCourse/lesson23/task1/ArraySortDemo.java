package javaBasicCourse.lesson23.task1;

public class ArraySortDemo {
    public static void main(String[] args) {
        ArrayService arrayService = new ArrayService();
        int[] arr = arrayService.createArrayFromUserInput();
        arr = arrayService.fillArrayFromUserInput(arr);
        arrayService.sort(arr);
        arrayService.printArray(arr);
    }
}
