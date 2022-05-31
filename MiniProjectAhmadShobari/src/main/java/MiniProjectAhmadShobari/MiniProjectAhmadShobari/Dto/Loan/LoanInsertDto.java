package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Book;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Customer;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Loan;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanInsertDto {

    private String customerNumber;
    private String bookCode;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String note;

    public Loan convertLoan(Customer customer, Book book){
        return new Loan(
                customer,
                book,
                loanDate,
                dueDate,
                returnDate,
                note);
    }
}
