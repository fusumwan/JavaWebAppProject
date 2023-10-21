package com.eng.sentence.domain.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.utils.web.WebRequestUtil;
import com.eng.sentence.domain.models.repositories.*;
import com.eng.sentence.domain.models.*;

@Service
public class SubjectSentenceServiceImpl implements SubjectSentenceService {
	// need to inject subject_sentence Dao
	@Autowired
	private SubjectSentenceDao subject_sentenceDao;
	/*
	* When using a Spring-based transaction management mechanism (such as using the @Transactional annotation), Spring will automatically handle the opening and closing of the Session.
	*/
	@Override
	@Transactional
	public List<SubjectSentence> getSubjectSentences() {
		return subject_sentenceDao.getSubjectSentences();
	}
	
	@Override
	@Transactional
	public SubjectSentence saveSubjectSentence(SubjectSentence subject_sentence) {
		return subject_sentenceDao.saveSubjectSentence(subject_sentence);
	}
	
	@Override
	@Transactional
	public SubjectSentence getSubjectSentence(String subject_sentence_id) {
		return subject_sentenceDao.getSubjectSentence(subject_sentence_id);
	}
	
	@Override
	@Transactional
	public void deleteSubjectSentence(String subject_sentence_id) {
		subject_sentenceDao.deleteSubjectSentence(subject_sentence_id);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findBySubjectSentenceId(String subject_sentence_id){
		return subject_sentenceDao.findBySubjectSentenceId(subject_sentence_id);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findBySituation(String situation){
		return subject_sentenceDao.findBySituation(situation);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByEvent(String event){
		return subject_sentenceDao.findByEvent(event);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findBySentenceType(String sentence_type){
		return subject_sentenceDao.findBySentenceType(sentence_type);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByArticle01(String article_01){
		return subject_sentenceDao.findByArticle01(article_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findBySubject01(String subject_01){
		return subject_sentenceDao.findBySubject01(subject_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByConjunction01(String conjunction_01){
		return subject_sentenceDao.findByConjunction01(conjunction_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByAdverb01(String adverb_01){
		return subject_sentenceDao.findByAdverb01(adverb_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByAuxiliaryVerb01(String auxiliary_verb_01){
		return subject_sentenceDao.findByAuxiliaryVerb01(auxiliary_verb_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByVerb01(String verb_01){
		return subject_sentenceDao.findByVerb01(verb_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByInfinitive01(String infinitive_01){
		return subject_sentenceDao.findByInfinitive01(infinitive_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByConjunction02(String conjunction_02){
		return subject_sentenceDao.findByConjunction02(conjunction_02);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByAdverb02(String adverb_02){
		return subject_sentenceDao.findByAdverb02(adverb_02);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByPreposition01(String preposition_01){
		return subject_sentenceDao.findByPreposition01(preposition_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByPronoun01(String pronoun_01){
		return subject_sentenceDao.findByPronoun01(pronoun_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByArticle02(String article_02){
		return subject_sentenceDao.findByArticle02(article_02);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByAdjective01(String adjective_01){
		return subject_sentenceDao.findByAdjective01(adjective_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByNoun01(String noun_01){
		return subject_sentenceDao.findByNoun01(noun_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByNounPhase01(String noun_phase_01){
		return subject_sentenceDao.findByNounPhase01(noun_phase_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByGerund01(String gerund_01){
		return subject_sentenceDao.findByGerund01(gerund_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByPreposition02(String preposition_02){
		return subject_sentenceDao.findByPreposition02(preposition_02);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByClause01(String clause_01){
		return subject_sentenceDao.findByClause01(clause_01);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByFullSentence(String full_sentence){
		return subject_sentenceDao.findByFullSentence(full_sentence);
	}
	@Override
	@Transactional
	public List<SubjectSentence> findByTraditionalChinese(String traditional_chinese){
		return subject_sentenceDao.findByTraditionalChinese(traditional_chinese);
	}
	@Override
	@Transactional
	public List<SubjectSentence> filterSubjectSentence(WebRequestUtil.FilterRequestData requestData){
		return subject_sentenceDao.filterSubjectSentence(requestData);
	}
}
