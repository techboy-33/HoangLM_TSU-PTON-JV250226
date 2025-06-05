package Session_08.bai_1;

public class Cat extends Animals{
    private String fulColor;

    public Cat(String name, int age, String fulColor) {
        super(name, age);
        this.fulColor = fulColor;
    }

    @Override
    public void makeSound() {
        System.out.println("Âm thanh : Meow Meow");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Màu lông: %s \n", fulColor);
        makeSound();
    }
}
