package Session_08.bai_1;

public class Main {
    public static void main(String[] args) {
        Animals [] animals = new Animals[2];

        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Ghi");

        animals[0] = dog;
        animals[1] = cat;

        for (Animals item : animals) {
            item.displayInfo();
            System.out.println();
        }
    }
}
