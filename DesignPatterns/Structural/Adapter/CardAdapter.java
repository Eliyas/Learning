package Structural.Adapter;

import Structural.Adapter.ExistingApplication.CardPayment;

public class CardAdapter implements Payment {

    private CardPayment cardPayment;

    public CardAdapter(CardPayment cardPayment) {
        this.cardPayment = cardPayment;
    }

    @Override
    public void pay(double amount) {
        cardPayment.makePayment(amount);
    }
}
