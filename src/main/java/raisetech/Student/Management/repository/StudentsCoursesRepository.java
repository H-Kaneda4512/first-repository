package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.*;
import raisetech.Student.Management.data.StudentsCourses;
import java.util.List;

@Mapper
public interface StudentsCoursesRepository {

    @Select("""
        SELECT sc.id, sc.student_id, sc.course_name, s.name AS full_name, 
               sc.course_start_at, sc.course_end_at
        FROM students_courses sc
        JOIN students s ON sc.student_id = s.id
    """)
    List<StudentsCourses> findAll();

    @Insert("""
        INSERT INTO students_courses (id, student_id, course_name)
        VALUES (#{id}, #{studentId}, #{courseName})
    """)
    void insertCourse(StudentsCourses studentsCourses);

    @Update("""
        UPDATE students_courses 
        SET course_name = #{courseName}, 
            course_start_at = #{courseStartAt}, 
            course_end_at = #{courseEndAt}
        WHERE id = #{id}
    """)
    void updateStudentsCourses(StudentsCourses studentsCourses);
}
