package butramyou.homework.factory;

import butramyou.homework.purchase.PercentDiscountPurchase;
import butramyou.homework.purchase.PriceDiscountPurchase;
import butramyou.homework.purchase.Purchase;

import java.util.Scanner;

public class PurchasesFactory {

    private static enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            PriceDiscountPurchase getPurchase(Scanner sc) {
                return new PriceDiscountPurchase(sc);
            }
        },
        PERCENT_DISCOUNT_PURCHASE {
            PercentDiscountPurchase getPurchase(Scanner sc) {
                return new PercentDiscountPurchase(sc);
            }
        };

        abstract Purchase getPurchase(Scanner sc);
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        return PurchaseKind.valueOf(sc.next()).getPurchase(sc);
    }
}