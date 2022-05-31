package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepositories extends JpaRepository<Author, Long> {

    @Query(value = """
            select * from Author where Concat (Title, ' ', FirstName, ' ', LastName) Like Concat ('%',:name,'%');
            """, nativeQuery = true)
    List<Author> getName(@Param("name") String name);
}
