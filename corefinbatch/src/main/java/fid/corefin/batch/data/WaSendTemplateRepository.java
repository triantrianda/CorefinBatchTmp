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

import fid.corefin.batch.model.entity.WaSendTemplate;
import fid.corefin.batch.util.Repository;

@Repository
public class WaSendTemplateRepository extends BaseMySQLEntityRepository2<WaSendTemplate> {
	@Override
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaSendTemplate> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String contractNo = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), contractNo));
		}

		return predicates.toArray(new Predicate[] {});
	}

	@Override
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<WaSendTemplate> criteriaQuery,
			CriteriaBuilder criteriaBuilder, Root<WaSendTemplate> root, Map<String, Object> params) throws Exception {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

	}

	@Override
	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<WaSendTemplate> root) throws Exception {

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (params.containsKey("id")) {
			String id = (String) params.get("id");
			predicates.add(criteriaBuilder.equal(root.get("id"), id));
		}
		return predicates.toArray(new Predicate[] {});
	}

	public void saveFlush(WaSendTemplate waSendTemplate) throws Exception {
		try {
			entityManager.persist(waSendTemplate);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<WaSendTemplate> getAllWaSendTemplateList() {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaSendTemplate> query = em.createQuery(
					"SELECT p FROM WaSendTemplate p ORDER BY p.date desc",WaSendTemplate.class);
			return query.getResultList();	
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public List<WaSendTemplate> getListWaSendToUpdateByDate(Date date){
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaSendTemplate> query = em.createQuery(
					"SELECT p FROM WaSendTemplate p WHERE p.date < ?1 AND p.totalActualSendTemplate = ?2",WaSendTemplate.class);
			query.setParameter(1, date);
			query.setParameter(2, 0);
			return query.getResultList();	
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public WaSendTemplate getByDate(Date date) {
		try {
			EntityManager em = getEntityManager();
			TypedQuery<WaSendTemplate> query = em.createQuery(
					"SELECT p FROM WaSendTemplate p WHERE p.date = ?1",WaSendTemplate.class);
			query.setParameter(1, date);
			return query.getSingleResult();	
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
}
