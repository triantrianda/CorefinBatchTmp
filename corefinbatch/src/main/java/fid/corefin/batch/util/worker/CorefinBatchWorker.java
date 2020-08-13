package fid.corefin.batch.util.worker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.apache.deltaspike.scheduler.api.Scheduled;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import fid.corefin.batch.service.MessagePoolingMonitoringService;

@Scheduled(cronExpression = "0 1 6 * * ?", onStartup = true)
@DisallowConcurrentExecution
public class CorefinBatchWorker implements org.quartz.Job {
	
	@Inject
	private MessagePoolingMonitoringService messagePoolingService;
	
	@Inject
	Logger logger;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String tgl = sdf.format(new Date());
			Date date = sdf.parse(tgl);
			logger.info("Starting Job Message Pool Plan Data");
			messagePoolingService.getMessagePoolBatchList(date);
			logger.info("Finish Job Message Pool Plan Data");
			
			logger.info("Starting Job Send Template Plan Data");
			messagePoolingService.getMessageSendTemplateBatchList(date);
			logger.info("Finish Job Send Template Plan Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
