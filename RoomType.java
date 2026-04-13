public class RoomType {

    public enum types{
        SINGLE,
        DOUBLE,
        SUITE
    }
    private types name;
    private String name;
    private double pricePerNight;

    public RoomType(String name, double pricePerNight) {
        setName(name);
        setPricePerNight(pricePerNight);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("RoomType name cannot be empty.");
        }
        this.name = types.valueOf(name);
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.pricePerNight = pricePerNight;
    }

    public types getName() {
        return name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
