package Structural.Adapter;

import Structural.Adapter.ExistingApplication.CardPayment;
import Structural.Adapter.ExistingApplication.PaypalPayment;

public class Client {
    public static void main(String[] args) {
        // Using Credit Card Payment
        CardPayment creditCard = new CardPayment();
        Payment creditCardAdapter = new CardAdapter(creditCard);
        creditCardAdapter.pay(100.0); // Output: Paid $100.0 using Credit Card.

        // Using PayPal Payment
        PaypalPayment payPal = new PaypalPayment();
        Payment payPalAdapter = new PaypalAdapter(payPal);
        payPalAdapter.pay(50.0); // Output: Paid $50.0 using PayPal.
    }
}
