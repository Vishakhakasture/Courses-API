package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Course;
import model.CourseInstance;

public class CourseDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/course_apidb";
    private static final String USER = "root";
    private static final String PASSWORD = "tiger";

    public void createCourse(Course course) {
        String sql = "INSERT INTO Courses (title, course_code, description, year, semester) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, course.getTitle());
            pstmt.setString(2, course.getCourseCode());
            pstmt.setString(3, course.getDescription());
            pstmt.setInt(4, course.getYear());
            pstmt.setString(5, course.getSemester());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createCourseInstance(CourseInstance courseInstance) {
        String sql = "INSERT INTO Course_Instances (course_id, year, semester) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, courseInstance.getCourseId());
            pstmt.setInt(2, courseInstance.getYear());
            pstmt.setString(3, courseInstance.getSemester());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

