public class roomPreferences{

    private RoomType roomtype;
    private int floor;

    public roomPreferences(RoomType roomtype, int floor){
        this.roomtype = roomtype;
        this.floor = floor;
    }
    public RoomType getRoomType() {
        return roomtype;
    }
    public int getFloor() {
        return floor;
    }

    public void setRoomType(RoomType roomtype) {
        this.roomtype = roomtype;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }


}
