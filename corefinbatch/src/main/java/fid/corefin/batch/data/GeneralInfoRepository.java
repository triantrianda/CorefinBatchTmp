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

import fid.corefin.batch.model.entity.GeneralInfo;
import fid.corefin.batch.model.entity.SummaryProcess;
import fid.corefin.batch.util.Repository;

@Repository
public class GeneralInfoRepository extends BaseMySQLEntityRepository<GeneralInfo> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<GeneralInfo> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<GeneralInfo> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<GeneralInfo> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<GeneralInfo> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(GeneralInfo generalInfo) throws Exception {
		try {
			entityManager.persist(generalInfo);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<GeneralInfo> getAllGeneralList() {
		List<GeneralInfo> list = new ArrayList<GeneralInfo>();
		try {
			EntityManager em = getEntityManager();
			TypedQuery<GeneralInfo> query = em.createQuery(
					"SELECT p FROM GeneralInfo p",GeneralInfo.class);
			list = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
