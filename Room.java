import java.util.List;

public class Room {
    private int roomNumber;
    private RoomType roomType;
    private List<Amenity> amenities;
    private boolean isAvailable;

    public Room(int roomNumber, RoomType roomType, List<Amenity> amenities) {
        setRoomNumber(roomNumber);
        setRoomType(roomType);
        setAmenities(amenities);
        this.isAvailable = true;
    }

    public void setRoomNumber(int roomNumber) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be positive.");
        }
        this.roomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("Room type cannot be null.");
        }
        this.roomType = roomType;
    }

    public void setAmenities(List<Amenity> amenities) {
        if (amenities == null) {
            throw new IllegalArgumentException("Amenities list cannot be null.");
        }
        this.amenities = amenities;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRoomNumber() { return roomNumber; }
    public RoomType getRoomType() { return roomType; }
    public List<Amenity> getAmenities() { return amenities; }
    public boolean isAvailable() { return isAvailable; }
}