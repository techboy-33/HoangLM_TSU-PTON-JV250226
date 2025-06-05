package Lession_07.bai_1;

public class RectangleManager {
    public static void main(String[] args) {
        System.out.println("Hình chữ nhật 1:");
        Rectangle rectangle1 = new Rectangle();
        rectangle1.display();
        System.out.println("Hình chữ nhật 2:");
        Rectangle rectangle2 = new Rectangle(5,3);
        rectangle2.display();
    }
}
