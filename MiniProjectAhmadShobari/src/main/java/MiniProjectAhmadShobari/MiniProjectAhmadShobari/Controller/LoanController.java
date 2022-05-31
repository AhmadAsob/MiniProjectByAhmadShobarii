package MiniProjectAhmadShobari.MiniProjectAhmadShobari.Controller;

import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanInsertDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Dto.Loan.LoanUpdateDto;
import MiniProjectAhmadShobari.MiniProjectAhmadShobari.Service.LoanService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService){this.loanService = loanService;}

    @GetMapping("find-all")
    public List<LoanDto> findAllLoan(){
        return loanService.findAllLoan();
    }

    @PostMapping("insert")
    public ResponseEntity<List<LoanDto>> insertNewLoan(@RequestBody LoanInsertDto loanDto){
        return ResponseEntity.ok().body(
                loanService.insertLoan(loanDto));
    }

    @PutMapping("{id}")
    public boolean updateLoan(@PathVariable Long id, @RequestBody LoanUpdateDto loanUpdateDto){
        return loanService.updateLoan(id, loanUpdateDto);
    }

    @DeleteMapping("{id}")
    public boolean deleteLoan(@PathVariable Long id){
        return loanService.deleteBookById(id);
    }

    @GetMapping("number")
    public List<LoanDto> findAllLoanByNumber (@RequestParam String number){
        return loanService.findAllLoanByCustomerNumber(number);
    }

    @GetMapping("code")
    public List<LoanDto> findAllLoanByCode (@RequestParam String code){
        return loanService.findAllLoanByBookCode(code);
    }
}
