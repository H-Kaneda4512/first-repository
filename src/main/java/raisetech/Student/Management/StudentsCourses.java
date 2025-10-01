package raisetech.Student.Management;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class StudentsCourses {
    private String courseId;
    private String studentId;
    private String courseName;
    private String fullName;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Timestamp startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
    private Timestamp endDate;
}