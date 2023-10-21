package com.eng.sentence.domain.models.repositories;
import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

import com.eng.sentence.domain.models.*;
import com.eng.sentence.domain.utils.web.WebRequestUtil;
import com.eng.sentence.domain.utils.HibernateHqlConverter;
import com.eng.sentence.domain.utils.StringConverter;

@Component
@Repository
public class SubjectSentenceDaoImpl implements SubjectSentenceDao {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<SubjectSentence> getSubjectSentences() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence order by subject_sentence_id",
		SubjectSentence.class);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	
	@Override
	public SubjectSentence saveSubjectSentence(SubjectSentence subject_sentence) {
		boolean success = false;
		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Use transactions to perform insert operations
		Transaction transaction = null;
		try {
			if (!currentSession.getTransaction().isActive()) {
				transaction = currentSession.beginTransaction();
			}
			currentSession.saveOrUpdate(subject_sentence);
			if (transaction != null) {
				transaction.commit();
			}
			success = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			success = false;
		} finally {
			if (transaction == null || !transaction.isActive()) {
				//currentSession.close();
			}
		}
		if (success) {
			return subject_sentence;
		}else{
			return null;
		}
	}
	
	@Override
	public SubjectSentence getSubjectSentence(String subject_sentence_id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		SubjectSentence subject_sentence = currentSession.get(SubjectSentence.class, subject_sentence_id);
		return subject_sentence;
	}
	
	@Override
	public void deleteSubjectSentence(String subject_sentence_id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery =
		currentSession.createQuery("delete from SubjectSentence where subject_sentence_id=:subject_sentence_id");
		theQuery.setParameter("subject_sentence_id", subject_sentence_id);
		theQuery.executeUpdate();
	}
	@Override
	public List<SubjectSentence> findBySubjectSentenceId(String subject_sentence_id){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where subject_sentence_id=:subject_sentence_id",SubjectSentence.class);
		theQuery.setParameter("subject_sentence_id", subject_sentence_id);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findBySituation(String situation){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where situation=:situation",SubjectSentence.class);
		theQuery.setParameter("situation", situation);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByEvent(String event){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where event=:event",SubjectSentence.class);
		theQuery.setParameter("event", event);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findBySentenceType(String sentence_type){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where sentence_type=:sentence_type",SubjectSentence.class);
		theQuery.setParameter("sentence_type", sentence_type);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByArticle01(String article_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where article_01=:article_01",SubjectSentence.class);
		theQuery.setParameter("article_01", article_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findBySubject01(String subject_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where subject_01=:subject_01",SubjectSentence.class);
		theQuery.setParameter("subject_01", subject_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByConjunction01(String conjunction_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where conjunction_01=:conjunction_01",SubjectSentence.class);
		theQuery.setParameter("conjunction_01", conjunction_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByAdverb01(String adverb_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where adverb_01=:adverb_01",SubjectSentence.class);
		theQuery.setParameter("adverb_01", adverb_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByAuxiliaryVerb01(String auxiliary_verb_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where auxiliary_verb_01=:auxiliary_verb_01",SubjectSentence.class);
		theQuery.setParameter("auxiliary_verb_01", auxiliary_verb_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByVerb01(String verb_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where verb_01=:verb_01",SubjectSentence.class);
		theQuery.setParameter("verb_01", verb_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByInfinitive01(String infinitive_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where infinitive_01=:infinitive_01",SubjectSentence.class);
		theQuery.setParameter("infinitive_01", infinitive_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByConjunction02(String conjunction_02){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where conjunction_02=:conjunction_02",SubjectSentence.class);
		theQuery.setParameter("conjunction_02", conjunction_02);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByAdverb02(String adverb_02){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where adverb_02=:adverb_02",SubjectSentence.class);
		theQuery.setParameter("adverb_02", adverb_02);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByPreposition01(String preposition_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where preposition_01=:preposition_01",SubjectSentence.class);
		theQuery.setParameter("preposition_01", preposition_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByPronoun01(String pronoun_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where pronoun_01=:pronoun_01",SubjectSentence.class);
		theQuery.setParameter("pronoun_01", pronoun_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByArticle02(String article_02){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where article_02=:article_02",SubjectSentence.class);
		theQuery.setParameter("article_02", article_02);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByAdjective01(String adjective_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where adjective_01=:adjective_01",SubjectSentence.class);
		theQuery.setParameter("adjective_01", adjective_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByNoun01(String noun_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where noun_01=:noun_01",SubjectSentence.class);
		theQuery.setParameter("noun_01", noun_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByNounPhase01(String noun_phase_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where noun_phase_01=:noun_phase_01",SubjectSentence.class);
		theQuery.setParameter("noun_phase_01", noun_phase_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByGerund01(String gerund_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where gerund_01=:gerund_01",SubjectSentence.class);
		theQuery.setParameter("gerund_01", gerund_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByPreposition02(String preposition_02){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where preposition_02=:preposition_02",SubjectSentence.class);
		theQuery.setParameter("preposition_02", preposition_02);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByClause01(String clause_01){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where clause_01=:clause_01",SubjectSentence.class);
		theQuery.setParameter("clause_01", clause_01);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByFullSentence(String full_sentence){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where full_sentence=:full_sentence",SubjectSentence.class);
		theQuery.setParameter("full_sentence", full_sentence);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> findByTraditionalChinese(String traditional_chinese){
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		Query<SubjectSentence> theQuery =
		currentSession.createQuery("from SubjectSentence where traditional_chinese=:traditional_chinese",SubjectSentence.class);
		theQuery.setParameter("traditional_chinese", traditional_chinese);
		// execute query and get result list
		List<SubjectSentence> subject_sentences = theQuery.getResultList();
		// return the results
		return subject_sentences;
	}
	@Override
	public List<SubjectSentence> filterSubjectSentence(WebRequestUtil.FilterRequestData requestData){
		List<SubjectSentence> subject_sentences = null;
		if (requestData != null) {
			if(!requestData.getHql().isEmpty()) {
				Session currentSession = sessionFactory.getCurrentSession();
				String hql=requestData.getHql();
				Query<SubjectSentence> theQuery = currentSession.createQuery(hql, SubjectSentence.class);
				Map<String, List<Object>> dataValues = requestData.getDataValues();
				for (Map.Entry<String, List<Object>> entry : dataValues.entrySet()) {
					String paramName = entry.getKey();
					List<Object> paramValue = entry.getValue();
					if(paramValue.size()>1) {
						theQuery.setParameterList(paramName, paramValue);
					}else if(paramValue.size()==1) {
						theQuery.setParameter(paramName, paramValue.get(0));
					}
				}
				subject_sentences = theQuery.getResultList();
			}
		}
		return subject_sentences;
	}
}