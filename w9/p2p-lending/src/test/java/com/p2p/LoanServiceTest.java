package com.p2p;

import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class LoanServiceTest {
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================
        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);
        // =========================
        // Act (Action)
        // =========================
        // Borrower mencoba mengajukan loan
        // =========================
        // Assert (Expected Result)
        // =========================
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative(){
        //Skenario:
        //  - Borrower valid
        //  - Amount ≤ 0
        //Expected:
        //  - Exception

        Borrower borrower = new Borrower(true, 700);

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(-1);

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
        //Skenario:
        //  - Borrower verified
        //  - Credit score ≥ threshold
        //Expected:
        //  - Status = APPROVED

        Borrower borrower = new Borrower(true, 700);

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(100);

        Loan loan = loanService.createLoan(borrower, amount);
        
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow(){
        //Skenario:
        //  - Borrower verified
        //  - Credit score < threshold
        //Expected:
        //  - Status = REJECTED

        Borrower borrower = new Borrower(true, 500);

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(100);

        Loan loan = loanService.createLoan(borrower, amount);
        
        assertEquals(Loan.Status.REJECTED, loan.getStatus());        
    }
}