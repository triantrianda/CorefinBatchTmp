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

import fid.corefin.batch.model.entity.OtpArchive;
import fid.corefin.batch.model.entity.SummaryProcess;
import fid.corefin.batch.model.entity.WaOTP;
import fid.corefin.batch.util.Repository;

@Repository
public class OtpArchiveRepository extends BaseMySQLEntityRepository<OtpArchive> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<OtpArchive> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<OtpArchive> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<OtpArchive> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<OtpArchive> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(OtpArchive otpArchive) throws Exception {
		try {
			entityManager.persist(otpArchive);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<OtpArchive> getListByDate(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			Date nextDay = cal.getTime();
			EntityManager em = getEntityManager();
			TypedQuery<OtpArchive> query = em.createQuery(
					"SELECT p FROM OtpArchive p WHERE p.createDate <= ?1 AND p.createDate >= ?2",OtpArchive.class);
			query.setParameter(1, nextDay);
			query.setParameter(2, date);
			return query.getResultList();	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
