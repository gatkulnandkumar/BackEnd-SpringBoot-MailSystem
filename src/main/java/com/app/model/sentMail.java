package com.app.model;

//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "`SendMail`")
public class sentMail {
	
	
	
	    // Class data members
	    private String recipient;
	    private String msgBody;
	    private String subject;
	    private String attachment;
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getMsgBody() {
			return msgBody;
		}
		public sentMail(String recipient, String msgBody, String subject, String attachment) {
			super();
			this.recipient = recipient;
			this.msgBody = msgBody;
			this.subject = subject;
			this.attachment = attachment;
		}
		public sentMail() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void setMsgBody(String msgBody) {
			this.msgBody = msgBody;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getAttachment() {
			return attachment;
		}
		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}
	
	
}
