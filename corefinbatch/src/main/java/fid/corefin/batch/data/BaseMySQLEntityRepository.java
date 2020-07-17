package fid.corefin.batch.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.Logger;

@Singleton
public abstract class BaseMySQLEntityRepository<T> {
		
	@PersistenceContext(unitName = "finWAStagingDS")
	protected EntityManager entityManager;
	
	@Inject
	protected Logger logger;
	
	private Class<T> entityClass;
	
	public BaseMySQLEntityRepository() {
	}
	
	public BaseMySQLEntityRepository(Class<T> entityClass){
		super();
		this.entityClass = entityClass;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected void joinCriteria(Map<String,Object> params, Root<T> root) throws Exception{
		
	}
	
	protected void addCriteriaQueryOrderBy(CriteriaQuery<T> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<T> root) throws Exception {
		Expression<T> id = null;
		try {
			id = root.get("id");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		if(id != null) {
			criteriaQuery.orderBy(criteriaBuilder.asc(id));
		}
	}
	
	protected void addCriteriaQueryOrderBySingleInstance(CriteriaQuery<T> criteriaQuery, CriteriaBuilder criteriaBuilder, Root<T> root, Map<String, Object> params)
			throws Exception {
	}

	protected Predicate[] extractPredicates(Map<String, Object> params, CriteriaBuilder criteriaBuilder, Root<T> root)
			throws Exception {
		return new Predicate[] {};
	}

	protected Predicate[] extractPredicates(Map<String, Object> params, HashMap<String, String> paramMap, CriteriaBuilder criteriaBuilder, Root<T> root)
			throws Exception {
		return new Predicate[] {};
	}
	
	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, CriteriaBuilder criteriaBuilder,
			Root<T> root) throws Exception {
		List<Predicate> predicates = new ArrayList<Predicate>();

		for (Entry<String, Object> entry : params.entrySet()) {
			predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
		}

		return predicates.toArray(new Predicate[] {});
	}


	protected Predicate[] extractPredicatesSingle(Map<String, Object> params, HashMap<String, String> paramMap, CriteriaBuilder criteriaBuilder,
			Root<T> root) throws Exception {
		List<Predicate> predicates = new ArrayList<Predicate>();

		for (Entry<String, Object> entry : params.entrySet()) {
			predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
		}

		return predicates.toArray(new Predicate[] {});
	}
	
	public List<T> getAll(Map<String, Object> params) throws Exception {

		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);
		Predicate[] predicates = extractPredicates(params, criteriaBuilder, root);
		criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);

		joinCriteria(params, root);
		addCriteriaQueryOrderBy(criteriaQuery, criteriaBuilder, root);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		if (params.containsKey("first")) {
			Integer firstRecord = (Integer) params.get("first") - 1;
			typedQuery.setFirstResult(firstRecord);
		}

		if (params.containsKey("maxResults")) {
			Integer maxResults = (Integer) params.get("maxResults");
			typedQuery.setMaxResults(maxResults);
		}

		return typedQuery.getResultList();
	}


	public List<T> getAll(Map<String, Object> params, HashMap<String, String> paramMap) throws Exception {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);
		Predicate[] predicates = extractPredicates(params, paramMap, criteriaBuilder, root);
		criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);

		joinCriteria(params, root);
		addCriteriaQueryOrderBy(criteriaQuery, criteriaBuilder, root);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		if (params.containsKey("first")) {
			Integer firstRecord = (Integer) params.get("first") - 1;
			typedQuery.setFirstResult(firstRecord);
		}

		if (params.containsKey("maxResults")) {
			Integer maxResults = (Integer) params.get("maxResults");
			typedQuery.setMaxResults(maxResults);
		}

		return typedQuery.getResultList();
	}
	
	public Map<String, Long> getCount(Map<String, Object> params) throws Exception {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

		Root<T> root = criteriaQuery.from(entityClass);

		joinCriteria(params, root);

		criteriaQuery.select(criteriaBuilder.count(root));
		Predicate[] predicates = extractPredicates(params, criteriaBuilder, root);
		criteriaQuery = criteriaQuery.where(predicates);

		Map<String, Long> resultMap = new HashMap<String, Long>();
		resultMap.put("count", entityManager.createQuery(criteriaQuery).getSingleResult());

		return resultMap;
	}

	public T getSingleInstance(String rootName, Object id) throws Exception {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);

		Predicate predicate = criteriaBuilder.equal(root.get(rootName), id);

		criteriaQuery.select(criteriaQuery.getSelection()).where(predicate);

		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	public Long getMax(String id) throws Exception {
		return ((Long) entityManager.createQuery("select max(" + id + ") from " + entityClass.getSimpleName())
				.getSingleResult());
	}

	public Long getNext(String id) throws Exception {
		return getMax(id) + 1;
	}

	public T getSingleInstance(Map<String, Object> params) throws NoResultException, Exception {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);

		joinCriteria(params, root);

		Predicate[] predicates = extractPredicatesSingle(params, criteriaBuilder, root);

		criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);

		addCriteriaQueryOrderBySingleInstance(criteriaQuery, criteriaBuilder, root, params);
		
		return entityManager.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
	}



	public T getSingleInstance(Map<String, Object> params, HashMap<String, String> paramMap) throws NoResultException, Exception {

		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

		Root<T> root = criteriaQuery.from(entityClass);

		joinCriteria(params, root);

		Predicate[] predicates = extractPredicatesSingle(params, paramMap, criteriaBuilder, root);

		criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);

		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	
	public void save(Object entity) {
		try {
			entityManager.persist(entity);
		}catch(Exception e) {
			throw e;
		}
	}

	public void commit() {
		entityManager.flush();
	}

	public void refresh(Object entity) {
		entityManager.refresh(entity);
	}

	public void commitRefresh(Object entity) {
		commit();
		refresh(entity);
	}

	public void find(Object entity, Object params) {
		entityManager.find(entity.getClass(), params);
	}

	public void remove(Object entity) {
		entityManager.remove(entity);
	}
	
	public void merge(Object entity) {
		try {
			entityManager.merge(entity);
		}catch(Exception e) {
			throw e;
		}
	}

