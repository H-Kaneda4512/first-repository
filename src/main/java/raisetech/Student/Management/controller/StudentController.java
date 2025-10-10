package raisetech.Student.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/studentList")
    public List<Student> getStudentList() {
        return service.searchStudentList();
    }

    @GetMapping("/studentsCoursesList")
    public List<StudentsCourses> getStudentsCourseList() {
        return service.searchStudentsCourseList();
    }

    @GetMapping("/studentList/thirties")
    public List<Student> getStudentsInThirties() {
        return service.searchStudentsInThirties();
    }

    @GetMapping("/studentsCoursesList/java")
    public List<StudentsCourses> getJavaCourses() {
        return service.searchJavaCourses();
    }
}
