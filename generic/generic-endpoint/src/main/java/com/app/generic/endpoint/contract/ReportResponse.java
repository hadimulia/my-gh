package com.app.generic.endpoint.contract;

/**
 * @author heri.purwanto
 *
 */
public class ReportResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684673266200020725L;
	private String status;
	private int code;
	private Long queueId;
	private String queueMessage;
	private String processName;
	private String statusProcess;
	private String filePath;
	private String fileName;
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Long getQueueId() {
		return queueId;
	}
	public void setQueueId(Long queueId) {
		this.queueId = queueId;
	}
	public String getQueueMessage() {
		return queueMessage;
	}
	public void setQueueMessage(String queueMessage) {
		this.queueMessage = queueMessage;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getStatusProcess() {
		return statusProcess;
	}
	public void setStatusProcess(String statusProcess) {
		this.statusProcess = statusProcess;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
