package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Connection connection = Util.open();


    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {
        Statement statement = null;
        String sql = "CREATE TABLE IF NOT EXISTS users(" +
                "id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(20)," +
                "lastName VARCHAR(20)," +
                "age TINYINT)";
        try {
            statement = connection.createStatement();
            statement.execute(sql);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    public void dropUsersTable() throws SQLException {
        String sql1 = "DROP TABLE IF EXISTS users ";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql1);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);

        PreparedStatement preparedStatement = null;
        String sql1 = "INSERT INTO users (name, lastName, age) VALUES (? ,? ,?)";
        try {
            preparedStatement = connection.prepareStatement(sql1);


            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setByte(3, user.getAge());

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException {
        User user = new User();
        user.setId(id);
        PreparedStatement preparedStatement = null;
        String sql1 = "DELETE FROM users WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        User user = new User();
        String sql1 = "SELECT id, name, lastName, age FROM users";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                list.add(user);
                System.out.println(user.toString());
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() throws SQLException {
        String sql1 = "TRUNCATE TABLE users";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql1);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }

    }
}
