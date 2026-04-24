package com.p2p.service;
import com.p2p.domain.*;
import java.math.BigDecimal;
public class LoanService {
    public Loan createLoan(Borrower borrower, BigDecimal amount){
        // =========================
        // VALIDASI UTAMA (TC-01)
        // =========================
        // Jika borrower belum terverifikasi,
        // maka proses harus dihentikan
        validateBorrower(borrower);
        validateAmount(amount);
        // Membuat objek loan baru
        Loan loan = new Loan();
        // =========================
        // LOGIC SEDERHANA (sementara)
        // =========================
        // Jika credit score tinggi → APPROVED
        // Jika tidak → REJECTED
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }
        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount not verified");
        }
    }
}