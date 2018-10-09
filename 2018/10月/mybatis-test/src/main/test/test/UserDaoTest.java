package test;

import dao.CourseDao;
import dao.StudentDao;
import dao.UserDao;
import entity.Course;
import entity.Student;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

public class UserDaoTest {

//    @Test
//    public void findUserById(){
//        SqlSession sqlsession = getSessionFactory().openSession();
//        UserDao userMapper = sqlsession.getMapper(UserDao.class);
//        User user = userMapper.findUserById(1);
//        System.out.println(user);
//        userMapper.insertUser(new User("lvxiaohui",20));
//        userMapper.deleteUser(2);
//        userMapper.updateUser(new User(1, "lvxiaohui", 21));
//        sqlsession.commit();
//        sqlsession.close();
//    }


//    @Test
//    public void findCourseById(){
//        SqlSessionFactory sqlSessionFactory = getSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
//        Course course = courseDao.findCourseById(1);
//        System.out.println(course.toString());
//    }


    @Test
    public void findStudentById() {
        SqlSessionFactory sqlSessionFactory = getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.findStudentById("20140101");
        System.out.println(student.toString());
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
