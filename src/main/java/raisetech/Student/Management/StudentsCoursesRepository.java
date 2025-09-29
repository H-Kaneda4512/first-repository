package raisetech.Student.Management;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface StudentsCoursesRepository {

    @Select("SELECT sc.course_id, sc.student_id, sc.course_name, s.full_name, sc.start_date, sc.end_date " +
            "FROM students_courses sc " +
            "JOIN students s ON sc.student_id = s.student_id")
    List<StudentsCourses> findAll();

}