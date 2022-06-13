package springbase.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springbase.entity.People;
import springbase.repository.rowmappers.PeopleRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class PeopleRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<People> getAll() {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM people ORDER BY name", new PeopleRowMapper());
    }

    public Optional<People> getById(int id) {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM people WHERE id=?", new PeopleRowMapper(), new Object[]{id}).stream()
                .findFirst();
    }

    public Optional<People> getByName(String name) {
        //language=sql
        return jdbcTemplate.query("SELECT * FROM people WHERE name=?",new PeopleRowMapper(),name).stream().findFirst();
    }

    public void save(People people) {
        //language=sql
        jdbcTemplate.update("INSERT INTO people(name,age) VALUES (?,?)", people.getName(), people.getAge());
    }

    public void deleteById(int id) {
        //language=sql
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }

    public void update(int id, People people) {
        //language=sql
        jdbcTemplate.update("UPDATE people SET name=?, age=? WHERE id=?", people.getName(), people.getAge(), id);
    }
}
