package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "WA_OTP")
public class WaOTP {
		@Id
		@Temporal(TemporalType.DATE)
		@Column(name = "DATE")
		private Date date;
		
		@Column(name = "OTP_SUCCESS")
		private int otpSuccess;
		
		@Column(name = "OTP_FAILED")
		private int otpFailed;
		
		@Column(name = "OTP_OBSOLETE")
		private int otpObsolete;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public int getOtpSuccess() {
			return otpSuccess;
		}

		public void setOtpSuccess(int otpSuccess) {
			this.otpSuccess = otpSuccess;
		}

		public int getOtpFailed() {
			return otpFailed;
		}

		public void setOtpFailed(int otpFailed) {
			this.otpFailed = otpFailed;
		}

		public int getOtpObsolete() {
			return otpObsolete;
		}

		public void setOtpObsolete(int otpObsolete) {
			this.otpObsolete = otpObsolete;
		}
}
