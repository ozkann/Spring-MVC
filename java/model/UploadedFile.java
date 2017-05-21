package model;

import java.time.LocalDateTime;


import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

	private MultipartFile file;
	private String description;
	private LocalDateTime uploadDate;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDateTime uploadDate) {
		this.uploadDate = uploadDate;
	}


	
}
