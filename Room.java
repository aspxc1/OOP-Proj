import java.util.List;

public class Room {
    private int roomNumber;
    private RoomType roomType;
    private List<Amenity> amenities;
    private boolean isAvailable;
    public static int roomCount = 0;


    public Room(int roomNumber, RoomType roomType, List<Amenity> amenities) {
        setRoomNumber(roomCount);
        setRoomType(roomType);
        setAmenities(amenities);
        this.isAvailable = true;
        roomCount++;
    }

    private void setRoomNumber(int roomNumber) {
        if (roomNumber < 0) {
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void displayRoomDetails() {
        System.out.println("----- Room Details -----");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType.getName());
        System.out.println("Price per Night: " + roomType.getPricePerNight());
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));

        System.out.println("Amenities:");
        if (amenities.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Amenity amenity : amenities) {
                System.out.println("  - " + amenity.getName());
            }
        }

        System.out.println("------------------------");
    }
}