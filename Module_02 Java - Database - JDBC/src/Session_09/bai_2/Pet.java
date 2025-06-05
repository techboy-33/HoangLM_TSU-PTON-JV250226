package Session_09.bai_2;

import java.util.Scanner;

public abstract class Pet {
    private String petId;
    private String petName;
    private String petAge;

    public Pet() {
    }

    public Pet(String petId, String petName, String petAge) {
        this.petId = petId;
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;

    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getpetAge() {
        return petAge;
    }

    public void setPetAge(String age) {
        this.petAge = petAge;
    }

    public void inputData(Scanner scanner) {
        System.out.println("***** Nhập thông tin thú cưng *****");
        inputPetId(scanner);
        inputPetName(scanner);
        inputPetAge(scanner);
    }

    public void displayData() {
        System.out.printf("Mã thú cưng: %s, Tên: %s, Tuổi: %s \n", petId, petName, petAge);
    }

    public abstract void speak();

    public void inputPetId(Scanner scanner) {
        boolean flat = true;
        do {
            System.out.print("Nhập mã (gồm 4 ký tự, ký tự đầu bắt đầu là C hoặc D, 3 ký tự sau là số): ");
            String inputId = scanner.nextLine();
            if (inputId.matches("^(?i)[cd][0-9]{3}$")) {
                boolean checkId = true;
                for (int i = 0; i < PetManagement.currentIndex; i++) {
                    if (PetManagement.petArray[i].petId.equalsIgnoreCase(inputId)) {
                        checkId = false;
                    }
                }
                if (checkId) {
                    this.petId = inputId;
                    flat = false;
                } else {
                    System.out.println("Mã này đã tồn tại.");
                }
            } else {
                System.out.println("Mã nhập vào không hợp lệ.");
            }
        } while (flat);
    }

    public void inputPetName(Scanner scanner) {
        boolean flat = true;
        do {
            System.out.print("Nhập tên (từ 3-10 ký tự): ");
            String inputName = scanner.nextLine();
            if (inputName.matches("^.{3,10}$")) {
                this.petName = inputName;
                flat = false;
            } else {
                System.out.println("Tên nhập vào không hợp lệ.");
            }
        } while (flat);
    }

    public void inputPetAge(Scanner scanner) {
        boolean flat = true;
        do {
            System.out.print("Nhập tuổi (số nguyên và lớn hơn 0): ");
            String inputAge = scanner.nextLine();
            if (inputAge.matches("^[1-9][0-9]*$")) {
                this.petAge = inputAge;
                flat = false;
            } else {
                System.out.println("Tuổi nhập vào không hợp lệ.");
            }
        } while (flat);
    }
}
