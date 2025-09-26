package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Teacher;

<<<<<<< HEAD
import java.sql.SQLException;
=======
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
import java.util.List;

public interface TeacherDAO {
    int addTeacher(Teacher teacher) throws SQLException;
    Teacher getTeacherById(int teacherId) throws SQLException;
    void updateTeacher(Teacher teacher) throws SQLException;
    void deleteTeacher(int teacherId) throws SQLException;
    List<Teacher> getAllTeachers() throws SQLException;
}
