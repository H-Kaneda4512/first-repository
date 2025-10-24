package raisetech.Student.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import raisetech.Student.Management.data.Student;
import raisetech.Student.Management.data.StudentsCourses;
import raisetech.Student.Management.domain.StudentDetail;
import raisetech.Student.Management.service.StudentService;
import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentList")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentService.searchStudentList());
        return "studentList";
    }

    @GetMapping("/students/{id}")
    public String editStudent(@PathVariable String id, Model model) {
        Student student = studentService.getStudentById(id);
        List<StudentsCourses> courses = studentService.searchStudentsCourseList()
                .stream()
                .filter(c -> c.getStudentId().equals(id))
                .toList();
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudent(student);
        studentDetail.setStudentsCourses(courses);
        model.addAttribute("studentDetail", studentDetail);
        return "editStudent";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute StudentDetail studentDetail) {
        studentService.updateStudent(studentDetail.getStudent());
        studentService.updateStudentsCourses(studentDetail.getStudentsCourses());
        return "redirect:/studentList";
    }
}
