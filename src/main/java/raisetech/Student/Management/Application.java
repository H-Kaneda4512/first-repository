package raisetech.Student.Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private StudentRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
    @SuppressWarnings("unused")
    @GetMapping("/student")
    public String getStudent(@RequestParam String name) {
        Student student = repository.searchByName(name);
        return student.getName() + " " + student.getAge() + "歳";
    }

    @SuppressWarnings("unused")
    @GetMapping("/students")
    public List<Student>getAllStudents() {
        return repository.findAll();
    }

    @SuppressWarnings("unused")
    @PostMapping("/student")
    public void registerStudent(@RequestParam String name, @RequestParam int age) {
      repository.registerStudent(name, age);
    }

    @SuppressWarnings("unused")
    @PatchMapping("/student")
    public void updateStudent(@RequestParam String name, @RequestParam int age) {
      repository.updateStudent(name, age);
    }

    @SuppressWarnings("unused")
    @DeleteMapping("/student")
    public void deleteStudent(@RequestParam String name) {
       repository.deleteStudent(name);
    }
}