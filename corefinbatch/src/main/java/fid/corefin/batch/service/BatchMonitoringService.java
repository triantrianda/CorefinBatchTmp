package fid.corefin.batch.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.logging.log4j.Logger;

import fid.corefin.batch.data.ParameterRepository;
import fid.corefin.batch.model.entity.Parameter;

@Singleton
public class BatchMonitoringService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ParameterRepository paramRepository;
	
//	@Produces
//	private Logger logger;
	@Transactional(readOnly = true)
	public String getParameterValue(int id) {
		try {
			//EntityManager emp = paramRepository.getEntityManager();
			String result = "";
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("finWAStagingDS");
//		    EntityManager em = emf.createEntityManager();
//		    Query q = em.createNativeQuery("SELECT * FROM PARAMETER");
//		    List<Object> t = q.getResultList();
//		    
//		    Parameter param = em.find(Parameter.class, 1);
//		    result = param.getName();
			Parameter param = paramRepository.getParameterById(id);
			return result = param.getValue();
		    //return result;
		}catch (Exception e) {
			e.printStackTrace();
			//logger.error("Failed to fetch data ||"+ e.getMessage());
			throw e;
		}
	}
}
