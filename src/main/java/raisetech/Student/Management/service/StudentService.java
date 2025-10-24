package raisetech.Student.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.repository.StudentRepository;
import raisetech.Student.Management.repository.StudentsCoursesRepository;
import java.util.List;
import java.util.UUID;

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

    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void registerStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentRepository.insertStudent(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Transactional
    public void updateStudentsCourses(List<StudentsCourses> studentsCoursesList) {
        if (studentsCoursesList == null || studentsCoursesList.isEmpty()) return;
        for (StudentsCourses course : studentsCoursesList) {
            studentsCoursesRepository.updateStudentsCourses(course);
        }
    }
}