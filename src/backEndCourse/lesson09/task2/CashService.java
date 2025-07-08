package backEndCourse.lesson09.task2;

import java.util.Iterator;
import java.util.List;

public class CashService {

    public static void removeCashItemsByLifetimeToTrash(List<CashItem> cash, List<CashItem> trash) {
        printList(cash, "Cash items before removing");
        Iterator<CashItem> iterator = cash.iterator();
        while (iterator.hasNext()) {
            CashItem item = iterator.next();
            if (item.getLifetime() < CashCfg.LIFETIME_CRITERIA) {
                iterator.remove();
                trash.add(item);
            }
        }
        printList(cash, "Cash items after removing");
    }

    public static void addItemToCash(List<CashItem> cash, String itemName, int lifetime) {
        if (itemName == null || itemName.isBlank() || lifetime < 0 || lifetime > 10) {
            System.out.println("Incorrect input data. Item will not be added to the cash.");
            return;
        }
        if (cash.size() == CashCfg.CASH_SIZE) {
            System.out.println("The cash is full. Item [" + itemName + "] will not be added to the cash.");
            return;
        }
        CashItem item = new CashItem(itemName, lifetime);
        cash.add(item);
    }

    public static void printList(List<CashItem> list, String message) {
        System.out.println(message);
        for (CashItem item : list) {
            System.out.println("Name: " + item.getName() + ", Lifetime: " + item.getLifetime());
        }
    }
}
