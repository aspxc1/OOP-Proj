public class Amenity {
    private String name;

    public Amenity(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Amenity name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() { return name; }
}