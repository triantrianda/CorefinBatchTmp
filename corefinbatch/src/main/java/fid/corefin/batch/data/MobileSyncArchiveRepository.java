package fid.corefin.batch.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import fid.corefin.batch.model.entity.MobileSyncArchive;
import fid.corefin.batch.util.Repository;

@Repository
public class MobileSyncArchiveRepository extends BaseEntityRepository<MobileSyncArchive> {
	
	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
	public MobileSyncArchiveRepository() {
		super(MobileSyncArchive.class);
	}
	
	public MobileSyncArchive getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<MobileSyncArchive> query = em.createQuery("SELECT p FROM MobileSyncArchive p WHERE p.id = ?1", MobileSyncArchive.class);
		MobileSyncArchive parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
	
	public List<MobileSyncArchive> getMobileSync(String createDate) throws Exception {
		String jpql = "Select p From MobileSyncArchive p Where CONVERT(date,p.createDate)=:createDate Order By p.createDate Desc";

		TypedQuery<MobileSyncArchive> typedQuery = entityManager.createQuery(jpql, MobileSyncArchive.class)
				.setParameter("createDate", createDate);

 		return typedQuery.getResultList();
	}
	
	public List<MobileSyncArchive> getMobileSyncFromTo(String from, String to) throws Exception {
		
		  String jpql = "Select p From MobileSyncArchive p Where CONVERT(date,p.createDate) between :from and :to Order By p.createDate Desc";
		  
		  TypedQuery<MobileSyncArchive> typedQuery = entityManager.createQuery(jpql,MobileSyncArchive.class)
				  .setParameter("from", from)
				  .setParameter("to", to);
		  
		  return typedQuery.getResultList();
	}
	
	public List<MobileSyncArchive> getMobileSyncArcByRefId(String refId) throws Exception{
		String jpql = "SELECT p FROM MobileSyncArchive p WHERE p.refId LIKE :refId";
		TypedQuery<MobileSyncArchive> typedQuery = entityManager.createQuery(jpql, MobileSyncArchive.class)
				.setParameter("refId","%" + refId + "%");
		return typedQuery.getResultList();
	}
	
	public List<MobileSyncArchive> getMobileSyncArcByExecutionDate(String dateFrom, String dateTo) throws Exception{
		String jpql = "SELECT p FROM MobileSyncArchive p WHERE p.executionDate >=:from AND p.executionDate <:to";
		TypedQuery<MobileSyncArchive> typedQuery = entityManager.createQuery(jpql, MobileSyncArchive.class)
				.setParameter("from",dateFrom)
				.setParameter("to", dateTo);
		return typedQuery.getResultList();
	}
	
	public List<MobileSyncArchive> getMobileSyncArcByStatement(String refId) throws Exception{
		String jpql = "SELECT p FROM MobileSyncArchive p WHERE p.statementText LIKE:id";
		TypedQuery<MobileSyncArchive> typedQuery = entityManager.createQuery(jpql, MobileSyncArchive.class)
				.setParameter("id","%"+ refId +"%");
		return typedQuery.getResultList();
	}
	
}
