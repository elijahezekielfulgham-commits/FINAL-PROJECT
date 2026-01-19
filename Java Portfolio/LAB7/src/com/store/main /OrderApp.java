package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new OnlineOrder(155, 1500.00));
        orders.add(new OnlineOrder(188, 1800.00));
        orders.add(new OnlineOrder(190, 1900.00));

        orders.get(0).processOrder();
        ((OnlineOrder) orders.get(1)).pay();
        ((OnlineOrder) orders.get(2)).setStatus(OrderStatus.CANCELLED);

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());

            if (order.getStatus() == OrderStatus.CANCELLED) {
                System.out.println("A cancelled order was detected and has now been removed from the records.");
                iterator.remove();
            }
        }
    }
}
