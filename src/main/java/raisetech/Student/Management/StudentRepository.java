package raisetech.Student.Management;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM student WHERE name = #{name}")
  Student searchByName(@Param("name")String name);

  @Select("SELECT * FROM student")
  List<Student>findAll();

  @Insert("INSERT INTO student (name, age) VALUES (#{name}, #{age})")
  void registerStudent(@Param("name") String name, @Param("age") int age);

  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
  void updateStudent(@Param("name") String name, @Param("age") int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);
}