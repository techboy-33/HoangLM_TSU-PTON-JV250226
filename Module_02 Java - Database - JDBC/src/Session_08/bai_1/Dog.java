package Session_08.bai_1;

public class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Âm thanh : Woof Woof");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Giống chó: %s \n", breed);
        makeSound();
    }
}
