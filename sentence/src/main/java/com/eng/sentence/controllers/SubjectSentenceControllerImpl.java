package com.eng.sentence.controllers;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.util.FileUtil;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import org.springframework.http.HttpHeaders;

import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.models.data.ImageObject;
import com.eng.sentence.domain.models.data.PageSession;
import com.eng.sentence.domain.models.data.Session;
import com.eng.sentence.domain.models.data.TableFieldCollection;
import com.eng.sentence.domain.services.*;
import com.eng.sentence.domain.services.session.SessionManager;
import com.eng.sentence.domain.utils.*;
import com.eng.sentence.domain.utils.web.*;
import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.utils.BcryptPasswordVerifier;
import com.eng.sentence.domain.utils.JsonUtil;
import com.eng.sentence.domain.utils.web.WebResponseUtil;
import com.eng.sentence.config.ApplicationProperties;
import com.eng.sentence.config.JwtUtil;
import org.json.JSONObject;

@Controller
@RequestMapping("/subject_sentence")
public class SubjectSentenceControllerImpl implements SubjectSentenceController{
	@Autowired
	private JwtUtil jwtUtil;
	// need to inject our DatabaseTableService
	@Autowired
	private DatabaseTableService databaseTableService;
	
	// need to inject our ApplicationProperties
	@Autowired
	private ApplicationProperties applicationProperties;
	
