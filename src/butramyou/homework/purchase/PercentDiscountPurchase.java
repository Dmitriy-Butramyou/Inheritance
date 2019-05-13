package butramyou.homework.purchase;

import butramyou.homework.currency.Byn;
import butramyou.homework.rounding.RoundMethod;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {

    private final int LIMIT = 5;
    private double percent;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(String name, Byn price, int number, double percent) {
        super(name, price, number);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.percent = sc.nextDouble();
    }

    public Byn getCost() {
        Byn cost = super.getCost();
        if (LIMIT <= getNumber()) {
            cost.mul(percent, RoundMethod.FLOOR, 8);
        }
        return cost;
    }

    public String fieldsToString() {
        return super.fieldsToString() + ";" + percent;
    }

}
