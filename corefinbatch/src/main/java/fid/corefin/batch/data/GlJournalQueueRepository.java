package fid.corefin.batch.data;

//import java.security.Timestamp;
//import java.time.LocalDate;
//import java.time.ZoneOffset;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;

import fid.corefin.batch.model.entity.GlJournalQueue;
import fid.corefin.batch.util.Repository;

@Repository
public class GlJournalQueueRepository extends BaseEntityRepository<GlJournalQueue> {
	
	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
	public GlJournalQueueRepository() {
		super(GlJournalQueue.class);
	}
	
	public GlJournalQueue getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<GlJournalQueue> query = em.createQuery("SELECT p FROM GlJournalQueue p WHERE p.id = ?1", GlJournalQueue.class);
		GlJournalQueue parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
	
	public List<GlJournalQueue> getGlJournalQueue(String createDate) throws Exception {
		String jpql = "Select p From GlJournalQueue p Where CONVERT(date,p.createDate)=:createDate Order By p.createDate Desc";

		TypedQuery<GlJournalQueue> typedQuery = entityManager.createQuery(jpql, GlJournalQueue.class)
				.setParameter("createDate", createDate);

 		return typedQuery.getResultList();
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromTo(String from, String to) throws Exception {
		
		  String jpql = "Select p From GlJournalQueue p Where CONVERT(date,p.createDate) between :from and :to Order By p.createDate Desc";
		  
		  TypedQuery<GlJournalQueue> typedQuery = entityManager.createQuery(jpql,GlJournalQueue.class)
				  .setParameter("from", from)
				  .setParameter("to", to);
		  
		  return typedQuery.getResultList();
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromToWithModule(String from, String to, String module) throws Exception {
		
		  String jpql = "Select p From GlJournalQueue p Where CONVERT(date,p.createDate) Between :from and :to And module=:module Order By p.createDate Desc";
		  
		  TypedQuery<GlJournalQueue> typedQuery = entityManager.createQuery(jpql,GlJournalQueue.class)
				  .setParameter("from", from)
				  .setParameter("to", to)
				  .setParameter("module", module);
		  
		  return typedQuery.getResultList();
	}
	
	public List<GlJournalQueue> getGlJournalQueueByRefId(String refId) throws Exception{
		String jpql = "SELECT p FROM GlJournalQueue p WHERE p.refId=:refId";
		TypedQuery<GlJournalQueue> typedQuery = entityManager.createQuery(jpql, GlJournalQueue.class)
				.setParameter("refId", refId);
		return typedQuery.getResultList();
	}
	
}
