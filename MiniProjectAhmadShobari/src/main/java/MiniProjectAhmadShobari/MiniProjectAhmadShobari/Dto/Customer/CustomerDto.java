package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CustomerDto {


    private final String membershipNumber;
    private final String fullName;
    private final LocalDate birthDate;
    private final String gender;
    private final String phone;
    private final String address;
    private final LocalDate membershipExpireDate;

    public static List<CustomerDto> toList(List<Customer> customers){
        List<CustomerDto> result = new ArrayList<>();

        for (Customer customer : customers){
            result.add(new CustomerDto(customer.getMembershipNumber(), customer.getFullName(),customer.getBirthDate(),
                customer.getGender(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getMembershipExpireDate()));
        }
        return result;
    }
}
