package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private Session session;
    SessionFactory sessionFactory = Util.hibernateOpen();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session=sessionFactory.getCurrentSession();
        session.save(user);

    }

    @Override
    public void removeUserById(long id) {
    session=sessionFactory.getCurrentSession();
    User user = session.get(User.class, id);
    session.delete(user);
    }

    @Override
    public List<User> getAllUsers() {
    session = sessionFactory.getCurrentSession();
        List<User>users = session.createQuery("from User").getResultList();
        for(User u : users){
            System.out.println(u);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
  session = sessionFactory.getCurrentSession();
  session.createQuery("delete User");
    }
}
