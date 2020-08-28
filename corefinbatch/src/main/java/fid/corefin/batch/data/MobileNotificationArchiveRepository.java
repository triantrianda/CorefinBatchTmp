package fid.corefin.batch.data;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fid.corefin.batch.model.entity.MobileNotificationArchive;
import fid.corefin.batch.util.Repository;

@Repository
public class MobileNotificationArchiveRepository extends BaseEntityRepository<MobileNotificationArchive> {
	
	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
	public MobileNotificationArchiveRepository() {
		super(MobileNotificationArchive.class);
	}
	
	public MobileNotificationArchive getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<MobileNotificationArchive> query = em.createQuery("SELECT p FROM MobileNotificationArchive p WHERE p.id = ?1", MobileNotificationArchive.class);
		MobileNotificationArchive parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
	
	public List<MobileNotificationArchive> getMobileNotificationArchiveByDate(Date date) throws Exception {
		String jpql = "Select p From MobileNotificationArchive p Where CONVERT(DATE, p.createDate) =:date Order By p.createDate Desc";
		TypedQuery<MobileNotificationArchive> typedQuery = entityManager.createQuery(jpql, MobileNotificationArchive.class)
				.setParameter("date", date);
 		return typedQuery.getResultList();
	}
	
	public List<MobileNotificationArchive> getMobileNotificationArchiveByDate(Date dateFrom, Date dateTo) throws Exception {
		  String jpql = "Select p From MobileNotificationArchive p Where CONVERT(date,p.createDate) >= :from and CONVERT(date,p.createDate) <=:to Order By p.createDate Desc";
		  TypedQuery<MobileNotificationArchive> typedQuery = entityManager.createQuery(jpql,MobileNotificationArchive.class)
				  .setParameter("from", dateFrom)
				  .setParameter("to", dateTo);
		  return typedQuery.getResultList();
	}
	
	public List<MobileNotificationArchive> getMobileNotificationArchiveByParam(String param) throws Exception {
		String jpql = "Select p From MobileNotificationArchive p Where p.parameter LIKE :param Order By p.createDate Desc";
		TypedQuery<MobileNotificationArchive> typedQuery = entityManager.createQuery(jpql, MobileNotificationArchive.class)
				.setParameter("param", "%"+ param +"%");
 		return typedQuery.getResultList();
	}
	
}
