package raisetech.Student.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;
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

    public void registerStudent(Student student) {
        student.setId(java.util.UUID.randomUUID().toString());
        studentRepository.insertStudent(student);
    }

    public void registerStudentWithCourse(StudentDetail studentDetail) {
        // 1. 受講生登録
        Student student = studentDetail.getStudent();
        student.setId(java.util.UUID.randomUUID().toString());
        studentRepository.insertStudent(student);

        // 2. コース情報登録（入力があれば）
        if (studentDetail.getStudentsCourses() != null && !studentDetail.getStudentsCourses().isEmpty()) {
            StudentsCourses course = studentDetail.getStudentsCourses().get(0);
            course.setId(java.util.UUID.randomUUID().toString());
            course.setStudentId(student.getId());
            studentsCoursesRepository.insertCourse(course);
        }
    }

}
