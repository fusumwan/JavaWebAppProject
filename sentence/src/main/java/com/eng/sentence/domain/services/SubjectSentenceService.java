package com.eng.sentence.domain.services;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.Date;

import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.utils.web.WebRequestUtil;
public interface SubjectSentenceService {
	public List<SubjectSentence> getSubjectSentences();
	public SubjectSentence saveSubjectSentence(SubjectSentence subject_sentence);
	public SubjectSentence getSubjectSentence(String subject_sentence_id);
	public void deleteSubjectSentence(String subject_sentence_id);
	public List<SubjectSentence> findBySubjectSentenceId(String subject_sentence_id);
	public List<SubjectSentence> findBySituation(String situation);
	public List<SubjectSentence> findByEvent(String event);
	public List<SubjectSentence> findBySentenceType(String sentence_type);
	public List<SubjectSentence> findByArticle01(String article_01);
	public List<SubjectSentence> findBySubject01(String subject_01);
	public List<SubjectSentence> findByConjunction01(String conjunction_01);
	public List<SubjectSentence> findByAdverb01(String adverb_01);
	public List<SubjectSentence> findByAuxiliaryVerb01(String auxiliary_verb_01);
	public List<SubjectSentence> findByVerb01(String verb_01);
	public List<SubjectSentence> findByInfinitive01(String infinitive_01);
	public List<SubjectSentence> findByConjunction02(String conjunction_02);
	public List<SubjectSentence> findByAdverb02(String adverb_02);
	public List<SubjectSentence> findByPreposition01(String preposition_01);
	public List<SubjectSentence> findByPronoun01(String pronoun_01);
	public List<SubjectSentence> findByArticle02(String article_02);
	public List<SubjectSentence> findByAdjective01(String adjective_01);
	public List<SubjectSentence> findByNoun01(String noun_01);
	public List<SubjectSentence> findByNounPhase01(String noun_phase_01);
	public List<SubjectSentence> findByGerund01(String gerund_01);
	public List<SubjectSentence> findByPreposition02(String preposition_02);
	public List<SubjectSentence> findByClause01(String clause_01);
	public List<SubjectSentence> findByFullSentence(String full_sentence);
	public List<SubjectSentence> findByTraditionalChinese(String traditional_chinese);
	public List<SubjectSentence> filterSubjectSentence(WebRequestUtil.FilterRequestData requestData);
}
