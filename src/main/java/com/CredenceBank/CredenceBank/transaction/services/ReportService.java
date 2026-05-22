package com.CredenceBank.CredenceBank.transaction.services;



import com.CredenceBank.CredenceBank.transaction.entity.Transaction;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportService {

    public ByteArrayInputStream generateTransactionReport(
            List<Transaction> transactions
    ) {

        Document document = new Document();

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);

            document.open();

            Font titleFont = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    22
            );

            Paragraph title = new Paragraph(
                    "Credence Bank Transaction Report",
                    titleFont
            );

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(6);

            table.setWidthPercentage(100);

            table.setWidths(new int[]{3, 3, 2, 2, 3 , 3});

            Font headFont = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD
            );

            table.addCell(new PdfPCell(new Phrase("Date", headFont)));
            table.addCell(new PdfPCell(new Phrase("Type", headFont)));
            table.addCell(new PdfPCell(new Phrase("Amount", headFont)));
            table.addCell(new PdfPCell(new Phrase("Status", headFont)));
            table.addCell(new PdfPCell(new Phrase("From Account", headFont)));
            table.addCell(new PdfPCell(new Phrase("To Account", headFont)));

            for (Transaction tx : transactions) {

                table.addCell(
                        tx.getTransactionDate().toString()
                );

                table.addCell(
                        tx.getTransactionType().toString()
                );

                table.addCell(
                        String.valueOf(tx.getAmount())
                );

                table.addCell(
                        tx.getStatus().toString()
                );

                table.addCell(
                        tx.getSourceAccount() != null
                                ? tx.getSourceAccount()
                                : "N/A"
                );

                table.addCell(
                        tx.getDestinationAccount() != null
                                ? tx.getDestinationAccount()
                                : "N/A"
                );
            }

            document.add(table);

            document.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return new ByteArrayInputStream(
                out.toByteArray()
        );
    }
}

