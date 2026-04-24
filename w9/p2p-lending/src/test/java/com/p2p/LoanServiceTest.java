package com.p2p;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import com.p2p.service.LoanService;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================
        logger.info("=== TC-01 START ===");
        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        logger.info("Borrower dibuat: verified=false, creditScore=700");
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);
        logger.info("Amount = 1000");
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
        logger.info("TC-01 PASSED: Exception berhasil ditangkap");
    }

    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative(){
        //Skenario:
        //  - Borrower valid
        //  - Amount ≤ 0
        //Expected:
        //  - Exception

        logger.info("=== TC-02 START ===");
        Borrower borrower = new Borrower(true, 700);
        logger.info("Borrower dibuat: verified=True, creditScore=700");

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(-1);
        logger.info("Amount = -1");

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        logger.info("TC-02 PASSED: Exception berhasil ditangkap");
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
        //Skenario:
        //  - Borrower verified
        //  - Credit score ≥ threshold
        //Expected:
        //  - Status = APPROVED

        logger.info("=== TC-03 START ===");
        Borrower borrower = new Borrower(true, 700);
        logger.info("Borrower dibuat: verified=True, creditScore=700 >= treshold");

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(100);
        logger.info("Amount = 100");

        Loan loan = loanService.createLoan(borrower, amount);
        
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
        logger.info("TC-03 PASSED: Status loan = APPROVED");
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow(){
        //Skenario:
        //  - Borrower verified
        //  - Credit score < threshold
        //Expected:
        //  - Status = REJECTED

        logger.info("=== TC-04 START ===");
        Borrower borrower = new Borrower(true, 500);
        logger.info("Borrower dibuat: verified=True, creditScore=500 < treshold");

        LoanService loanService = new LoanService();

        BigDecimal amount = BigDecimal.valueOf(100);
        logger.info("Amount = 100");

        Loan loan = loanService.createLoan(borrower, amount);
        
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
        logger.info("TC-04 PASSED: Status loan = REJECTED");  
    }
}