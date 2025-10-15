package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.*;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;

import java.util.List;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Insert("INSERT INTO students (name, kana_name, nickname, email, area, age, sex, remark, is_deleted) " +
          "VALUES ( #{name}, #{kanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark}, #{isDeleted})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insertStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course_start_at,  course_end_at)" +
          "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentCourses(StudentsCourses studentsCourses);

  // IDで受講生を取得
  @Select("SELECT * FROM students WHERE id = #{id}")
  Student findById(String id);

  // 受講生情報を更新
  @Update("UPDATE students SET " +
          "name = #{name}, kana_name = #{kanaName}, nickname = #{nickname}, email = #{email}, " +
          "area = #{area}, age = #{age}, sex = #{sex}, remark = #{remark}, is_deleted = #{isDeleted} " +
          "WHERE id = #{id}")
  void updateStudent(Student student);
}
