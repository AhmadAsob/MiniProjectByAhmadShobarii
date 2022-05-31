package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "MembershipNumber", nullable = false)
    private String membershipNumber;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="BirthDate")
    private LocalDate birthDate;

    @Column(name= "Gender")
    private String gender;

    @Column(name="Phone")
    private String phone;

    @Column(name="Address")
    private String address;

    @Column(name="MembershipExpireDate")
    private LocalDate membershipExpireDate;



    public String getFullName(){
        return String.format("%s %s ", firstName, lastName);
    }

    public Customer(String membershipNumber, String firstName, String lastName, LocalDate birthDate, String gender, String phone, String address) {
        this.membershipNumber = membershipNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.membershipExpireDate = LocalDate.now().plusYears(5);
    }



}
