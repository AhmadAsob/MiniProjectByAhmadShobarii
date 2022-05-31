package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookUpdateDto {

    private String title;
    private String categoryName;
    private Long authorId;
    private boolean borrowed;
    private String summary;
    private LocalDate releaseDate;
    private int totalPage;
}
