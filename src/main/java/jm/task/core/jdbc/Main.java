package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = Util.hibernateOpen();
        UserServiceImpl userService = new UserServiceImpl();

        try {
            userService.createUsersTable();

            userService.saveUser("Alexey", "Gorbunov", (byte) 28);
            userService.saveUser("Ivan", "Ivanov", (byte) 32);
            userService.saveUser("Petr", "Petrov", (byte) 20);
            userService.saveUser("Olga", "Abdullaeva", (byte) 26);

            userService.getAllUsers();

            userService.cleanUsersTable();

            userService.dropUsersTable();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}


