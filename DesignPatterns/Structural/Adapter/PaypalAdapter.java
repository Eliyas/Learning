package Structural.Adapter;

import Structural.Adapter.ExistingApplication.PaypalPayment;

public class PaypalAdapter implements Payment {
    private PaypalPayment paypalPayment;

    public PaypalAdapter(PaypalPayment paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    @Override
    public void pay(double amount) {
        this.paypalPayment.sendPayment(amount);
    }
}
