package fid.corefin.batch.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import fid.corefin.batch.model.entity.MobileSync;
import fid.corefin.batch.util.Repository;

@Repository
public class MobileSyncRepository extends BaseEntityRepository<MobileSync> {
	
	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
	public MobileSyncRepository() {
		super(MobileSync.class);
	}
	
	public MobileSync getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<MobileSync> query = em.createQuery("SELECT p FROM MobileSync p WHERE p.id = ?1", MobileSync.class);
		MobileSync parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
	
	public List<MobileSync> getMobileSync(String dateFrom, String dateTo) throws Exception {
		String jpql = "Select p From MobileSync p Where p.executionDate >= :from and p.executionDate <:to Order By p.executionDate Desc";
		TypedQuery<MobileSync> typedQuery = entityManager.createQuery(jpql, MobileSync.class)
				.setParameter("from", dateFrom)
				.setParameter("to", dateTo);
 		return typedQuery.getResultList();
	}
	
	public List<MobileSync> getMobileSyncFromTo(String from, String to) throws Exception {
		
		  String jpql = "Select p From MobileSync p Where CONVERT(date,p.createDate) between :from and :to Order By p.createDate Desc";
		  
		  TypedQuery<MobileSync> typedQuery = entityManager.createQuery(jpql,MobileSync.class)
				  .setParameter("from", from)
				  .setParameter("to", to);
		  
		  return typedQuery.getResultList();
	}
	
	public List<MobileSync> getMobileSyncByExecutionDate(String dateFrom, String dateTo) throws Exception{
		String jpql = "SELECT p FROM MobileSync p WHERE p.executionDate >=:from AND p.executionDate <:to";
		TypedQuery<MobileSync> typedQuery = entityManager.createQuery(jpql, MobileSync.class)
				.setParameter("from",dateFrom)
				.setParameter("to", dateTo);
		return typedQuery.getResultList();
	}
	
	public List<MobileSync> getMobileSyncByStatement(String refId) throws Exception{
		String jpql = "SELECT p FROM MobileSync p WHERE p.statementText LIKE:id";
		TypedQuery<MobileSync> typedQuery = entityManager.createQuery(jpql, MobileSync.class)
				.setParameter("id","%"+ refId +"%");
		return typedQuery.getResultList();
	}
	
}
