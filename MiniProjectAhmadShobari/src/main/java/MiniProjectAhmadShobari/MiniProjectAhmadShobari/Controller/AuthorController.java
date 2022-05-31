package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Controller;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("find-all")
        public List<AuthorDto> findAllDto(){
            return authorService.findAllAuthor();
    }

    @PostMapping("insert")
    public ResponseEntity<List<AuthorDto>> insertNewAuthor(@RequestBody AuthorInsertDto newAuthor){
        return  ResponseEntity.ok().body(
                authorService.insertAuthor(newAuthor)
        );
    }

    @PutMapping("{id}")
    public boolean updateAuthor(@PathVariable Long id, @RequestBody AuthorUpdateDto authorUpdateDto){
        return  authorService.updateAuthor(id, authorUpdateDto);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id){
        return authorService.deleteAuthorById(id);
    }

    @GetMapping("name")
    public List<AuthorDto> findAllAuthorByName (@RequestParam String name){
        return authorService.findAllAuthorByName(name);
    }


}
