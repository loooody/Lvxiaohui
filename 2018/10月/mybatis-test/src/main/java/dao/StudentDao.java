package dao;

import entity.Student;

public interface StudentDao {

    public Student findStudentById(String idCard);
}
