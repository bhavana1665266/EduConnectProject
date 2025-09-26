package com.wecp.progressive.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO {
<<<<<<< HEAD
    private Connection connection;
=======
<<<<<<< HEAD
    private Connection connection;
=======
    Connection connection;
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b

    public CourseDAOImpl() {
        try
        {
<<<<<<< HEAD
            connection=DatabaseConnectionManager.getConnection() ;
=======
<<<<<<< HEAD
            connection=DatabaseConnectionManager.getConnection() ;
=======
            Connection connection=DatabaseConnectionManager.getConnection() ;
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public int addCourse(Course course) throws SQLException {
        // TODO Auto-generated method stub
        String query="insert into course(course_name, description, teacher_id) values(?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);)
        {
            ps.setString(1, course.getCourseName());
            ps.setString(2,course.getDescription());
<<<<<<< HEAD
            ps.setInt(3,course.getTeacherId());
=======
<<<<<<< HEAD
            ps.setInt(3,course.getTeacherId());
=======
            //ps.setInt(3,course.getTeacherId());
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
            
            int affectedRows = ps.executeUpdate();

            if(affectedRows>0)
            {
                try(ResultSet rs=ps.getGeneratedKeys())
                {
                    if(rs.next())
                    {
                        course.setCourseId(rs.getInt(1));
                        return course.getCourseId();
                    }
                }
            }
            
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        // catch(SQLException e)
        // {
        //     throw new SQLException(e.getMessage());
        // }
<<<<<<< HEAD
=======
=======
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        return -1;
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        String query="delete from course where course_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query);)
        {
            ps.setInt(1, courseId);   
            ps.executeUpdate();
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        // catch(SQLException e)
        // {
        //     throw new SQLException(e.getMessage());
        // }
<<<<<<< HEAD
=======
=======
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        // TODO Auto-generated method stub
        List<Course> li= new ArrayList<>();
        
        String query="select * from course";
        try(Statement ps=connection.createStatement())
        {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
            ResultSet rs=ps.executeQuery(query);
            {
                while(rs.next())
                {
                    li.add(new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                }
            }
        }
        // catch(SQLException e)
        // {
        //     throw new SQLException(e.getMessage());
        // }
<<<<<<< HEAD
=======
=======
            try(ResultSet rs=ps.executeQuery(query);)
            {
                while(rs.next())
                {
                    //li.add(new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
                }
            }
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        return li;
        
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
       
        String query="select * from course where course_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1, courseId);
            ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                    return new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                }
            }

        // catch(SQLException e)
        // {
        //     throw new SQLException(e.getMessage());
        // }
         return null;
<<<<<<< HEAD
=======
=======
        // TODO Auto-generated method stub
        String query="select * from course where course_id=?";
        try(PreparedStatement ps=connection.prepareStatement(query);)
        {
            ps.setInt(1, courseId);
            try(ResultSet rs=ps.executeQuery();)
            {
                if(rs.next())
                {
                    //return new Course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                }
            }

        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
        return null;
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        // TODO Auto-generated method stub
        String query="update course set course_name=?, description=?, teacher_id=? where course_id=?";
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        
        try(PreparedStatement ps=connection.prepareStatement(query))
        {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getTeacherId());
            ps.setInt(4, course.getCourseId());
            ps.executeUpdate();

        }
        // catch(SQLException e)
        // {
        //     throw new SQLException(e.getMessage());
        // }
<<<<<<< HEAD
=======
=======
        try(PreparedStatement ps=connection.prepareStatement(query);)
        {
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getDescription());
            //ps.setInt(3, course.getTeacherId());
            ps.setInt(4, course.getCourseId());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            throw new SQLException(e.getMessage());
        }
>>>>>>> ba25ff8100aa2a5913fb692d3e9597ccc1926409
>>>>>>> 93d75797aeab4efd29684a9a28db9832f4c9db3b
        
    }
    
}
