package fid.corefin.batch.data;

import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;

import fid.corefin.batch.model.entity.OverdueMessagePool;

public class OverdueMessagePoolRepository extends BaseStoreProcedureRepository<OverdueMessagePool>{
	
	protected String CECK_OVERDUE_DAYS = "1";
	public OverdueMessagePoolRepository() {
		super(OverdueMessagePool.class);
	}
	
	public int getOverdueMessageCount(Date targetDate) {
		try {
			StoredProcedureQuery procedureQuery = entityManager
					.createNamedStoredProcedureQuery(OverdueMessagePool.NamedQuery_MessageOverduePooling);

			procedureQuery.setParameter("targetDate", targetDate, TemporalType.DATE);
			procedureQuery.setParameter("contractNo", "all");
			procedureQuery.setParameter("phoneNumber", "all");
			procedureQuery.setParameter("checkOverdueDays", CECK_OVERDUE_DAYS);
			procedureQuery.execute();

			List<OverdueMessagePool> resultList = procedureQuery.getResultList();
			return resultList.size();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
