package raisetech.Student.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    private final Map<String, String> studentMap = new HashMap<>();

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
    @SuppressWarnings("unused")
    @GetMapping("/studentInfo")
    public Map<String, String> getStudentInfo() {
        return studentMap;
    }

    @SuppressWarnings("unused")
    @PostMapping("/studentInfo")
    public String setStudentInfo(@RequestParam String name, @RequestParam String age) {
        studentMap.put(name, age);
        return name + " を登録しました（年齢: " + age + "）";
    }


    @SuppressWarnings("unused")
    @PostMapping("/studentName")
    public String updateStudentName(@RequestParam String oldName, @RequestParam String newName) {
        if (studentMap.containsKey(oldName)) {
            String age = studentMap.remove(oldName);
            studentMap.put(newName, age);
            return oldName + " → " + newName + " に変更しました";
        } else {
            return oldName + " のデータがありません";
        }
    }
}