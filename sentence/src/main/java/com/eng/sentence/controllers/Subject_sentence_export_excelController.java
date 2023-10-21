
package com.eng.sentence.controllers;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.eng.sentence.domain.models.SubjectSentence;
import com.eng.sentence.domain.services.SubjectSentenceService;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@Controller
public class Subject_sentence_export_excelController {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
 	private SubjectSentenceService subject_sentenceService;
    
    @GetMapping("/subject_sentence_export_excel")
	public String subject_sentence_export_excel() {
	    return "subject_sentence_export_excel";
	}
	
	@GetMapping("/subject_sentence_export_excel-content")
	public String subject_sentence_export_excelcontent() {
	    return "subject_sentence_export_excel-content";
	}
    /*
     * This code uses the Apache POI library to write data to an Excel file. In order to ensure that Chinese characters will not appear garbled, we set the MIME type of the file to that of the Excel file to ensure correct character encoding.
     * Note: If you have not used the Apache POI library or the version is earlier, you may need to make slight adjustments based on the actual situation.
     */
    @GetMapping("/exportEXCEL")
    public void exportEXCEL(HttpServletResponse response) {
        List<SubjectSentence> subjectSentences = subject_sentenceService.getSubjectSentences();

        try (Workbook workbook = new XSSFWorkbook(); 
             OutputStream os = response.getOutputStream()) {
            Sheet sheet = workbook.createSheet("SubjectSentences");

            // Header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {
                    "id", "situation", "event", "sentence_type", "subject_01", "verb_01",
                    "noun_01", "preposition_02", "clause_01", "full_sentence", "traditional_chinese"
            };
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
            }

            // Populate data rows
            int rowIdx = 1;
            for (SubjectSentence ss : subjectSentences) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(ss.getSubjectSentenceId());
                row.createCell(1).setCellValue(ss.getSituation());
                row.createCell(2).setCellValue(ss.getEvent());
                row.createCell(3).setCellValue(ss.getSentenceType());
                row.createCell(4).setCellValue(ss.getSubject01());
                row.createCell(5).setCellValue(ss.getVerb01());
                row.createCell(6).setCellValue(ss.getNoun01());
                row.createCell(7).setCellValue(ss.getPreposition02());
                row.createCell(8).setCellValue(ss.getClause01());
                row.createCell(9).setCellValue(ss.getFullSentence());
                row.createCell(10).setCellValue(ss.getTraditionalChinese());
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=\"subjectSentences.xlsx\"");
            workbook.write(os);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error writing Excel data", e);
        }
    }
}
