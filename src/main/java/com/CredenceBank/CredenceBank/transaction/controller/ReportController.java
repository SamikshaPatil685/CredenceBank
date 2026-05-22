package com.CredenceBank.CredenceBank.transaction.controller;

import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.auth_Users.repo.UserRepo;
import com.CredenceBank.CredenceBank.transaction.entity.Transaction;
import com.CredenceBank.CredenceBank.transaction.repo.TransactionRepo;
import com.CredenceBank.CredenceBank.transaction.services.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<byte[]> downloadTransactionReport(
            @PathVariable String accountNumber,
            Authentication authentication
    ) {

        try {

            // Logged-in user
            User currentUser =
                    userRepo.findByEmail(authentication.getName())
                            .orElseThrow(() ->
                                    new RuntimeException("User not found"));

            // Check ADMIN or AUDITOR
            boolean isAdmin =
                    currentUser.getRoles().stream()
                            .anyMatch(role ->
                                    role.getName().equals("ADMIN")
                                            || role.getName().equals("AUDITOR"));

            // CUSTOMER validation
            boolean ownsAccount =
                    currentUser.getAccounts().stream()
                            .anyMatch(acc ->
                                    acc.getAccountNumber()
                                            .equals(accountNumber));

            // If customer tries another account
            if (!isAdmin && !ownsAccount) {

                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .build();
            }

            // Fetch ONLY selected account transactions
            List<Transaction> transactions =
                    transactionRepository
                            .findBySourceAccountOrDestinationAccount(
                                    accountNumber,
                                    accountNumber
                            );

            // Generate PDF
            ByteArrayInputStream pdf =
                    reportService.generateTransactionReport(
                            transactions
                    );

            HttpHeaders headers = new HttpHeaders();

            headers.add(
                    "Content-Disposition",
                    "attachment; filename=transaction_report.pdf"
            );

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf.readAllBytes());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .build();
        }
    }
}