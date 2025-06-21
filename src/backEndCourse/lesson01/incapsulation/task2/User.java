package backEndCourse.lesson01.incapsulation.task2;

/*
    Создайте класс User, который инкапсулирует данные пользователя:
    логин, пароль и email. Обеспечьте безопасное изменение и доступ
    к этим полям через геттеры и сеттеры. Пароль должен изменяться,
    только если старый пароль введен верно и новый пароль соответствует
    определенным требованиям безопасности.
 */

public class User {
    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword) {
       if (!newPassword.equals(confirmNewPassword)) {
           System.out.println("Passwords don't match");
           return false;
       }
       if (newPassword.length() < 5 || newPassword.length() > 12){
           System.out.println("Password length must be between 5 and 12 symbols");
           return false;
       }
       if (!oldPassword.equals(password)) {
           System.out.println("Wrong old password");
           return false;
       }
       this.password = newPassword;
        System.out.println("Password changed");
       return true;
    }

    public boolean changeEmail(String email, String password) {
        if (!this.password.equals(password)) {
            System.out.println("Wrong password");
            return false;
        }
        this.email = email;
        System.out.println("Email changed");
        return true;
    }

    public void printUser() {
        System.out.println("User info\nLogin: " + login + "\nEmail: " + email);
    }
}
