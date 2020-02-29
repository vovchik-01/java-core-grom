package lesson11.homework;


import java.util.Date;

public class Controller {
    private API[] apis;


    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        Room[] room = new Room[0];
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                room = new Room[api.findRooms(price, persons, city, hotel).length];
            }
        }
        return room;

    }

    public Room[] check(API api1, API api2) {
        Room[] rooms = api1.getAll();
        Room[] rooms1 = api2.getAll();
        int index = 0;
        for (Room room : rooms) {
            for (Room room1 : rooms1) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons()
                        && room.getHotelName().equals(room1.getHotelName()) && room.getCityName().equals(room1.getCityName())) {
                    index++;
                }
            }
        }
        Room[] room = new Room[index];
        int index1 = 0;
        for (Room resRoom : room) {
            for (Room roomAPI1 : rooms) {
                for (Room roomAPI2 : rooms1) {
                    if (roomAPI1.getCityName().equals(roomAPI2.getCityName()) && roomAPI1.getHotelName().equals(roomAPI2.getHotelName())
                            && roomAPI1.getPersons() == roomAPI2.getPersons() && roomAPI1.getPrice() == roomAPI2.getPrice()) {
                        room[index1] = roomAPI1;
                        index1++;
                    }
                }
            }
        }


        return room;
    }

    public Room cheapestRoom() {
        return new Room(100, 300, 20, new Date(), "Rixos", "Dnipro");
    }


}
