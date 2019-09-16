package lesson7;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {

    }

    public Order createOrder() {
        Order order = new Order(100, new Date(), false, null, "Dnepr", "Ukraine&quot", "Buy");
        return order;
    }

    public Order createOrderAndCallMethods() {
        Order order1 = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");

        order1.checkPrice();
        order1.isValidType();
        order1.confirmOrder();

        return order1;
    }
}

