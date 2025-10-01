package ra.edu.session_01.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.session_01.model.entity.Book;
import ra.edu.session_01.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(String search) {
        return bookRepository.getAllBooks( search);

    }

    public Book findById(long id){
        return bookRepository.getBookById(id);
    }

    public Book save(Book book) {
        return bookRepository.saveBook(book);
    }

    public Book update(Book book ,long id) {
        Book oldBook = bookRepository.getBookById(id);
        if(oldBook != null){

            book.setId(id);
            return bookRepository.saveBook(book);
        }else {
            return null;
        }
    }

    public boolean deleteById(long id) {
        Book book = bookRepository.getBookById(id);
        if(book != null){
            return bookRepository.deleteBook(book);
        }else {
            return false;

        }    }

}