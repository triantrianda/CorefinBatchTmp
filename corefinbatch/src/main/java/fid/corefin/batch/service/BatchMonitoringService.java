package fid.corefin.batch.service;

import java.io.Serializable;
import java.util.Date;
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

import fid.corefin.batch.data.GlJournalQueueRepository;
import fid.corefin.batch.data.GlJournalQueueArchiveRepository;
import fid.corefin.batch.model.entity.GlJournalQueue;
import fid.corefin.batch.model.entity.GlJournalQueueArchive;

@Singleton
public class BatchMonitoringService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Inject
	private GlJournalQueueRepository glJournalQueueRepository;
	
	@Inject
	private GlJournalQueueArchiveRepository glJournalQueueArchiveRepository;
	
	@Inject
	private Logger logger;
	
//	@Transactional(readOnly = true)
//	public String getParameterValue(int id) {
//		try {
//			Parameter param = paramRepository.getParameterById(id);
//			return param.getValue();
//		}catch (Exception e) {
//			e.printStackTrace();
//			//logger.error("Failed to fetch data ||"+ e.getMessage());
//			throw e;
//		}
//	}
	
	@Transactional(readOnly = true)
	public char getParameterValueGlJournalQue(int id) {
		try {
			GlJournalQueue param = glJournalQueueRepository.getParameterById(id);
			return param.getStatus();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed to fetch data ||"+ e.getMessage());
			throw e;
		}
	}
	
	@SuppressWarnings("static-access")
	public List<GlJournalQueue> getGlJournalQueue(String createDate) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueue(createDate);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromTo(String from, String to) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueueFromTo(from, to);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueue> getGlJournalQueueFromToWithModule(String from, String to, String module) throws Exception {
		try {
			List<GlJournalQueue> listData = glJournalQueueRepository.getGlJournalQueueFromToWithModule(from, to, module);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	@SuppressWarnings("static-access")
	public List<GlJournalQueueArchive> getGlJournalQueueArchive(String createDate) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchive(createDate);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromTo(String from, String to) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveFromTo(from, to);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
	
	public List<GlJournalQueueArchive> getGlJournalQueueArchiveFromToWithModule(String from, String to, String module) throws Exception {
		try {
			List<GlJournalQueueArchive> listData = glJournalQueueArchiveRepository.getGlJournalQueueArchiveFromToWithModule(from, to, module);
			return listData;
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Gl Journal Queue || " + e.getMessage());
			throw e;
		}
	}
}
