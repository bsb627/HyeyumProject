package file.model.vo;

import java.sql.Timestamp;

public class FileData {
	
	private String fileNo;
	private String fileName;
	private String filePath;
	private long fileSize;
	private String fileUser;
	private Timestamp uploadTime; // java.sql에 있는 TimeStamp를 임포트해줌
	
	// constructor
	public FileData() {
		// TODO Auto-generated constructor stub
	}
	// getter/setter

	public String getFileName() {
		return fileName;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUser() {
		return fileUser;
	}

	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}


	
	// toString 
	@Override
	public String toString() {
		return "FileData [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", fileUser=" + fileUser + ", uploadTime=" + uploadTime + "]";
	}

}
