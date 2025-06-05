package Session_09.bai_2;

public class Dog extends Pet{
    public Dog() {
    }

    public Dog(String petId, String petName, String age) {
        super(petId, petName, age);
    }

    @Override
    public void speak() {
        System.out.println("Gâu gâu");
    }
}
