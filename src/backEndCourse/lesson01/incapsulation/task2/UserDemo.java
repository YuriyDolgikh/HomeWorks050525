package backEndCourse.lesson01.incapsulation.task2;

public class UserDemo {
    public static void main(String[] args) {
        User user = new User("admin", "Pass123", "uadmin@mail.com");
        user.printUser();

        user.changePassword("Pass", "P123!@#", "P123!@#");
        user.changePassword("Pass123", "P123!@#", "Pass123!@#");
        user.changePassword("Pass123", "P123", "P123");
        user.changePassword("Pass123", "P123!!!", "P123!!!");
        user.changeEmail("user@mail.net", "Pas123");
        user.changeEmail("user@mail.net", "P123!!!");
        user.printUser();
    }
}
