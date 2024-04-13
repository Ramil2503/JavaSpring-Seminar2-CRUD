package org.example.javaspringseminar2crud.repository;

import org.example.javaspringseminar2crud.config.DbQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.example.javaspringseminar2crud.model.User;

import java.util.List;

@Repository
public class UserRepository {


    private final JdbcTemplate jdbc;
    private final DbQueries dbQueries;

    public UserRepository(JdbcTemplate jdbc, DbQueries dbQueries) {
        this.jdbc = jdbc;
        this.dbQueries = dbQueries;
    }

    public List<User> findAll() {
        String sql = dbQueries.getFindAll();

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        jdbc.update(dbQueries.getAddUser(), user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id) {
        jdbc.update(dbQueries.getDeleteUser(), id);
    }

    public void editUser(int id, String firstName, String lastName) {
        jdbc.update(dbQueries.getUpdateUser(), firstName, lastName, id);
    }
}