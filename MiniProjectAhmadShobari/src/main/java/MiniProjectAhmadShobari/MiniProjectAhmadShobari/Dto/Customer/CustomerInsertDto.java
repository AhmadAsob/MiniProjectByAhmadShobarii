package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class CustomerInsertDto {

    private String membershipNumber;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String phone;
    private String address;

    public Customer convertCustomer(){
        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));

        return new Customer(
                membershipNumber,
                firstName,
                lastName,
                LocalDate.parse(birthDate, formatTanggal),
                gender,
                phone,
                address);
    }
}
