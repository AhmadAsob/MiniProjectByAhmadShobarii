package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class AuthorInsertDto {

    private String title;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String deceasedDate;
    private String education;
    private String summary;

    public Author convert(){
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
        return new Author(
                title,
                firstName,
                lastName,
                LocalDate.parse(birthDate, formatTanggal),
                LocalDate.parse(deceasedDate, formatTanggal),
                education,
                summary);
    }
}
