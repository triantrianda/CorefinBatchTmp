package fid.corefin.batch.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.logging.log4j.Logger;

@Singleton
public class CommonUtil {

	public static final String SERVER_ERROR = "Server has caught a problem, please try again later";
	public static final String DATA_NOT_FOUND = "Data not found";
	public static final String REGEX_DOT = "\\.";

	public static final int DEFAULT_SCALE = 2;

	public static final int DEFAULT_INTEREST_SCALE = 8;

	public static final String[] NEW_FACILITY_STATUS;

	public static final String[] LIVE_FACILITY_STATUS;

	public static final String[] LIVE_CUSTOMER_STATUS;

	static {
		NEW_FACILITY_STATUS = new String[] { "NEW00", "CREATE", "AMEND" };

		LIVE_FACILITY_STATUS = new String[] { "APPVD", "OPRTN", "EXPIR", "TINPR", "CLSNM", "CLSWP", "CLSTR", "WRIOF",
				"INCOM", "STINC", "RESTR", "REJAP", "VOID0" };

		LIVE_CUSTOMER_STATUS = new String[] { "A", "I" };
	}

	@Inject
	private static Logger logger;
	
	public static enum ID_TYPE {
		ENTRY_BOOKING("EB"), CUSTOMER("CS"), FACILITY("FC");

		private ID_TYPE(String val) {
			this.val = val;
		}

		private String val;

		public String getVal() {
			return val;
		}
	}

	public static enum MOBILE_STATUS {
		Waiting("W"), CreditAnalystTask("CA"), BranchManagerTask("BM"), Approve("A"), Cancel("C"), Reject("R");

		private MOBILE_STATUS(String val) {
			this.val = val;
		}

		private String val;

		public String getVal() {
			return val;
		}
	}

	public static Date firstCleanDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int firstDayOfMonth = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		int hourMin = cal.getActualMinimum(Calendar.HOUR_OF_DAY);
		int minuteMin = cal.getActualMinimum(Calendar.MINUTE);
		int secMin = cal.getActualMinimum(Calendar.SECOND);
		int msecMin = cal.getActualMinimum(Calendar.MILLISECOND);

		cal.set(Calendar.DAY_OF_MONTH, firstDayOfMonth);
		cal.set(Calendar.HOUR_OF_DAY, hourMin);
		cal.set(Calendar.MINUTE, minuteMin);
		cal.set(Calendar.SECOND, secMin);
		cal.set(Calendar.MILLISECOND, msecMin);

		return cal.getTime();
	}

	public static Date lastCleanDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int hourMax = cal.getActualMaximum(Calendar.HOUR_OF_DAY);
		int minuteMax = cal.getActualMaximum(Calendar.MINUTE);
		int secMax = cal.getActualMaximum(Calendar.SECOND);
		int msecMax = cal.getActualMaximum(Calendar.MILLISECOND);

		cal.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		cal.set(Calendar.HOUR_OF_DAY, hourMax);
		cal.set(Calendar.MINUTE, minuteMax);
		cal.set(Calendar.SECOND, secMax);
		cal.set(Calendar.MILLISECOND, msecMax);

		return cal.getTime();
	}

//	public String getClientIpAddr(HttpServletRequest request) {
//
//		if (request == null)
//			return "NULLREQUEST";
//
//		String ip = request.getHeader("X-Forwarded-For");
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("WL-Proxy-Client-IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_X_FORWARDED");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_CLIENT_IP");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_FORWARDED_FOR");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_FORWARDED");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("HTTP_VIA");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getHeader("REMOTE_ADDR");
//		}
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//			ip = request.getRemoteAddr();
//		}
//		return ip;
//	}

	public static boolean isActiveFacility(String status) {
		boolean active = false;

		if (Arrays.asList(LIVE_FACILITY_STATUS).contains(status)) {
			active = true;
		}

		return active;
	}

	public static boolean isNewFacility(String status) {
		boolean active = false;

		if (Arrays.asList(NEW_FACILITY_STATUS).contains(status)) {
			active = true;
		}

		return active;
	}

	public static boolean isActiveCustomer(String status) {
		boolean active = false;

		if (Arrays.asList(LIVE_CUSTOMER_STATUS).contains(status)) {
			active = true;
		}

		return active;
	}

	public static BigDecimal getDecimalCalculationValue(BigDecimal value) {
		BigDecimal retVal = new BigDecimal(0);
		if (CommonUtil.isNotNullOrEmpty(value)) {
			retVal = value;
		}

		return retVal;
	}

	public static Boolean isNotNullOrEmpty(Object object) {
		return !isNullOrEmpty(object);
	}

	@SuppressWarnings("rawtypes")
	public static Boolean isNullOrEmpty(Object object) {
		if (object == null) {
			return true;
		} else {
			if (object instanceof Collection) {
				if (((Collection) object).isEmpty()) {
					return true;
				}
			} else if (object instanceof AbstractMap) {
				if (((AbstractMap) object).isEmpty()) {
					return true;
				}
			} else if (object instanceof Long) {
				if (Long.parseLong(object.toString()) == 0) {
					return true;
				}
			} else if (object.getClass().isArray()) {
				if (object instanceof byte[]) {
					if (((byte[]) object).length == 0) {
						return true;
					}
				} else {
					if (((Object[]) object).length == 0) {
						return true;
					}
				}

			} else {
				if (object.toString().trim().equals("")) {
					return true;
				}
			}
			return false;
		}
	}

	public static String inflate(byte[] source) throws UnsupportedEncodingException, DataFormatException {

		Inflater inflater = new Inflater();
		inflater.setInput(source);

		ByteArrayOutputStream rawResult = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];

		while (!inflater.finished()) {
			int uncompressedLength = inflater.inflate(buffer);
			rawResult.write(buffer, 0, uncompressedLength);
		}

		inflater.end();

		// Decode the bytes into a String
		return new String(rawResult.toByteArray());

	}

	public static byte[] deflate(String source) throws IOException {

		// Compress the bytes
		Deflater compresser = new Deflater(Deflater.BEST_COMPRESSION);
		compresser.setInput(source.getBytes("UTF-8"));
		compresser.finish();

		ByteArrayOutputStream rawResult = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];

		while (!compresser.finished()) {
			int compressedLength = compresser.deflate(buffer);
			rawResult.write(buffer, 0, compressedLength);
		}

		rawResult.close();

		return rawResult.toByteArray();

	}

	public static Date getCleanDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hourMin = cal.getActualMinimum(Calendar.HOUR_OF_DAY);
		int minuteMin = cal.getActualMinimum(Calendar.MINUTE);
		int secMin = cal.getActualMinimum(Calendar.SECOND);
		int msecMin = cal.getActualMinimum(Calendar.MILLISECOND);

		cal.set(Calendar.HOUR_OF_DAY, hourMin);
		cal.set(Calendar.MINUTE, minuteMin);
		cal.set(Calendar.SECOND, secMin);
		cal.set(Calendar.MILLISECOND, msecMin);

		return cal.getTime();
	}

	public static void log(String message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	public static String stringFormat(String text, String[] data) {
		String textResult = text;
		for(int i=0;i<data.length;i++) {
			textResult = textResult.replace("{"+(i+1)+"}", data[i]==null?"":data[i]);
		}
		return textResult;
	}
}
