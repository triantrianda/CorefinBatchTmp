package fid.corefin.batch.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fid.corefin.batch.model.entity.Archive;
import fid.corefin.batch.util.Repository;

@Repository
public class ArchiveRepository extends BaseMySQLEntityRepository<Archive> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<Archive> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<Archive> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<Archive> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<Archive> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(Archive archive) throws Exception {
		try {
			entityManager.persist(archive);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Archive> getListByDate(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date nextDay = cal.getTime();
			EntityManager em = getEntityManager();
			TypedQuery<Archive> query = em.createQuery(
					"SELECT p FROM Archive p WHERE p.sendDate <= ?1 AND p.sendDate >= ?2",Archive.class);
			query.setParameter(1, nextDay);
			query.setParameter(2, date);
			return query.getResultList();	
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
}
