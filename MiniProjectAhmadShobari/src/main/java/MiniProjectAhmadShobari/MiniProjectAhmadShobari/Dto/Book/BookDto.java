package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book;


import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDto {
    private final String code;
    private final String bookTitle;
    private final String category;
    private final Long author;
    private final boolean borrowed;
    private final String summary;
    private final LocalDate releaseDate;
    private final int totalPage;

    public static BookDto set (Book book){
        return new BookDto(
                book.getCode(),
                book.getTitle(),
                book.getCategory().getName(),
                book.getAuthor().getId(),
                book.isBorrowed(),
                book.getSummary(),
                book.getReleaseDate(),
                book.getTotalPage());
    }

    public static List<BookDto> toList(List<Book> bookList){
        List<BookDto> result = new ArrayList<>();
        for (Book book : bookList){
            result.add(set(book));
        }
        return result;
    }

}
