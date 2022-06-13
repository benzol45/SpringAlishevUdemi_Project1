package springbase.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springbase.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public class BooksRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAll() {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Optional<Book> getById(int id) {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM book WHERE id=?",new BeanPropertyRowMapper<>(Book.class),id).stream()
                .findFirst();
    }

    public Optional<Book> getByAllFields(String author, String title, int year) {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM book WHERE (author=?) AND (title=?) AND (year=?)",new BeanPropertyRowMapper<>(Book.class),author,title,year).stream().findFirst();
    }

    public void save(Book book) {
        //language=sql
        jdbcTemplate.update("INSERT INTO book(author, title, year) VALUES (?,?,?)", book.getAuthor(), book.getTitle(), book.getYear());
    }

    public void deleteById(int id) {
        //language=sql
        jdbcTemplate.update("DELETE FROM book WHERE id=?",id);
    }

    public void update(int id, Book book) {
        //language=sql
        jdbcTemplate.update("UPDATE book SET author=?, title=?, year=? WHERE id=?",book.getAuthor(),book.getTitle(),book.getYear(),id);
    }
}
