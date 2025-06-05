package Session_09.bai_2;

public class Cat  extends Pet{
    public Cat() {
    }

    public Cat(String petId, String petName, String age) {
        super(petId, petName, age);
    }

    @Override
    public void speak() {
        System.out.println("Meo meo");
    }
}
