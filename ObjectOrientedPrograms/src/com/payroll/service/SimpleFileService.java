package com.payroll.service;

import com.payroll.model.FinalPayslip;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileService {

    public String savePayslipAsText(FinalPayslip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".txt";
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(payslip.toString());
        }
        return fileName;
    }

    public String savePayslipAsPdf(FinalPayslip payslip) throws IOException {
        String fileName = "Payslip_" + payslip.getEmpId() + "_" + System.currentTimeMillis() + ".pdf";
        try (java.io.FileOutputStream out = new java.io.FileOutputStream(fileName)) {
            String content = payslip.toString();
            byte[] bytes = createSimplePdf(content);
            out.write(bytes);
        }
        return fileName;
    }

    private byte[] createSimplePdf(String content) {
        String pdfHeader = "%PDF-1.4\n";
        String body = "1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n" +
                "2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n" +
                "3 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R /Resources << /Font << /F1 5 0 R >> >> >>\nendobj\n" +
                "4 0 obj\n<< /Length " + (content.length() + 80) + " >>\nstream\nBT /F1 12 Tf 50 720 Td (" + escapePdf(content) + ") Tj ET\nendstream\nendobj\n" +
                "5 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\nendobj\n";
        String xref = "xref\n0 6\n0000000000 65535 f \n" +
                String.format("0000000010 00000 n \n0000000065 00000 n \n0000000123 00000 n \n0000000211 00000 n \n0000000326 00000 n \n") +
                "trailer\n<< /Size 6 /Root 1 0 R >>\nstartxref\n400\n%%EOF";
        return (pdfHeader + body + xref).getBytes(java.nio.charset.StandardCharsets.ISO_8859_1);
    }

    private String escapePdf(String text) {
        return text.replace("\\", "\\\\").replace("(", "\\(").replace(")", "\\)").replace("\n", "\\n");
    }
}

