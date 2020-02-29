package lesson11.homework;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName().equals(city)
                    && room.getHotelName().equals(hotel) && room.getPrice() < room.getPrice() + 100 && room.getPrice() > room.getPrice() - 100) {
                index++;
            }
        }
        Room[] findRooms = new Room[index];
        int index1 = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getCityName().equals(city)
                    && room.getHotelName().equals(hotel) && room.getPrice() < room.getPrice() + 100 && room.getPrice() > room.getPrice() - 100) {
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
