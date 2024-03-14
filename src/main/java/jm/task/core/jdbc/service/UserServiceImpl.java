package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        //userDaoJDBC.createUsersTable();
        userDaoHibernate.createUsersTable();
        System.out.println("createUsersTable OK");

    }

    public void dropUsersTable() throws SQLException {
        //userDaoJDBC.dropUsersTable();
        userDaoHibernate.dropUsersTable();
        System.out.println("dropUsersTable OK");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        //userDaoJDBC.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");

    }

    public void removeUserById(long id) throws SQLException {
        //userDaoJDBC.removeUserById(id);
        userDaoHibernate.removeUserById(id);
        System.out.println("removeUserById OK");
    }

    public List<User> getAllUsers() throws SQLException {
        //return userDaoJDBC.getAllUsers();
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        // userDaoJDBC.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
        System.out.println("cleanUsersTable OK");

    }
}