	// need to inject our subject_sentence service
	@Autowired
	private SubjectSentenceService subject_sentenceService;
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> create(MultipartHttpServletRequest request){
		
		SubjectSentence subject_sentence=new SubjectSentence();
		
		subject_sentence.setSituation(WebRequestUtil.Request(request).setRequestParameter("situation").toStr());
		subject_sentence.setEvent(WebRequestUtil.Request(request).setRequestParameter("event").toStr());
		subject_sentence.setSentenceType(WebRequestUtil.Request(request).setRequestParameter("sentence_type").toStr());
		subject_sentence.setArticle01(WebRequestUtil.Request(request).setRequestParameter("article_01").toStr());
		subject_sentence.setSubject01(WebRequestUtil.Request(request).setRequestParameter("subject_01").toStr());
		subject_sentence.setConjunction01(WebRequestUtil.Request(request).setRequestParameter("conjunction_01").toStr());
		subject_sentence.setAdverb01(WebRequestUtil.Request(request).setRequestParameter("adverb_01").toStr());
		subject_sentence.setAuxiliaryVerb01(WebRequestUtil.Request(request).setRequestParameter("auxiliary_verb_01").toStr());
		subject_sentence.setVerb01(WebRequestUtil.Request(request).setRequestParameter("verb_01").toStr());
		subject_sentence.setInfinitive01(WebRequestUtil.Request(request).setRequestParameter("infinitive_01").toStr());
		subject_sentence.setConjunction02(WebRequestUtil.Request(request).setRequestParameter("conjunction_02").toStr());
		subject_sentence.setAdverb02(WebRequestUtil.Request(request).setRequestParameter("adverb_02").toStr());
		subject_sentence.setPreposition01(WebRequestUtil.Request(request).setRequestParameter("preposition_01").toStr());
		subject_sentence.setPronoun01(WebRequestUtil.Request(request).setRequestParameter("pronoun_01").toStr());
		subject_sentence.setArticle02(WebRequestUtil.Request(request).setRequestParameter("article_02").toStr());
		subject_sentence.setAdjective01(WebRequestUtil.Request(request).setRequestParameter("adjective_01").toStr());
		subject_sentence.setNoun01(WebRequestUtil.Request(request).setRequestParameter("noun_01").toStr());
		subject_sentence.setNounPhase01(WebRequestUtil.Request(request).setRequestParameter("noun_phase_01").toStr());
		subject_sentence.setGerund01(WebRequestUtil.Request(request).setRequestParameter("gerund_01").toStr());
		subject_sentence.setPreposition02(WebRequestUtil.Request(request).setRequestParameter("preposition_02").toStr());
		subject_sentence.setClause01(WebRequestUtil.Request(request).setRequestParameter("clause_01").toStr());
		subject_sentence.setFullSentence(WebRequestUtil.Request(request).setRequestParameter("full_sentence").toStr());
		subject_sentence.setTraditionalChinese(WebRequestUtil.Request(request).setRequestParameter("traditional_chinese").toStr());
		// Perform the subject_sentence update logic here
		subject_sentence=subject_sentenceService.saveSubjectSentence(subject_sentence);
		String json=JsonUtil.ToJson(subject_sentence);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@Override
	@RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> get(MultipartHttpServletRequest request){
		
		SubjectSentence subject_sentence = subject_sentenceService.getSubjectSentence(WebRequestUtil.Request(request).setRequestParameter("subject_sentence_id").toStr());
		String json =JsonUtil.ToJson(subject_sentence);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@Override
	@GetMapping(value = "/retrieve", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> retrieve(MultipartHttpServletRequest request) {
		List<SubjectSentence> subject_sentences = subject_sentenceService.getSubjectSentences();
		String json =JsonUtil.ToJson(subject_sentences);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@Override
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> update(MultipartHttpServletRequest request){
		
		SubjectSentence subject_sentence = subject_sentenceService.getSubjectSentence(WebRequestUtil.Request(request).setRequestParameter("subject_sentence_id").toStr());
		if (subject_sentence != null) {
			
			subject_sentence.setSituation(WebRequestUtil.Request(request).setRequestParameter("situation").toStr());
			subject_sentence.setEvent(WebRequestUtil.Request(request).setRequestParameter("event").toStr());
			subject_sentence.setSentenceType(WebRequestUtil.Request(request).setRequestParameter("sentence_type").toStr());
			subject_sentence.setArticle01(WebRequestUtil.Request(request).setRequestParameter("article_01").toStr());
			subject_sentence.setSubject01(WebRequestUtil.Request(request).setRequestParameter("subject_01").toStr());
			subject_sentence.setConjunction01(WebRequestUtil.Request(request).setRequestParameter("conjunction_01").toStr());
			subject_sentence.setAdverb01(WebRequestUtil.Request(request).setRequestParameter("adverb_01").toStr());
			subject_sentence.setAuxiliaryVerb01(WebRequestUtil.Request(request).setRequestParameter("auxiliary_verb_01").toStr());
			subject_sentence.setVerb01(WebRequestUtil.Request(request).setRequestParameter("verb_01").toStr());
			subject_sentence.setInfinitive01(WebRequestUtil.Request(request).setRequestParameter("infinitive_01").toStr());
			subject_sentence.setConjunction02(WebRequestUtil.Request(request).setRequestParameter("conjunction_02").toStr());
			subject_sentence.setAdverb02(WebRequestUtil.Request(request).setRequestParameter("adverb_02").toStr());
			subject_sentence.setPreposition01(WebRequestUtil.Request(request).setRequestParameter("preposition_01").toStr());
			subject_sentence.setPronoun01(WebRequestUtil.Request(request).setRequestParameter("pronoun_01").toStr());
			subject_sentence.setArticle02(WebRequestUtil.Request(request).setRequestParameter("article_02").toStr());
			subject_sentence.setAdjective01(WebRequestUtil.Request(request).setRequestParameter("adjective_01").toStr());
			subject_sentence.setNoun01(WebRequestUtil.Request(request).setRequestParameter("noun_01").toStr());
			subject_sentence.setNounPhase01(WebRequestUtil.Request(request).setRequestParameter("noun_phase_01").toStr());
			subject_sentence.setGerund01(WebRequestUtil.Request(request).setRequestParameter("gerund_01").toStr());
			subject_sentence.setPreposition02(WebRequestUtil.Request(request).setRequestParameter("preposition_02").toStr());
			subject_sentence.setClause01(WebRequestUtil.Request(request).setRequestParameter("clause_01").toStr());
			subject_sentence.setFullSentence(WebRequestUtil.Request(request).setRequestParameter("full_sentence").toStr());
			subject_sentence.setTraditionalChinese(WebRequestUtil.Request(request).setRequestParameter("traditional_chinese").toStr());
			
			// Perform the subject_sentence update logic here
			subject_sentenceService.saveSubjectSentence(subject_sentence);
			
		}
		String json=JsonUtil.ToJson(subject_sentence);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> delete(MultipartHttpServletRequest request){
		
		SubjectSentence subject_sentence = subject_sentenceService.getSubjectSentence(WebRequestUtil.Request(request).setRequestParameter("subject_sentence_id").toStr());
		if (subject_sentence != null) {
			subject_sentenceService.deleteSubjectSentence(subject_sentence.getSubjectSentenceId());
		}
		String json="";
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@Override
	@PostMapping(value = "/filter",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> filter(HttpServletRequest request,@RequestBody WebRequestUtil.FilterRequestData requestData) {
		//The filter function should use HttpServletRequest instead of MultipartHttpServletRequest because we need to transfer JSON objects.
		List<SubjectSentence> subject_sentences =null;
		// Set the appropriate headers and return the response
		if(requestData!=null && applicationProperties.getFilterSqlEnable()) {
			TableFieldCollection tableFieldCollection=databaseTableService.getTableFieldType("MYSQL","subject_sentence");
			requestData=FilterFieldTypeConverter.FilterFieldToParamValue(requestData, tableFieldCollection,applicationProperties);
			subject_sentences=subject_sentenceService.filterSubjectSentence(requestData);
		}
		String json = JsonUtil.ToJson(subject_sentences);
		System.out.println(json);
		// Set the appropriate headers and return the response
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@RequestMapping(value = "/create-json", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> createSubjectSentence(MultipartHttpServletRequest request){
		SubjectSentence subject_sentence=new SubjectSentence();
		subject_sentence.setSituation(WebRequestUtil.Request(request).setRequestParameter("situation").toStr());
		subject_sentence.setEvent(WebRequestUtil.Request(request).setRequestParameter("event").toStr());
		subject_sentence.setSentenceType(WebRequestUtil.Request(request).setRequestParameter("sentence_type").toStr());
		subject_sentence.setArticle01(WebRequestUtil.Request(request).setRequestParameter("article_01").toStr());
		subject_sentence.setSubject01(WebRequestUtil.Request(request).setRequestParameter("subject_01").toStr());
		subject_sentence.setConjunction01(WebRequestUtil.Request(request).setRequestParameter("conjunction_01").toStr());
		subject_sentence.setAdverb01(WebRequestUtil.Request(request).setRequestParameter("adverb_01").toStr());
		subject_sentence.setAuxiliaryVerb01(WebRequestUtil.Request(request).setRequestParameter("auxiliary_verb_01").toStr());
		subject_sentence.setVerb01(WebRequestUtil.Request(request).setRequestParameter("verb_01").toStr());
		subject_sentence.setInfinitive01(WebRequestUtil.Request(request).setRequestParameter("infinitive_01").toStr());
		subject_sentence.setConjunction02(WebRequestUtil.Request(request).setRequestParameter("conjunction_02").toStr());
		subject_sentence.setAdverb02(WebRequestUtil.Request(request).setRequestParameter("adverb_02").toStr());
		subject_sentence.setPreposition01(WebRequestUtil.Request(request).setRequestParameter("preposition_01").toStr());
		subject_sentence.setPronoun01(WebRequestUtil.Request(request).setRequestParameter("pronoun_01").toStr());
		subject_sentence.setArticle02(WebRequestUtil.Request(request).setRequestParameter("article_02").toStr());
		subject_sentence.setAdjective01(WebRequestUtil.Request(request).setRequestParameter("adjective_01").toStr());
		subject_sentence.setNoun01(WebRequestUtil.Request(request).setRequestParameter("noun_01").toStr());
		subject_sentence.setNounPhase01(WebRequestUtil.Request(request).setRequestParameter("noun_phase_01").toStr());
		subject_sentence.setGerund01(WebRequestUtil.Request(request).setRequestParameter("gerund_01").toStr());
		subject_sentence.setPreposition02(WebRequestUtil.Request(request).setRequestParameter("preposition_02").toStr());
		subject_sentence.setClause01(WebRequestUtil.Request(request).setRequestParameter("clause_01").toStr());
		subject_sentence.setFullSentence(WebRequestUtil.Request(request).setRequestParameter("full_sentence").toStr());
		subject_sentence.setTraditionalChinese(WebRequestUtil.Request(request).setRequestParameter("traditional_chinese").toStr());
		
		// Perform the subject_sentence update logic here
		subject_sentence=subject_sentenceService.saveSubjectSentence(subject_sentence);
		String json=JsonUtil.ToJson(subject_sentence);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@GetMapping(value = "/retrieve-json")
	public ResponseEntity<String> retrieveSubjectSentences(MultipartHttpServletRequest request) {
		List<SubjectSentence> subject_sentences = subject_sentenceService.getSubjectSentences();
		String json =JsonUtil.ToJson(subject_sentences);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@RequestMapping(value = "/update-json", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<String> updateSubjectSentence(MultipartHttpServletRequest request){
		SubjectSentence subject_sentence = subject_sentenceService.getSubjectSentence(WebRequestUtil.Request(request).setRequestParameter("subject_sentence_id").toStr());
		if (subject_sentence != null) {
			subject_sentence.setSituation(WebRequestUtil.Request(request).setRequestParameter("situation").toStr());
			subject_sentence.setEvent(WebRequestUtil.Request(request).setRequestParameter("event").toStr());
			subject_sentence.setSentenceType(WebRequestUtil.Request(request).setRequestParameter("sentence_type").toStr());
			subject_sentence.setArticle01(WebRequestUtil.Request(request).setRequestParameter("article_01").toStr());
			subject_sentence.setSubject01(WebRequestUtil.Request(request).setRequestParameter("subject_01").toStr());
			subject_sentence.setConjunction01(WebRequestUtil.Request(request).setRequestParameter("conjunction_01").toStr());
			subject_sentence.setAdverb01(WebRequestUtil.Request(request).setRequestParameter("adverb_01").toStr());
			subject_sentence.setAuxiliaryVerb01(WebRequestUtil.Request(request).setRequestParameter("auxiliary_verb_01").toStr());
			subject_sentence.setVerb01(WebRequestUtil.Request(request).setRequestParameter("verb_01").toStr());
			subject_sentence.setInfinitive01(WebRequestUtil.Request(request).setRequestParameter("infinitive_01").toStr());
			subject_sentence.setConjunction02(WebRequestUtil.Request(request).setRequestParameter("conjunction_02").toStr());
			subject_sentence.setAdverb02(WebRequestUtil.Request(request).setRequestParameter("adverb_02").toStr());
			subject_sentence.setPreposition01(WebRequestUtil.Request(request).setRequestParameter("preposition_01").toStr());
			subject_sentence.setPronoun01(WebRequestUtil.Request(request).setRequestParameter("pronoun_01").toStr());
			subject_sentence.setArticle02(WebRequestUtil.Request(request).setRequestParameter("article_02").toStr());
			subject_sentence.setAdjective01(WebRequestUtil.Request(request).setRequestParameter("adjective_01").toStr());
			subject_sentence.setNoun01(WebRequestUtil.Request(request).setRequestParameter("noun_01").toStr());
			subject_sentence.setNounPhase01(WebRequestUtil.Request(request).setRequestParameter("noun_phase_01").toStr());
			subject_sentence.setGerund01(WebRequestUtil.Request(request).setRequestParameter("gerund_01").toStr());
			subject_sentence.setPreposition02(WebRequestUtil.Request(request).setRequestParameter("preposition_02").toStr());
			subject_sentence.setClause01(WebRequestUtil.Request(request).setRequestParameter("clause_01").toStr());
			subject_sentence.setFullSentence(WebRequestUtil.Request(request).setRequestParameter("full_sentence").toStr());
			subject_sentence.setTraditionalChinese(WebRequestUtil.Request(request).setRequestParameter("traditional_chinese").toStr());
			// Perform the subject_sentence update logic here
			subject_sentence=subject_sentenceService.saveSubjectSentence(subject_sentence);
			
		}
		String json=JsonUtil.ToJson(subject_sentence);
		System.out.println(json);
		return (new WebResponseUtil(jwtUtil,applicationProperties)).Response(request.getRequestURI(),request.getSession().getId(), "data", json);
	}
	
	@RequestMapping(value = "/delete-json", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = "application/json")
	public ResponseEntity<Void> deleteSubjectSentence(MultipartHttpServletRequest request) {
		SubjectSentence subject_sentence = subject_sentenceService.getSubjectSentence(WebRequestUtil.Request(request).setRequestParameter("subject_sentence_id").toStr());
		if (subject_sentence != null) {
			subject_sentenceService.deleteSubjectSentence(subject_sentence.getSubjectSentenceId());
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/subject_sentence-gridview-detail")
	public String subject_sentencegridviewdetail(Model theModel) {
		return "subject_sentence-gridview-detail";
	}
	
	@GetMapping("/subject_sentence-retrieve-jstl")
	public String listSubjectSentences(Model theModel) {
		// get subject_sentences from the service
		List<SubjectSentence> theSubjectSentences = subject_sentenceService.getSubjectSentences();
		// add the customers to the model
		theModel.addAttribute("SubjectSentences", theSubjectSentences);
		return "subject_sentence-retrieve-jstl";
	}
	@GetMapping("/create-jstl")
	public String createSubjectSentenceJstl(Model theModel) {
		// create model attribute to bind form data
		SubjectSentence subject_sentence = new SubjectSentence();
		theModel.addAttribute("SubjectSentence", subject_sentence);
		return "subject_sentence-update-jstl";
	}
	
	@PostMapping(value = "/save-jstl", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveSubjectSentenceJstl(
	@ModelAttribute("SubjectSentence") SubjectSentence subject_sentence
	) {
		// Save the subject_sentence using our service
		subject_sentenceService.saveSubjectSentence(subject_sentence);
		return "redirect:/subject_sentence/subject_sentence-retrieve-jstl";
	}
	
	@GetMapping("/update-jstl")
	public String updateSubjectSentenceJstl(
	Model theModel
	,
	@RequestParam("subject_sentence_id") String subject_sentence_id
	) {
		SubjectSentence subject_sentence = null;
		// get the subject_sentence from our service
		subject_sentence = subject_sentenceService.getSubjectSentence(subject_sentence_id);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("SubjectSentence", subject_sentence);
		// send over to our form
		return "subject_sentence-update-jstl";
	}
	
	@GetMapping("/delete-jstl")
	public String deleteSubjectSentenceJstl(
	@RequestParam("subject_sentence_id") String subject_sentence_id
	) {
		// delete the subject_sentence
		subject_sentenceService.deleteSubjectSentence(subject_sentence_id);
		return "redirect:/subject_sentence/subject_sentence-retrieve-jstl";
	}
}