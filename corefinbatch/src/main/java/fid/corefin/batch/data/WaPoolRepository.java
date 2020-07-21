package fid.corefin.batch.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fid.corefin.batch.model.entity.WaPooling;
import fid.corefin.batch.util.CommonUtil;
import fid.corefin.batch.util.Repository;

@Repository
public class WaPoolRepository extends BaseMySQLEntityRepository2<WaPooling> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaPooling> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<WaPooling> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<WaPooling> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaPooling> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(WaPooling waPooling) throws Exception {
		try {
			entityManager.persist(waPooling);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public WaPooling getByDate(Date date) {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaPooling> query = em.createQuery(
					"SELECT p FROM WaPooling p WHERE p.date = ?1", WaPooling.class);
			query.setParameter(1, date);
			return query.getSingleResult();
		} catch (NoResultException  nre) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<WaPooling> getByDateAndTotalActualData(Date date) {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaPooling> query = em.createQuery(
					"SELECT p FROM WaPooling p WHERE p.date < ?1 AND p.totalActualPool = ?2", WaPooling.class);
			query.setParameter(1, date);
			query.setParameter(2, 0);
			return query.getResultList();
		} catch (NoResultException  nre) {
			nre.printStackTrace();
			return null;
		}
	}
	
	public List<WaPooling> getListWaPooling(){
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaPooling> query = em.createQuery(
					"SELECT p FROM WaPooling p ORDER BY p.date desc", WaPooling.class);
			return query.getResultList();
		} catch (NoResultException  nre) {
			nre.printStackTrace();
			return null;
		}
	}
	
}
