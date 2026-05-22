package com.CredenceBank.CredenceBank.transaction.controller;


import com.CredenceBank.CredenceBank.res.Response;
import com.CredenceBank.CredenceBank.transaction.dtos.TransactionRequest;
import com.CredenceBank.CredenceBank.transaction.services.PdfReceiptService;
import com.CredenceBank.CredenceBank.transaction.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final PdfReceiptService pdfReceiptService;

    @PostMapping
    public ResponseEntity<Response<?>> createTransaction(@RequestBody @Valid TransactionRequest request) {
        return ResponseEntity.ok(transactionService.createTransaction(request));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Response<?>> getTransactionsForMyAccount(
            @PathVariable String accountNumber,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        return ResponseEntity.ok(transactionService.getTransactionsForMyAccount(accountNumber, page, size));
    }

    // For PdfReceiptService
    @GetMapping("/receipt")
    public ResponseEntity<byte[]> downloadReceipt(

            @RequestParam String senderAccount,
            @RequestParam String receiverAccount,
            @RequestParam Double amount,
            @RequestParam String transactionId

    ) throws IOException {

        ByteArrayInputStream pdf = pdfReceiptService.generateReceipt(
                senderAccount,
                receiverAccount,
                amount,
                transactionId
        );

        HttpHeaders headers = new HttpHeaders();

        headers.add(
                "Content-Disposition",
                "attachment; filename=transaction_receipt.pdf"
        );

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }

}
