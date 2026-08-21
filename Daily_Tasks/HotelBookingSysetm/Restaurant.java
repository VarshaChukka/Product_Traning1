public class Restaurant {

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void displayMenu() {
        System.out.println("Displaying restaurant menu...");
    }

    public void orderFood() {
        System.out.println("Ordering food...");
    }
}