package fid.corefin.batch.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.util.Repository;

@Repository
public class WaOtpRepository extends BaseMySQLEntityRepository2<WaOTP> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaOTP> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<WaOTP> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<WaOTP> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaOTP> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(WaOTP waOTP) throws Exception {
		try {
			entityManager.persist(waOTP);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<WaOTP> getAllWaOtpList() {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaOTP> query = em.createQuery(
					"SELECT p FROM WaOTP p ORDER BY p.date desc",WaOTP.class);
			return query.getResultList();	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public WaOTP getWaOtpByDate(Date date){
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaOTP> query = em.createQuery(
					"SELECT p FROM WaOTP p WHERE p.date = ?1",WaOTP.class);
			query.setParameter(1, date);
			return query.getSingleResult();	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<WaOTP> getWaOtpListToUpdate(Date date) {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaOTP> query = em.createQuery(
					"SELECT p FROM WaOTP p WHERE p.date < ?1 AND p.otpSuccess = ?2 AND p.otpFailed = ?3 AND p.otpObsolete = ?4",WaOTP.class);
			query.setParameter(1, date);
			query.setParameter(2, 0);
			query.setParameter(3, 0);
			query.setParameter(4, 0);
			return query.getResultList();	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
