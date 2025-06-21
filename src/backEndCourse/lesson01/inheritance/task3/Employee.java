package backEndCourse.lesson01.inheritance.task3;

/*
    Создайте класс Employee, содержащий общую информацию о сотрудниках компании.
    От него наследуйте классы Manager и Developer.
    В классе Manager добавьте список подчиненных - массив сотрудников (экземпляры класса Employee),
    а в классе Developer - список проектов, над которыми работает разработчик, — массив String[].
 */

public class Employee {
    String name;
    String email;
    String phone;

    public Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
