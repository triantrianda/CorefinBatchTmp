package fid.corefin.batch.data;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fid.corefin.batch.model.entity.MobileNotification;
import fid.corefin.batch.util.Repository;

@Repository
public class MobileNotificationRepository extends BaseEntityRepository<MobileNotification> {
	
	//private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
	
	public MobileNotificationRepository() {
		super(MobileNotification.class);
	}
	
	public MobileNotification getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<MobileNotification> query = em.createQuery("SELECT p FROM MobileNotification p WHERE p.id = ?1", MobileNotification.class);
		MobileNotification parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
	
	public List<MobileNotification> getMobileNotificationByDate(Date date) throws Exception {
		String jpql = "Select p From MobileNotification p Where CONVERT(DATE, p.createDate) = :date Order By p.createDate Desc";
		TypedQuery<MobileNotification> typedQuery = entityManager.createQuery(jpql, MobileNotification.class)
				.setParameter("date", date);
 		return typedQuery.getResultList();
	}
	
	public List<MobileNotification> getMobileNotificationByDate(Date dateFrom, Date dateTo) throws Exception {
		  String jpql = "Select p From MobileNotification p Where CONVERT(date,p.createDate) >= :from and CONVERT(date,p.createDate) <=:to Order By p.createDate Desc";
		  TypedQuery<MobileNotification> typedQuery = entityManager.createQuery(jpql,MobileNotification.class)
				  .setParameter("from", dateFrom)
				  .setParameter("to", dateTo);
		  return typedQuery.getResultList();
	}
	
	public List<MobileNotification> getMobileNotificationByParam(String param) throws Exception {
		String jpql = "Select p From MobileNotification p Where p.parameter LIKE :param Order By p.createDate Desc";
		TypedQuery<MobileNotification> typedQuery = entityManager.createQuery(jpql, MobileNotification.class)
				.setParameter("param", "%"+ param +"%");
 		return typedQuery.getResultList();
	}
	
}
