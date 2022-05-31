package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookInsertDto {

    private String code;
    private String title;
    private String categoryName;
    private Long authorId;
    private boolean borrowed;
    private String summary;
    private LocalDate releaseDate;
    private int totalPage;

    public Book convertBook(Category category, Author author){

        return new Book(
                code,
                title,
                category,
                author,
                summary,
                releaseDate,
                totalPage);
    }

}
