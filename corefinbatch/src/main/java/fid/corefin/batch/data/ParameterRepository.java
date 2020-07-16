package fid.corefin.batch.data;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fid.corefin.batch.model.entity.Parameter;
import fid.corefin.batch.util.Repository;

@Repository
public class ParameterRepository extends BaseMySQLEntityRepository<Parameter> {
	
	public ParameterRepository() {
		super(Parameter.class);
	}
	
	public Parameter getParameterById(Integer id) {
		EntityManager em = getEntityManager();
		TypedQuery<Parameter> query = em.createQuery(
				"SELECT p FROM Parameter p WHERE p.id = ?1",Parameter.class);
		Parameter parameter = query.setParameter(1, id).getSingleResult();
		return parameter;
	}
}
