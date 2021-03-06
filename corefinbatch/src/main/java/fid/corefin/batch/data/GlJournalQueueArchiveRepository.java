package fid.corefin.batch.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fid.corefin.batch.model.entity.GlJournalQueueArchive;
import fid.corefin.batch.util.Repository;

@Repository
public class GlJournalQueueArchiveRepository extends BaseEntityRepository<GlJournalQueueArchive> {
	
	public GlJournalQueueArchiveRepository() {
		super(GlJournalQueueArchive.class);
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchive(String createDate) throws Exception {
		String jpql = "select p from GlJournalQueueArchive p Where CONVERT(date,p.createDate)=:createDate Order By p.createDate Desc";

		TypedQuery<GlJournalQueueArchive> typedQuery = entityManager.createQuery(jpql, GlJournalQueueArchive.class)
				.setParameter("createDate", createDate);

 		return typedQuery.getResultList();
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromTo(String from, String to) throws Exception {
		String jpql = "select p from GlJournalQueueArchive p Where CONVERT(date,p.createDate) between :from and :to Order By p.createDate Desc";

		TypedQuery<GlJournalQueueArchive> typedQuery = entityManager.createQuery(jpql, GlJournalQueueArchive.class)
				.setParameter("from", from)
				.setParameter("to", to);

 		return typedQuery.getResultList();
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromToWithModule(String from, String to, String module) throws Exception {
		String jpql = "select p from GlJournalQueueArchive p Where CONVERT(date,p.createDate) between :from and :to And module=:module Order By p.createDate Desc";

		TypedQuery<GlJournalQueueArchive> typedQuery = entityManager.createQuery(jpql, GlJournalQueueArchive.class)
				.setParameter("from", from)
				.setParameter("to", to)
				.setParameter("module", module);

 		return typedQuery.getResultList();
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveByRefId(String refId) throws Exception{
		String jpql = "SELECT p FROM GlJournalQueueArchive p WHERE p.refId LIKE :id";
		TypedQuery<GlJournalQueueArchive> typedQuery = entityManager.createQuery(jpql, GlJournalQueueArchive.class)
				.setParameter("id","%"+ refId +"%");
		return typedQuery.getResultList();
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveByJournalId(String journalId) throws Exception{
		String jpql = "SELECT p FROM GlJournalQueueArchive p WHERE p.fIdJournal LIKE :id";
		TypedQuery<GlJournalQueueArchive> typedQuery = entityManager.createQuery(jpql, GlJournalQueueArchive.class)
				.setParameter("id","%"+ journalId +"%");
		return typedQuery.getResultList();
	}
	
}
