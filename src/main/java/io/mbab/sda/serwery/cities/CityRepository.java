package io.mbab.sda.serwery.cities;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                (resultSet, rowNum) -> City.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build());
    }

    City getOne(long id) {
        log.debug("query for city with id: {}", id);

        return jdbcTemplate.queryForObject(
                SQL_GET_ONE,
                (resultSet, rowNum) -> City.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build(),
                id);
    }
}
