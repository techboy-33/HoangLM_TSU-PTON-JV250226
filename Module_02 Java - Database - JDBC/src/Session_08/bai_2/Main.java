package Session_08.bai_2;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 80);

        car.star();
        car.displayInfo();
        bike.star();
        bike.displayInfo();
    }
}
