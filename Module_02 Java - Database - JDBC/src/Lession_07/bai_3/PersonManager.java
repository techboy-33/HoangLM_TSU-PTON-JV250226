package Lession_07.bai_3;

import java.util.Scanner;

public class PersonManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person1 = new Person();
        System.out.print("Nhập tên người thứ nhất: ");
        person1.setName(scanner.nextLine());
        System.out.print("Nhập tuổi người thứ nhất: ");
        person1.setAge(Integer.parseInt(scanner.nextLine()));

        Person person2 = new Person();
        System.out.print("Nhập tên người thứ hai: ");
        person2.setName(scanner.nextLine());
        System.out.print("Nhập tuổi người thứ hai: ");
        person2.setAge(Integer.parseInt(scanner.nextLine()));

        if (person1.getAge() > person2.getAge()) {
            System.out.printf("%s lớn tuổi hơn %s", person1.getName(), person2.getName());
        }else {
            System.out.printf("%s lớn tuổi hơn %s", person2.getName(), person1.getName());
        }
    }
}