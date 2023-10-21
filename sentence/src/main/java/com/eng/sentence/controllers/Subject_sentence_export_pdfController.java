
package com.eng.sentence.controllers;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.eng.sentence.domain.models.SubjectSentence;
import com.eng.sentence.domain.services.SubjectSentenceService;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


@Controller
public class Subject_sentence_export_pdfController {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private SubjectSentenceService subject_sentenceService;

    @GetMapping("/subject_sentence_export_pdf")
    public String subject_sentence_export_pdf() {
        return "subject_sentence_export_pdf";
    }

    @GetMapping("/subject_sentence_export_pdf-content")
    public String subject_sentence_export_pdfcontent() {
        return "subject_sentence_export_pdf-content";
    }
    
    
    public String getFontPath() {
        String os = System.getProperty("os.name").toLowerCase();

        String[] possiblePaths;

        if (os.contains("win")) {
            // Windows 7/10/11 font path
            possiblePaths = new String[]{
                "C:\\Windows\\Fonts\\STSONG.TTF",
                "C:\\WINNT\\Fonts\\STSONG.TTF"
            };
        } else if (os.contains("mac")) {
            // macOS font path
            possiblePaths = new String[]{
                "/Library/Fonts/STSONG.TTF",
                "/System/Library/Fonts/STSONG.TTF"
            };
        } else if (os.contains("nix") || os.contains("nux") || os.contains("sunos")) {
            // Linux (and Unix-like) font paths
            possiblePaths = new String[]{
                "/usr/share/fonts/truetype/STSONG.TTF",
                "/usr/share/fonts/ttf/STSONG.TTF",
                "/usr/share/fonts/TTF/STSONG.TTF"
            };
        } else {
            // Unsupported OS
            return null;
        }

        for (String path : possiblePaths) {
            java.io.File fontFile = new java.io.File(path);
            if (fontFile.exists()) {
                return path;
            }
        }

        return null; // Font file not found in any of the expected locations
    }
    @GetMapping("/exportPDF")
    public void ExportPDF(HttpServletResponse response) {
        Document document = new Document();
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"subjectSentences.pdf\"");

            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            String fontPath = getFontPath();
            if (fontPath == null) {
                throw new RuntimeException("Arial Unicode MS font not found in expected locations!");
            }

            // Use a Font that supports Chinese characters
            BaseFont bfChinese = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font chineseFont = new Font(bfChinese, 12, Font.NORMAL);


            PdfPTable table = new PdfPTable(11); // 11 columns
            table.setWidthPercentage(100);
            String[] headers = {"id", "situation", "event", "sentence_type", "subject_01", "verb_01", "noun_01", "preposition_02", "clause_01", "full_sentence", "traditional_chinese"};

            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, chineseFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            List<SubjectSentence> subjectSentences = subject_sentenceService.getSubjectSentences();
            for (SubjectSentence ss : subjectSentences) {
                table.addCell(new PdfPCell(new Phrase(ss.getSubjectSentenceId(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getSituation(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getEvent(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getSentenceType(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getSubject01(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getVerb01(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getNoun01(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getPreposition02(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getClause01(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getFullSentence(), chineseFont)));
                table.addCell(new PdfPCell(new Phrase(ss.getTraditionalChinese(), chineseFont)));
            }

            document.add(table);

            document.close();

        } catch (DocumentException | IOException e) {
            logger.log(Level.SEVERE, "Error writing PDF data", e);
        }
    }
}
