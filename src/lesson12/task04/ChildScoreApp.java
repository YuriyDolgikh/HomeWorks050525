package lesson12.task04;

public class ChildScoreApp {
    public static void main(String[] args) {
        int note = (int) (Math.random() * 12 + 1);
        System.out.println("Note: " + note);
        int maxTime = 60;
        int currentTime = 45;
        int restTime;
        switch (note) {
            case 10, 11, 12:
                System.out.println("Excellent!");
                System.out.println("You can watch TV " + maxTime + " minutes.");
                break;
            case 7, 8, 9:
                System.out.println("Good job!");
                restTime = currentTime + 45 >= maxTime ? maxTime : currentTime + 45;
                System.out.println("You can watch TV " + restTime + " minutes.");
                break;
            case 4, 5, 6:
                System.out.println("You have to try better!");
                restTime = currentTime + 15 >= maxTime ? maxTime : currentTime + 15;
                System.out.println("You can watch TV " + restTime + " minutes.");
                break;
            case 3:
                System.out.println("This is really bad!");
                restTime = currentTime - 30 <= 0 ? 0 : currentTime + 30;
                System.out.println("You can watch TV " + restTime + " minutes.");
                break;
            case 1, 2:
                System.out.println("Ow! This is terrible!");
                System.out.println("TV watching is forbidden!");
                break;
            default:
                System.out.println("Something went wrong... ");
        }
    }
}
