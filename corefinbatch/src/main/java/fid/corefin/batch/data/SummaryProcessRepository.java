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

import fid.corefin.batch.model.entity.SummaryProcess;
import fid.corefin.batch.util.Repository;

@Repository
public class SummaryProcessRepository extends BaseMySQLEntityRepository<SummaryProcess> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<SummaryProcess> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<SummaryProcess> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<SummaryProcess> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<SummaryProcess> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(SummaryProcess SummaryProcess) throws Exception {
		try {
			entityManager.persist(SummaryProcess);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SummaryProcess getSummaryProcessByDate(Date date, String processType) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date nextDay = cal.getTime();
			EntityManager em = getEntityManager();
			TypedQuery<SummaryProcess> query = em.createQuery(
					"SELECT p FROM SummaryProcess p WHERE p.create_date <= ?1 and p.create_date >= ?2 and p.process_type = ?3",SummaryProcess.class);
			query.setParameter(1, nextDay);
			query.setParameter(2, date);
			query.setParameter(3, processType);
			SummaryProcess summary = query.getSingleResult();
			return summary;	
		}catch (Exception e) {
			return null;
		}
	}
}
