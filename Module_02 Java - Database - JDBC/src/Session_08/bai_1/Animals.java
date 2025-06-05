package Session_08.bai_1;

public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        if (age < 0){
            System.out.println("Tuổi không được âm.");
        }
        if (name == null || name.isEmpty()) {
            System.out.println("Tên không được để trống.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Tên không được để trống.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            System.out.println("Tuổi không được âm.");
        }
        this.age = age;
    }

    public void displayInfo() {
        System.out.printf("Tên: %s, Tuổi: %d \n", name, age);
    }

    public void makeSound() {
        System.out.println("Some generic sound");
    }

}
