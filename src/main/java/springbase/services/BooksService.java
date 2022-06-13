package springbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbase.entity.Book;
import springbase.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAll() {
        return booksRepository.getAll();
    }

    public Optional<Book> getById(int id) {
        return booksRepository.getById(id);
    }

    public void add(Book book) {
        booksRepository.save(book);
    }

    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public void update(int id, Book book) {
        booksRepository.update(id, book);
    }
}
