package com.store.order;

import com.store.payment.Payable;

public class OnlineOrder extends Order implements Payable {

    public OnlineOrder(int orderId, double amount) {
        super(orderId, amount);
    }
    @Override
    public void processOrder() {
        System.out.println("The system has started processing the online order with ID " + getOrderId() + ".");
    }
    @Override
    public void pay() {
        setStatus(OrderStatus.PAID);
        System.out.println("The payment for order ID " + getOrderId() + " has been successfully confirmed.");
    }
}
