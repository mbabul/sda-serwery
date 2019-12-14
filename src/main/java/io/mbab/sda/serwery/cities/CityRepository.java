package io.mbab.sda.serwery.cities;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class CityRepository {

//    private final Logger log = LoggerFactory.getLogger(CityRepository.class);

    private final String SQL_GET_ALL = "SELECT * FROM city";
    private final String SQL_GET_ONE = "SELECT * FROM city WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<City> getAll() {
        log.debug("query for cities list");

        return jdbcTemplate.query(
                SQL_GET_ALL,
                (resultSet, rowNum) -> mapRow(resultSet));
    }

    Optional<City> findById(long id) {
        log.debug("query for city with id: {}", id);

        return jdbcTemplate.query(
                SQL_GET_ONE,
                resultSet ->
                        resultSet.next() ?
                                Optional.of(mapRow(resultSet)) :
                                Optional.empty(),
                id);
    }

    private City mapRow(ResultSet rs) throws SQLException {
        return City.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .build();
    }

    public void test() throws RuntimeException {
        throw new RuntimeException("Example exception");
    }

}
