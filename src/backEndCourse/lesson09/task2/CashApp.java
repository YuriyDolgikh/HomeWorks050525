package backEndCourse.lesson09.task2;

import java.util.LinkedList;
import java.util.List;

public class CashApp {
    public static void main(String[] args) {

        List<CashItem> cash = new LinkedList<>();
        List<CashItem> trash = new LinkedList<>();

        CashService.addItemToCash(cash, "Item1", 5);
        CashService.addItemToCash(cash, "Item2", 10);
        CashService.addItemToCash(cash, "Item3", 2);
        CashService.addItemToCash(cash, "Item4", 4);
        CashService.addItemToCash(cash, "Item5", 8);
        CashService.addItemToCash(cash, "Item6", 7);
        CashService.addItemToCash(cash, "Item7", 4);

        CashService.removeCashItemsByLifetimeToTrash(cash, trash);

        CashService.printList(trash, "Items in the trash:");
    }
}
