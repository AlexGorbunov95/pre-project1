package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        SessionFactory sessionFactory=Util.hibernateOpen();
        UserServiceImpl userService = new UserServiceImpl();

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            userService.saveUser("Alexey", "Gorbunov", (byte) 28);
//            userService.saveUser("Ivan", "Ivanov", (byte) 32);
//            userService.saveUser("Petr", "Petrov", (byte) 20);
//            userService.saveUser("Olga", "Abdullaeva", (byte) 26);

           // userService.getAllUsers();

            //userService.removeUserById(2);
            //userService.cleanUsersTable();
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
       finally {
            sessionFactory.close();
        }





//                Connection connection = Util.open();
//
//        String sql = "START TRANSACTION";
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            statement.execute(sql);
//
//            userService.createUsersTable();
//
//            userService.saveUser("Alexey", "Gorbunov", (byte) 28);
//            userService.saveUser("Ivan", "Ivanov", (byte) 32);
//            userService.saveUser("Petr", "Petrov", (byte) 20);
//            userService.saveUser("Olga", "Abdullaeva", (byte) 26);
//
//            userService.getAllUsers();
//
//            //userService.removeUserById(2);
//
//           // userService.cleanUsersTable();
//
//           // userService.dropUsersTable();
//
//        } catch (SQLException e) {
//            connection.rollback();
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
   }


}


