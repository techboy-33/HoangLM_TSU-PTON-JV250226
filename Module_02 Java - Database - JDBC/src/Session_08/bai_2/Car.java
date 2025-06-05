package Session_08.bai_2;

public class Car extends Vehicle {


    public Car(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Car name: %s, Speed: %d km/h\n", getName(), getSpeed());
    }
}
