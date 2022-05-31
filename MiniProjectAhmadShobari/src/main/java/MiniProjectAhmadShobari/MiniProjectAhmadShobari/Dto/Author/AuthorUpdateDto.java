package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author;

import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AuthorUpdateDto {

    private String title;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deceasedDate;
    private String education;
    private String summary;
}
