package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepositories extends JpaRepository<Category, String> {

    @Query(value = """
            select * from Category where Name Like Concat ('%',:name,'%');
            """, nativeQuery = true)
    List<Category> getName(@Param("name") String name);
}
