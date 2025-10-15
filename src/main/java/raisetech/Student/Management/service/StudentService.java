package raisetech.Student.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public void registerStudentWithCourse(StudentDetail studentDetail) {

        Student student = studentDetail.getStudent();
        student.setId(java.util.UUID.randomUUID().toString());
        studentRepository.insertStudent(student);

        if (studentDetail.getStudentsCourses() != null && !studentDetail.getStudentsCourses().isEmpty()) {
            StudentsCourses course = studentDetail.getStudentsCourses().get(0);
            course.setId(java.util.UUID.randomUUID().toString());
            course.setStudentId(student.getId());
            studentsCoursesRepository.insertCourse(course);
        }
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

}
