package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepositories extends JpaRepository<Loan, Long> {

    @Query(value = """
            select * from Loan where CustomerNumber Like Concat ('%',:number,'%');
            """, nativeQuery = true)
    List<Loan> getNumber(@Param("number") String number);

    @Query(value = """
            select * from Loan where BookCode Like Concat ('%',:code,'%');
            """, nativeQuery = true)
    List<Loan> getCode(@Param("code") String code);

}
