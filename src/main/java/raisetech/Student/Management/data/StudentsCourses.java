package raisetech.Student.Management.data;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class StudentsCourses {
    private String id;
    private String studentId;
    private String courseName;
    private String fullName;
    private Timestamp courseStartAt;
    private Timestamp courseEndAt;
}
