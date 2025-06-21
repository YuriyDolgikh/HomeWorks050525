package backEndCourse.lesson01.incapsulation.task1;

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0);
        System.out.println("Initial balance = " + bankAccount.getBalance());
        System.out.println("Deposit 100");
        bankAccount.deposit(100);
        bankAccount.printBalance();
        System.out.println("Try to withdraw 50");
        bankAccount.printWithdrawalResult(bankAccount.withdraw(50));
        bankAccount.printBalance();
        System.out.println("Try to withdraw 70");
        bankAccount.printWithdrawalResult(bankAccount.withdraw(70));
        bankAccount.printBalance();
    }
}
