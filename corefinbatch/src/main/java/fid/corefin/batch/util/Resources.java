package fid.corefin.batch.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;
import org.apache.deltaspike.scheduler.spi.Scheduler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;

public class Resources {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Produces
	@TransactionScoped
	protected EntityManager createEntityManager() {
		return this.entityManager;
	}
	
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Produces
	@ApplicationScoped
	protected Scheduler<Job> produceScheduler(Scheduler scheduler) {
		return scheduler;
	}

}
