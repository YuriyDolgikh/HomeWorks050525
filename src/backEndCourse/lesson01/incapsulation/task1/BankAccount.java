package backEndCourse.lesson01.incapsulation.task1;

/*
    Создайте класс BankAccount, который инкапсулирует баланс счета.
    Баланс не должен быть доступен для прямого изменения извне,
    а изменяться только с помощью методов deposit (для внесения средств)
    и withdraw (для снятия средств).
 */

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }else {
            return false;
        }
    }

    public void printBalance() {
        System.out.println("Balance: " + balance);
    }

    public void printWithdrawalResult(boolean result) {
        System.out.println("Operation result: " + (result ? "Success" : "Fail. Not enough money for withdrawal"));
    }
}
