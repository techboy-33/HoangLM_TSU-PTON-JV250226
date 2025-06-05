package Lession_05;

public class Bai_2 {
    public static void main(String[] args) {
        StringBuilder firstInput = new StringBuilder("Hello, Java World!");
        System.out.println(firstInput);
        System.out.println(firstInput.delete(5, 11));
        System.out.println(firstInput.replace(6, 11, "Universe"));
    }
}
