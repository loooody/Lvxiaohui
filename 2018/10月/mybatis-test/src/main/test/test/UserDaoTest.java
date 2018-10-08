package test;

import dao.UserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class UserDaoTest {

    @Test
    public void findUserById(){
        SqlSession sqlsession = getSessionFactory().openSession();
        UserDao userMapper = sqlsession.getMapper(UserDao.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
        userMapper.insertUser(new User("lvxiaohui",20));
        userMapper.deleteUser(2);
        sqlsession.commit();
        sqlsession.close();
    }

    private static SqlSessionFactory getSessionFactory(){
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
         //   System.out.println(sessionFactory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
