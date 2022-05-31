package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Author.AuthorUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.AuthorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private AuthorRepositories authorRepositories;

    @Autowired
    public AuthorService(AuthorRepositories authorRepositories){
        this.authorRepositories = authorRepositories;
    }

    public List<AuthorDto> findAllAuthor(){

        List<Author> authorList = authorRepositories.findAll();
        List<AuthorDto> result = authorList.stream()
                .map(author -> new AuthorDto(
                        author.getId(),
                        author.getFullName(),
                        author.getBirthDate(),
                        author.getDeceasedDate(),
                        author.getEducation(),
                        author.getSummary()))
                .collect(Collectors.toList());
        return result;
    }

    public List<AuthorDto> insertAuthor(AuthorInsertDto newAuthor){

        Author author = newAuthor.convert();
        authorRepositories.save(author);
        return AuthorDto.toList(authorRepositories.findAll());
    }

    public boolean updateAuthor(Long id, AuthorUpdateDto authorUpdateDto){
        boolean result = false;
        Author oldAuthor = authorRepositories.getById(id);

        oldAuthor.setTitle(authorUpdateDto.getTitle());
        oldAuthor.setFirstName(authorUpdateDto.getFirstName());
        oldAuthor.setLastName(authorUpdateDto.getLastName());
        oldAuthor.setBirthDate(authorUpdateDto.getBirthDate());
        oldAuthor.setDeceasedDate(authorUpdateDto.getDeceasedDate());
        oldAuthor.setEducation(authorUpdateDto.getEducation());
        oldAuthor.setSummary(authorUpdateDto.getSummary());

        authorRepositories.save(oldAuthor);

        return true;
    }

    public boolean deleteAuthorById (Long id){
        authorRepositories.deleteById(id);
        return true;
    }

    public List<AuthorDto> findAllAuthorByName (String name) {
        return AuthorDto.toList(authorRepositories.getName(name));
    }


}
