package fid.corefin.batch.data;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.Logger;


@Singleton
public abstract class BaseStoreProcedureRepository<T> {

	//@Inject
	@PersistenceContext(unitName = "corefinBatchDS")
	protected EntityManager entityManager;

	@Inject
	protected Logger logger;

	private Class<T> entityClass;

	public BaseStoreProcedureRepository() {
	}

	public BaseStoreProcedureRepository(Class<T> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
