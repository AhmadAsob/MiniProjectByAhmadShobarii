package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Loan;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.BookRepositories;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.CustomerRepositories;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Repositories.LoanRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private BookRepositories bookRepositories;
    private CustomerRepositories customerRepositories;
    private LoanRepositories loanRepositories;

    @Autowired
    public LoanService(BookRepositories bookRepositories, CustomerRepositories customerRepositories, LoanRepositories loanRepositories){
        this.bookRepositories = bookRepositories;
        this.customerRepositories = customerRepositories;
        this.loanRepositories = loanRepositories;
    }

    public List<LoanDto> findAllLoan(){

        List<Loan> loanList = loanRepositories.findAll();
        List<LoanDto> result = loanList.stream()
                .map(loan -> new LoanDto(
                        loan.getId(),
                        loan.getCustomerNumber().getMembershipNumber(),
                        loan.getBookCode().getCode(),
                        loan.getLoanDate(),
                        loan.getDueDate(),
                        loan.getReturnDate(),
                        loan.getNote()))
                .collect(Collectors.toList());
        return result;
    }

    public List<LoanDto> insertLoan(LoanInsertDto newLoan){
        Customer customer = customerRepositories.findById(newLoan.getCustomerNumber()).orElseThrow(()-> new EntityNotFoundException("Customer Tidak Ditemukan"));
        Book book = bookRepositories.findById(newLoan.getBookCode()).orElseThrow(()-> new EntityNotFoundException("Buku Tidak Ditemukan"));
        Loan loan = newLoan.convertLoan(customer, book);
        loanRepositories.save(loan);
        return LoanDto.toList(loanRepositories.findAll());
    }

    public boolean updateLoan(Long id, LoanUpdateDto loanUpdateDto){
        boolean result = false;
        Customer customer = customerRepositories.findById(loanUpdateDto.getCustomerNumber()).orElseThrow(()-> new EntityNotFoundException("Customer Tidak Ditemukan"));
        Book book = bookRepositories.findById(loanUpdateDto.getBookCode()).orElseThrow(()-> new EntityNotFoundException("Buku Tidak Ditemukan"));
        Loan oldLoan = loanRepositories.getById(id);

        customer.setMembershipNumber(loanUpdateDto.getCustomerNumber());
        book.setCode(loanUpdateDto.getBookCode());
        oldLoan.setLoanDate(loanUpdateDto.getLoanDate());
        oldLoan.setDueDate(loanUpdateDto.getDueDate());
        oldLoan.setReturnDate(loanUpdateDto.getReturnDate());
        oldLoan.setNote(loanUpdateDto.getNote());

        loanRepositories.save(oldLoan);

        return true;

    }

    public boolean deleteBookById (Long id){
        loanRepositories.deleteById(id);
        return true;
    }

    public List<LoanDto> findAllLoanByCustomerNumber (String number){
        return LoanDto.toList(loanRepositories.getNumber(number));
    }

    public List<LoanDto> findAllLoanByBookCode (String code){
        return LoanDto.toList(loanRepositories.getCode(code));
    }
}
