package lesson15.homework2;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() < (room.getPersons() + 1) && room.getPersons() > (room.getPersons() - 1) && room.getCityName().equals(city)
                    && room.getHotelName().equals(hotel)) {
                index++;
            }
        }
        Room[] findRooms = new Room[index];
        int index1 = 0;
        for (Room room : rooms) {
            if (room.getPrice() == price && room.getPersons() < (room.getPersons() + 1) && room.getPersons() > (room.getPersons() - 1) && room.getCityName().equals(city)) {
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
