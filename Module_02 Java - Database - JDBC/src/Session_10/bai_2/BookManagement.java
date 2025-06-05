package Session_10.bai_2;

import java.util.HashMap;

public class BookManagement {
    private HashMap<String, Book> books;

    public BookManagement () {
        books = new HashMap<>();
    }

    public void addBook (Book book) {
        books.put(book.getName(), book);
    }

    public Book searchBook (String searchNameBook) throws Exception {
        if (!books.containsKey(searchNameBook)) {
            throw new Exception("Sách không tồn tại !");
        }
        return books.get(searchNameBook);
    }

    public void displayData () {
        if (books.isEmpty()) {
            System.out.println("Chưa có data.");
        }else {
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }
}
