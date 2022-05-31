package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Model.Loan;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class LoanDto {
    private final Long id;
    private final String customerNumber;
    private final String bookCode;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private final LocalDate returnDate;
    private final String note;

    public static LoanDto set (Loan loan){
        return new LoanDto(
                loan.getId(),
                loan.getCustomerNumber().getMembershipNumber(),
                loan.getBookCode().getCode(),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getReturnDate(),
                loan.getNote());
    }

    public static List<LoanDto> toList(List<Loan> loanList){
        List<LoanDto> result = new ArrayList<>();
        for (Loan loan : loanList){
            result.add(set(loan));
        }
        return result;
    }
}
