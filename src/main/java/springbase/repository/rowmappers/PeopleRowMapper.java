package springbase.repository.rowmappers;

import org.springframework.jdbc.core.RowMapper;
import springbase.entity.People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleRowMapper implements RowMapper<People> {
    @Override
    public People mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new People(
                rs.getInt("id")
                ,rs.getString("name")
                ,rs.getInt("age"));
    }
}
