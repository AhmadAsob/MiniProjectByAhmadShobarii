package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class AuthorDto {
    private final Long id;
    private final String fullName;
    private final LocalDate birthDate;
    private final LocalDate deceasedDate;
    private final String education;
    private final String summary;


    public static AuthorDto set (Author author){
        return new AuthorDto(
                author.getId(),
                author.getFullName(),
                author.getBirthDate(),
                author.getDeceasedDate(),
                author.getEducation(),
                author.getSummary());
    }

    public static List<AuthorDto> toList(List<Author> authors){
        List<AuthorDto> result = new ArrayList<>();
        for (Author author :authors){
            result.add(set(author));
        }
    return result;
    }
}
