package lesson15.task02;

public class ArrayService {
    public static boolean isArrayIncSequence(int[] srcArr){
        for (int i = 0; i < srcArr.length-1; i++) {
            if (srcArr[i] >= srcArr[i+1]){
                return false;
            }
        }
        return true;
    }
}
