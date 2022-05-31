package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanUpdateDto {

    private String customerNumber;
    private String bookCode;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String note;
}
