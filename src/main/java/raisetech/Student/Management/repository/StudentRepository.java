package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.Student.Management.data.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();
}
