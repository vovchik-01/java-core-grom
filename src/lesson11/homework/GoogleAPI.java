package lesson11.homework;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {

        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city)
                    && room.getHotelName().equals(hotel)) {
                index++;
            }
        }
        Room[] findRooms = new Room[index];
        int index1 = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city)
                    && room.getHotelName().equals(hotel)) {
                findRooms[index1] = room;
                index1++;
            }

        }
        return findRooms;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }


}