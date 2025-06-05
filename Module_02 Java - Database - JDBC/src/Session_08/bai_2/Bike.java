package Session_08.bai_2;

public class Bike extends Vehicle{


    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Bike name: %s, Speed: %d km/h\n", getName(), getSpeed());
    }
}
