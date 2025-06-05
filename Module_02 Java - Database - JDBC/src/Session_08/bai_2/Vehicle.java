package Session_08.bai_2;

public abstract class Vehicle {
    private String name;
    private int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void displayInfo ();
    public void star() {
        System.out.println("Vehicle is starting...");
    }

}
