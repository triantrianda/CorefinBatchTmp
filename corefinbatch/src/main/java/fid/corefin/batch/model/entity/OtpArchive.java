package fid.corefin.batch.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP_ARCHIVE")
public class OtpArchive {
		@Id
		@Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@Column(name = "FID_OTP")
		private Long fidOtp;
	
		@Column(name = "OTP_INPUT_CHALLENGE")
		private String otpInputChallenge;
		
		@Column(name = "PROCESS_DATE")
		private Date processDate;
		
		@Column(name = "REF_ID")
		private String refId;
		
		@Column(name = "MSISDN")
		private String msisdn;
		
		@Column(name = "OTP_INPUT")
		private String otpInput;
		
		@Column(name = "CREATE_DATE")
		private Date createDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getFidOtp() {
			return fidOtp;
		}

		public void setFidOtp(Long fidOtp) {
			this.fidOtp = fidOtp;
		}

		public String getOtpInputChallenge() {
			return otpInputChallenge;
		}

		public void setOtpInputChallenge(String otpInputChallenge) {
			this.otpInputChallenge = otpInputChallenge;
		}

		public Date getProcessDate() {
			return processDate;
		}

		public void setProcessDate(Date processDate) {
			this.processDate = processDate;
		}

		public String getRefId() {
			return refId;
		}

		public void setRefId(String refId) {
			this.refId = refId;
		}

		public String getMsisdn() {
			return msisdn;
		}

		public void setMsisdn(String msisdn) {
			this.msisdn = msisdn;
		}

		public String getOtpInput() {
			return otpInput;
		}

		public void setOtpInput(String otpInput) {
			this.otpInput = otpInput;
		}
}
