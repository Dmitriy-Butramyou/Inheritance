package butramyou.homework.currency;

import butramyou.homework.rounding.RoundMethod;

public class Byn implements Comparable<Byn> {

    private int amount;

    public Byn() {
    }

    public Byn(int value) {
        this.amount = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn) {
        this(byn.amount);
    }

    private int getRubs() {
        int getRubs = amount / 100;
        return getRubs;
    }

    private int getCoins() {
        int getCoins = amount % 10;
        return getCoins;
    }

    private Byn add(Byn byn) {
        amount += byn.amount;
        return this;
    }

    public Byn sub(Byn byn) {
        amount -= byn.amount;
        return this;
    }

    public Byn mul(int k) {
        amount *= k;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Byn) {
            Byn byn = (Byn) obj;
            return this.amount == byn.amount;
        }
        return false;
    }

    @Override
    public int compareTo(Byn byn) {
        return amount - byn.amount;
    }

    @Override
    public String toString() {
        return amount / 100 + "." + amount / 10 % 10 + amount % 10;
    }

    private int round(double roundedValue, RoundMethod roundMethod, int d) {
        int tenPow = (int) Math.pow(10, d);
        int result = (int) roundMethod.roundFunction((roundedValue / tenPow) * tenPow);
        return result;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        amount = round(amount * (1 - k / 100), roundMethod, d);
        return this;
    }

    public Byn round(RoundMethod roundMethod, int d) {
        amount = round(amount, roundMethod, d);
        return this;
    }
}
