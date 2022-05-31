package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepositories extends JpaRepository<Customer, String> {

    @Query(value = """
            select * from Customer where Concat ( FirstName, ' ', LastName) Like Concat ('%',:name,'%');
            """, nativeQuery = true)
    List<Customer> getNameCustomer(@Param("name") String name);

}
