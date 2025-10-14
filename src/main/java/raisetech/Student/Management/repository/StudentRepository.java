package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.Student.Management.data.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Insert("INSERT INTO students (id, name, kana_name, nickname, email, area, age, sex, remark, is_deleted) " +
          "VALUES (#{id}, #{name}, #{kanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark}, #{isDeleted})")
  void insertStudent(Student student);
}