//	@SuppressWarnings("rawtypes")
//	public List<Predicate> getPredicate(Map<String, Object> params, HashMap<String, String> paramMap, CriteriaBuilder criteriaBuilder, Root root) {
//
//		List<Predicate> predicates = new ArrayList<Predicate>();
//
//		int ii = 0;
//		List<String> listTable = new ArrayList<String>();
//		for (Entry<String, String> pair : paramMap.entrySet()) {
//			if (params.containsKey(pair.getKey())) {
//				String[] key = pair.getValue().split(CommonUtil.REGEX_DOT);
//				String lastType = "";
//				String tableName = "";
//				SetJoin<?, ?> children = null;
//				Path path = null;
//				for (int i = 0; i < key.length - 1; i++) {
//					if (listTable.contains(tableName + ( CommonUtil.isNullOrEmpty(tableName)?"":".") + key[i])) {
//
//					} else {
//						if (i == 0) {
//							if (root.get(key[i]).getClass().getName()
//									.equals("org.hibernate.jpa.criteria.path.PluralAttributePath")) {
//								children = root.joinSet(key[i], JoinType.INNER);
//								lastType = "SetJoin";
//							} else {
//								path = root.get(key[i]);
//								lastType = "Path";
//							}
//						} else {
//							if (children.get(key[i]).getClass().getName()
//									.equals("org.hibernate.jpa.criteria.path.PluralAttributePath")) {
//								if (lastType.equals("Path")) {
//									children = ((Root) path).joinSet(key[i], JoinType.INNER);
//								} else {
//									children = children.joinSet(key[i], JoinType.INNER);
//								}
//								lastType = "SetJoin";
//							} else {
//								if (lastType.equals("Path")) {
//									path = path.get(key[i]);
//								} else {
//									path = children.get(key[i]);
//								}
//								lastType = "Path";
//							}
//						}
//						tableName += ( CommonUtil.isNullOrEmpty(tableName)?"":".") + key[i];
//						//listTable.add(tableName);
//					}
//				}
//				if (children != null || path != null) {
//					if (lastType.equals("Path")) {
//						if (ii == 0) {
//							Predicate nP = addParamater(criteriaBuilder, path.get(key[key.length - 1]), params.get(pair.getKey()));
//							if(CommonUtil.isNotNullOrEmpty(nP))
//							predicates.add(criteriaBuilder.and(nP));
//						} else {
//							Predicate nP = addParamater(criteriaBuilder, path.get(key[key.length - 1]), params.get(pair.getKey()));
//							if(CommonUtil.isNotNullOrEmpty(nP))
//							predicates.add(criteriaBuilder.and(nP));
//						}
//					} else {
//						if (ii == 0) {
//							Predicate nP = addParamater(criteriaBuilder, children.get(key[key.length - 1]), params.get(pair.getKey()));
//							if(CommonUtil.isNotNullOrEmpty(nP))
//							predicates.add(nP);
//						} else {
//							Predicate nP = addParamater(criteriaBuilder, children.get(key[key.length - 1]), params.get(pair.getKey()));
//							if(CommonUtil.isNotNullOrEmpty(nP))
//							predicates.add(criteriaBuilder.and(nP));
//						}
//					}
//				} else {
//					if (ii == 0) {
//						Predicate nP = addParamater(criteriaBuilder, root.get(key[0]), params.get(pair.getKey()));
//						if(CommonUtil.isNotNullOrEmpty(nP))
//						predicates.add(nP);
//					} else {
//						Predicate nP = addParamater(criteriaBuilder, root.get(key[0]), params.get(pair.getKey()));
//						if(CommonUtil.isNotNullOrEmpty(nP))
//						predicates.add(criteriaBuilder.and(nP));
//					}
//				}
//			}
//			ii++;
//		}
//
//		return predicates;
//	}
	

	@SuppressWarnings({ "rawtypes" })
	private Predicate addParamater( CriteriaBuilder criteriaBuilder,  Expression<?> key, Object value){
		if( value!=null && (value.getClass().isArray() || value instanceof List)){
			if(value instanceof List && ((List) value).size()>0){
				return (criteriaBuilder.and(setParamater(criteriaBuilder, key, value)));
			}
			if(value.getClass().isArray() && ((ArrayList)value).size()>0 ){
				return (criteriaBuilder.and(setParamater(criteriaBuilder, key, value)));				
			}
		}else{
			return (criteriaBuilder.and(setParamater(criteriaBuilder, key, value)));
		}
		return null;
	}
	
	private Predicate setParamater(CriteriaBuilder criteriaBuilder, Expression<?> key, Object value){
		if( value!=null && (value.getClass().isArray() || value instanceof List)){
			return key.in(value);
		}else{
			return criteriaBuilder.equal(key, value);
		}
	}


}
