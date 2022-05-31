package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepositories extends JpaRepository<Book, String> {

    @Query(value = """
            select * from Book where Title Like Concat ('%', :title, '%');
            """, nativeQuery = true)
    List<Book> getTitle (@Param("title") String title);
}
