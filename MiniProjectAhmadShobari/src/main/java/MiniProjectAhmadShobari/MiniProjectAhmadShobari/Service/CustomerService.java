package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService{

    private CustomerRepositories customerRepositories;

    @Autowired
    public CustomerService(CustomerRepositories customerRepositories){this.customerRepositories = customerRepositories;}

    public List<CustomerDto> findAllCustomer(){
        return CustomerDto.toList(customerRepositories.findAll());
    }

    public List<CustomerDto> insertCustomer(CustomerInsertDto customerInsertDto){
        Customer customer = customerInsertDto.convertCustomer();
        customerRepositories.save(customer);
        return CustomerDto.toList(customerRepositories.findAll());
    }

    public boolean updateCustomer(String membershipNumber, CustomerUpdateDto customerUpdateDto){
        boolean result = false;
        Customer oldcustomer = customerRepositories.getById(membershipNumber);

        oldcustomer.setFirstName(customerUpdateDto.getFirstName());
        oldcustomer.setLastName(customerUpdateDto.getLastName());
        oldcustomer.setBirthDate(customerUpdateDto.getBirthDate());
        oldcustomer.setGender(customerUpdateDto.getGender());
        oldcustomer.setPhone(customerUpdateDto.getPhone());
        oldcustomer.setAddress(customerUpdateDto.getAddress());

        customerRepositories.save(oldcustomer);

        return true;
    }

    public boolean deleteCustomerById (String membershipNumber){
        customerRepositories.deleteById(membershipNumber);
        return true;
    }

    public List<CustomerDto> findAllCustomerByName(String nameCustomer){
        return CustomerDto.toList(customerRepositories.getNameCustomer(nameCustomer));
    }
}
