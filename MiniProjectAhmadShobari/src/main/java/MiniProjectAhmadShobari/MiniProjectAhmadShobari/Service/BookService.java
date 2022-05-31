package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.AuthorRepositories;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.BookRepositories;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepositories bookRepositories;
    private CategoryRepositories categoryRepositories;
    private AuthorRepositories authorRepositories;

    @Autowired
    public BookService(BookRepositories bookRepositories, CategoryRepositories categoryRepositories, AuthorRepositories authorRepositories){
        this.bookRepositories = bookRepositories;
        this.categoryRepositories = categoryRepositories;
        this.authorRepositories = authorRepositories;}

    public List<BookDto> findAllBook(){

        List<Book> bookList = bookRepositories.findAll();
        List<BookDto> result = bookList.stream()
                .map(book -> new BookDto(
                        book.getCode(),
                        book.getTitle(),
                        book.getCategory().getName(),
                        book.getAuthor().getId(),
                        book.isBorrowed(),
                        book.getSummary(),
                        book.getReleaseDate(),
                        book.getTotalPage()))
                .collect(Collectors.toList());
        return result;
    }

    public List<BookDto> insertBook(BookInsertDto newBook){
        Category category = categoryRepositories.findById(newBook.getCategoryName()).orElseThrow(() -> new EntityNotFoundException("Category tidak ditemukan!"));
        Author author = authorRepositories.findById(newBook.getAuthorId()).orElseThrow(() -> new EntityNotFoundException("Author tidak ditemukan!"));
        Book book = newBook.convertBook(category, author);
        bookRepositories.save(book);
        return BookDto.toList(bookRepositories.findAll());
    }

    public boolean updateBook(String code, BookUpdateDto bookUpdateDto){
        boolean result = false;
        Category category = categoryRepositories.findById(bookUpdateDto.getCategoryName()).orElseThrow(() -> new EntityNotFoundException("Category tidak ditemukan!"));
        Author author = authorRepositories.findById(bookUpdateDto.getAuthorId()).orElseThrow(() -> new EntityNotFoundException("Author tidak ditemukan!"));
        Book oldBook = bookRepositories.getById(code);

        oldBook.setTitle(bookUpdateDto.getTitle());
        category.setName(bookUpdateDto.getCategoryName());
        author.setId(bookUpdateDto.getAuthorId());
        oldBook.setBorrowed(bookUpdateDto.isBorrowed());
        oldBook.setSummary(bookUpdateDto.getSummary());
        oldBook.setReleaseDate(bookUpdateDto.getReleaseDate());
        oldBook.setTotalPage(bookUpdateDto.getTotalPage());

        bookRepositories.save(oldBook);

        return true;
    }

    public boolean deleteBookByCode (String code){
        bookRepositories.deleteById(code);
        return true;
    }

    public List<BookDto> findAllBookByTitle (String title){
        return BookDto.toList(bookRepositories.getTitle(title));
    }
}
