package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Controller;


import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Book.BookUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){this.bookService = bookService;}

    @GetMapping("find-all")
    public List<BookDto> findAllDto(){
        return bookService.findAllBook();
    }

    @PostMapping("insert")
    public ResponseEntity<List<BookDto>> insertNewBook(@RequestBody BookInsertDto newBook){
        return  ResponseEntity.ok().body(
                bookService.insertBook(newBook));
    }

    @PutMapping("{code}")
    public boolean updateBook(@PathVariable String code, @RequestBody BookUpdateDto bookUpdateDto){
        return bookService.updateBook(code, bookUpdateDto);
    }

    @DeleteMapping("{code}")
    public boolean deleteBook(@PathVariable String code){
        return bookService.deleteBookByCode(code);
    }

    @GetMapping("title")
    public List<BookDto> findAllBookByTitle (@RequestParam String title){
        return bookService.findAllBookByTitle(title);
    }
}
