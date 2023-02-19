package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util.statement.executeUpdate("CREATE TABLE IF NOT EXISTS User (" +
                           "id int auto_increment primary key," +
                          "name varchar(30) not null," +
                          "lastName varchar(30) not null," +
                          "age smallint not null )");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            Util.statement.executeUpdate("DROP TABLE IF EXISTS User");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Util.statement.executeUpdate(String.format("INSERT INTO User (name, lastName, age) " +
                    "value ('%s', '%s', %s)", name, lastName, age));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            Util.statement.executeUpdate("DELETE FROM User WHERE id=" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        ResultSet resultSet;
        List<User> userList = new ArrayList<>();
        try {
            resultSet = Util.statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                userList.add(
                        new User(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                (byte) resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            Util.statement.executeUpdate("TRUNCATE TABLE User");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
