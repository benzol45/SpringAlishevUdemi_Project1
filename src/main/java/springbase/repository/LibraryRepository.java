package springbase.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springbase.entity.Book;
import springbase.entity.People;
import springbase.repository.rowmappers.PeopleRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksByPeopleId(int id) {
        //language=sql
        return jdbcTemplate.query("SELECT id, author, title, year FROM given_book LEFT JOIN book ON given_book.book_id = book.id WHERE people_id=?",new BeanPropertyRowMapper<>(Book.class), id);
    }

    public Optional<People> getPeopleByBookId(int id) {
        //language=sql
        return jdbcTemplate.query("SELECT id, name, age FROM given_book LEFT JOIN people ON given_book.people_id = people.id WHERE book_id=?",new PeopleRowMapper(), id).stream().findFirst();
    }

    public void makeFreeBookById(int book_id) {
        //language=sql
        jdbcTemplate.update("DELETE FROM given_book WHERE book_id=?",book_id);
    }

    public void giveoutBookByIdToPersonById(int book_id, int person_id) {
        //language=sql
        jdbcTemplate.update("INSERT INTO given_book VALUES (?,?)", book_id, person_id);
    }
}
