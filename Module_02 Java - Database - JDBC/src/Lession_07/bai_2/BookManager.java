package Lession_07.bai_2;

public class BookManager {
    public static void main(String[] args) {
        Book mybook = new Book();

        mybook.setTitle("Java Programming");
        mybook.setAuthor("John Doe");

        mybook.setPrice(29.99);

        System.out.println("Tiêu đề: " + mybook.getTitle());
        System.out.println("Tác giả: " + mybook.getAuthor());
        System.out.println("Giá: " + mybook.getPrice());

        mybook.setPrice(35.50);
        System.out.println("Giá mới: " + mybook.getPrice());

        mybook.setPrice(-5.00);
    }
}
