
package com.eng.sentence.controllers;

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

@Controller
public class Subject_sentence_export_csvController {
	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());
	 // need to inject our subject_sentence service
 	@Autowired
 	private SubjectSentenceService subject_sentenceService;
	@GetMapping("/subject_sentence_export_csv")
	public String subject_sentence_export_csv() {
	    return "subject_sentence_export_csv";
	}
	
	@GetMapping("/subject_sentence_export_csv-content")
	public String subject_sentence_export_csvcontent() {
	    return "subject_sentence_export_csv-content";
	}

	@GetMapping("/exportCSV")
	public void ExportCSV(HttpServletResponse response) {
	    List<SubjectSentence> subjectSentences = subject_sentenceService.getSubjectSentences();
	    /*
	     * To prevent the exported CSV file from having garbled Chinese characters, you should specify the charset as "UTF-8" when setting the content type for the response.
	     */
	    response.setContentType("text/csv; charset=UTF-8");
	    response.setHeader("Content-Disposition", "attachment; filename=\"subjectSentences.csv\"");
	     
	    try(PrintWriter writer = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"))) {
	        // Adding BOM for UTF-8 files
	        writer.print("\uFEFF");
	        
	        // CSV header
	        writer.println("id,situation,event,sentence_type,subject_01,verb_01,noun_01,preposition_02,clause_01,full_sentence,traditional_chinese");  // replace with your actual fields
	        
	        // Write subjectSentences to CSV
	        for(SubjectSentence ss : subjectSentences) {
	            writer.println(SubjectSentenceColumnExport(ss));  // adjust based on the actual methods of SubjectSentence
	        }
	    } catch (Exception e) {
	        logger.log(Level.SEVERE, "Error writing CSV data", e);
	    }
	}
    
    public String SubjectSentenceColumnExport(SubjectSentence ss) {
    	StringBuilder csvLine=new StringBuilder();
    	csvLine=CsvLineAppend(csvLine,ss.getSubjectSentenceId());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSituation());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getEvent());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSentenceType());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSubject01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getVerb01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getNoun01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getPreposition02());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getClause01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getFullSentence());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getTraditionalChinese());
    	return csvLine.toString();
    }
    public StringBuilder CsvLineAppend(StringBuilder csvLine,String value) {
    	if (value.equals(",")) {
    		csvLine.append(",");
    	}
    	else if (value.indexOf(",")>-1) {
    		csvLine.append("\""+value+"\"");
    	}else {
    		csvLine.append(value);
    	}
    	return csvLine;
    }
    
    public String AllColumnExport(SubjectSentence ss) {
    	StringBuilder csvLine=new StringBuilder();
    	csvLine=CsvLineAppend(csvLine,ss.getSubjectSentenceId());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSituation());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getEvent());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSentenceType());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getArticle01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getSubject01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getConjunction01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getAdverb01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getAuxiliaryVerb01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getVerb01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getInfinitive01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getConjunction02());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getAdverb02());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getPreposition01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getPronoun01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getArticle02());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getAdjective01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getNoun01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getNounPhase01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getGerund01());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getPreposition02());
    	csvLine=CsvLineAppend(csvLine,",");
    	csvLine=CsvLineAppend(csvLine,ss.getClause01());
    	return csvLine.toString();
    }
}
