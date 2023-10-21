package com.eng.sentence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Logger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.services.SubjectSentenceService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
@Controller
public class Subject_sentence_uploadController {
    // set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());
    
 // need to inject our subject_sentence service
 	@Autowired
 	private SubjectSentenceService subject_sentenceService;

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/subject_sentence";

    @GetMapping("/subject_sentence_upload")
    public String subject_sentence_upload() {
        return "subject_sentence_upload";
    }

    @GetMapping("/subject_sentence_upload-content")
    public String subject_sentence_uploadcontent() {
        return "subject_sentence_upload-content";
    }

    @PostMapping("/uploadCSV")
    public String uploadCSV(@RequestParam("csvFile") MultipartFile file,Model model,RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            // Handle empty file scenario
            return "redirect:/subject_sentence_upload-content";
        }

        try {
            // Save the uploaded file to the specified directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);

            // Load and print the CSV content
            List<SubjectSentence> subjectSentences=readAndPrintCSV(path);
            
            for(int i=0;i<subjectSentences.size();i++) {
            	if(subjectSentences.get(i).getFullSentence()!=null) {
	            	List<SubjectSentence> results=subject_sentenceService.findByFullSentence(subjectSentences.get(i).getFullSentence().trim());
	            	if (results==null) {
	            		subject_sentenceService.saveSubjectSentence(subjectSentences.get(i));
	                }else if (results.size()==0) {
	                	subject_sentenceService.saveSubjectSentence(subjectSentences.get(i));
	            	}
            	}
            }
        } catch (IOException e) {
            logger.severe("Failed to upload file: " + e.getMessage());
        }
        redirectAttributes.addFlashAttribute("success", true);
        //model.addAttribute("success", true);
        return "redirect:/subject_sentence_upload";
    }
	
	private List<SubjectSentence> readAndPrintCSV(Path filePath) throws IOException {
	    FileReader in = new FileReader(filePath.toFile());
	    Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
	    List<SubjectSentence> subjectSentences = new ArrayList<SubjectSentence>();
	    
	    for (CSVRecord record : records) {
	        SubjectSentence subjectSentence = new SubjectSentence();
	        for (String header : record.toMap().keySet()) {
	            String value = record.get(header).trim();
	            logger.info(header + ": " + value);
	            switch (header) {
	                case "situation":
	                    subjectSentence.setSituation(value);
	                    break;
	                case "event":
	                    subjectSentence.setEvent(value);
	                    break;
	                case "sentence_type":
	                    subjectSentence.setSentenceType(value);
	                    break;
	                case "subject_01":
	                    subjectSentence.setSubject01(value);
	                    break;
	                case "verb_01":
	                    subjectSentence.setVerb01(value);
	                    break;
	                case "noun_01":
	                    subjectSentence.setNoun01(value);
	                    break;
	                case "preposition_02":
	                    subjectSentence.setPreposition02(value);
	                    break;
	                case "clause_01":
	                    subjectSentence.setClause01(value);
	                    break;
	                case "full_sentence":
	                    subjectSentence.setFullSentence(value);
	                    break;
	                case "traditional_chinese":
	                    subjectSentence.setTraditionalChinese(value);
	                    break;
	            }
	        }
	        subjectSentences.add(subjectSentence);
	        logger.info("----------");
	    }
	    return subjectSentences;
	}
}
