package butramyou.homework.purchase;

import butramyou.homework.currency.Byn;

import java.util.Scanner;

public class Purchase {

    private String name;
    private Byn price;
    private int number;

    public Purchase() {
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner sc) {
        this(sc.next(), new Byn(sc.nextInt()), sc.nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return this.price;

    }

    public void setPrice(Byn price) {
        this.price = price;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        Byn price = new Byn(this.price);
        price.mul(this.number);
        return price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Purchase) {
            Purchase purchase = (Purchase) obj;
            return name.equals(purchase.name) & price.equals(purchase.price);
        }
        return false;
    }

    public String fieldsToString() {
        return name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }
}
