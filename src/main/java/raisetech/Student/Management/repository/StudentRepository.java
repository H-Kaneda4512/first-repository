package raisetech.Student.Management.repository;

import org.apache.ibatis.annotations.*;
import raisetech.Student.Management.data.Student;
import java.util.List;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students WHERE is_deleted = false")
  List<Student> search();

  @Insert("""
        INSERT INTO students 
        (id, name, kana_name, nickname, email, area, age, sex, remark, is_deleted)
        VALUES (#{id}, #{name}, #{kanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex}, #{remark}, #{deleted})
    """)
  void insertStudent(Student student);

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student findById(String id);

  @Update("""
        UPDATE students SET
            name = #{name},
            kana_name = #{kanaName},
            nickname = #{nickname},
            email = #{email},
            area = #{area},
            age = #{age},
            sex = #{sex},
            remark = #{remark},
            is_deleted = #{deleted}
        WHERE id = #{id}
    """)
  void updateStudent(Student student);
}
