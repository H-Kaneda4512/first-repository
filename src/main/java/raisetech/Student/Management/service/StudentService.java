package raisetech.Student.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.repository.StudentRepository;
import raisetech.Student.Management.repository.StudentsCoursesRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentsCoursesRepository studentsCoursesRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentsCoursesRepository studentsCoursesRepository) {
        this.studentRepository = studentRepository;
        this.studentsCoursesRepository = studentsCoursesRepository;
    }

    public List<Student> searchStudentList() {
        return studentRepository.search();
    }

    public List<StudentsCourses> searchStudentsCourseList() {
        return studentsCoursesRepository.findAll();
    }
}
