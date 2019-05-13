package butramyou.homework.runner;

import butramyou.homework.factory.PurchasesFactory;
import butramyou.homework.purchase.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

    public void run() {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            final int PURCHASES_NUMBER = 6;
            boolean areEqual = true;
            int f = 0;
            Purchase purchases[] = new Purchase[PURCHASES_NUMBER];

            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (purchases[f].getCost().compareTo(purchases[i].getCost()) < 0) {
                    f = i;
                }
                if (areEqual) {
                    areEqual = purchases[i].equals(purchases[0]);
                }
            }

            System.out.println("\n" + purchases[f] + "\n");

            if (areEqual) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Purchases are not equal");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file is not found " + e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
