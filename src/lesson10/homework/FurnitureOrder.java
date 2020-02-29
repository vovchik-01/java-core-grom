package lesson10.homework;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }


    @Override
    public void validateOrder() {
        // Заказ возможен с городов: Киев, Львов и в любой город. Минимальная цена заказа 500.
        // Так же имя клиента который делает заказ не может быть "Тест", а пол может быть любым
        if(getShipFromCity().equals("Киев") || getShipFromCity().equals("Львов")){
            if (getTotalPrice() >= 500 || !getCustomerOwned().getName().equals("Тест")){
                setDateConfirmed(new Date());
            }
        }



    }

    @Override
    public void calculatePrice() {
        double comission;
        comission = getBasePrice() < 5000? getBasePrice()*0.05 : getBasePrice()* 0.02;
        setTotalPrice(getBasePrice() + comission);

    }
}

