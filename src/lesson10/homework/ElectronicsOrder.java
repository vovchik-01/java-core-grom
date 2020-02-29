package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        //  заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов.
        //  Минимальная цена заказа 100. Так же имя клиента который делает заказ может быть любым,
        //  а пол только женским
        String[] city = new String[]{"Киев", "Одесса", "Днепр", "Харьков"};
        for (String cit : city) {
            if (getShipFromCity().equals(cit) && getCustomerOwned().getCity().equals(cit)){
                if (getCustomerOwned().getGender().equals("Женский") && getBasePrice() >= 100){
                    setDateConfirmed(new Date());
                }
            }

        }


    }

    @Override
    public void calculatePrice() {

        double comission;
        if (getShipToCity().equals("Киев") || getShipToCity().equals("Одесса")) {
            comission = getBasePrice() * 0.10;
        } else
            comission = getBasePrice() * 0.15;

        if (getBasePrice() > 1000) {
            setTotalPrice((getBasePrice() + comission) * 0.95);
        } else
            setTotalPrice(getBasePrice() + comission);


    }
}

