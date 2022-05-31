package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerUpdateDto {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String phone;
    private String address;
}
