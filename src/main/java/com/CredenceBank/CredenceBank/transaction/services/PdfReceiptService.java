package com.CredenceBank.CredenceBank.transaction.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfReceiptService {

    public ByteArrayInputStream generateReceipt(
            String senderAccount,
            String receiverAccount,
            Double amount,
            String transactionId
    ) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);

            document.open();

            Font titleFont = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    20
            );

            Font bodyFont = FontFactory.getFont(
                    FontFactory.HELVETICA,
                    14
            );

            Paragraph title = new Paragraph(
                    "Transaction Receipt",
                    titleFont
            );

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);

            document.add(Chunk.NEWLINE);

            document.add(new Paragraph(
                    "Transaction ID: " + transactionId,
                    bodyFont
            ));

            document.add(new Paragraph(
                    "Sender Account: " + senderAccount,
                    bodyFont
            ));

            document.add(new Paragraph(
                    "Receiver Account: " + receiverAccount,
                    bodyFont
            ));

            document.add(new Paragraph(
                    "Amount: INR " + amount,
                    bodyFont
            ));

            document.add(Chunk.NEWLINE);

            Paragraph success = new Paragraph(
                    "Transaction completed successfully.",
                    bodyFont
            );

            success.setAlignment(Element.ALIGN_CENTER);

            document.add(success);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}