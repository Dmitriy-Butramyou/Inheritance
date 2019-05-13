package butramyou.homework.purchase;

import butramyou.homework.currency.Byn;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {

    private Byn priceDiscount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(String name, Byn price, int number, Byn priceDiscount) {
        super(name, price, number);
        this.priceDiscount = priceDiscount;
    }

    public PriceDiscountPurchase(Scanner sc) {
        super(sc);
        this.priceDiscount = new Byn(sc.nextInt());
    }


    public Byn getCost() {
        Byn price = new Byn(getPrice());
        return price.sub(priceDiscount).mul(getNumber());
    }

    public String fieldsToString() {
        return super.fieldsToString() + ";" + priceDiscount;
    }

}

