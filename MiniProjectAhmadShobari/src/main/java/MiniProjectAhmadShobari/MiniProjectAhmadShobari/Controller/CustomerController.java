package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Controller;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Customer.CustomerUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping("find-all")
    public List<CustomerDto> findAllDto(){
        return customerService.findAllCustomer();
    }

    @PostMapping("insert")
    public ResponseEntity<List<CustomerDto>> insertNewCustomer (@RequestBody CustomerInsertDto customerInsertDto){
        return  ResponseEntity.ok().body(
                customerService.insertCustomer(customerInsertDto));
    }

    @PutMapping("{membershipNumber}")
    public boolean updateCustomer(@PathVariable String membershipNumber, @RequestBody CustomerUpdateDto customerUpdateDto){
        return customerService.updateCustomer(membershipNumber, customerUpdateDto);
    }

    @DeleteMapping("{membershipNumber}")
    public boolean delete(@PathVariable String membershipNumber){
        return customerService.deleteCustomerById(membershipNumber);
    }

    @GetMapping("nameCustomer")
    public List<CustomerDto> findAllCustomerByName (@RequestParam String nameCustomer){
        return  customerService.findAllCustomerByName(nameCustomer);
    }


}
