package com.asus.module.file;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	
private String imDbTableName;
	
	private String imseq;
	private String impath;
	private String imfilename;
	private String imext;
	private long imsize;
	private String rseq;
	
	private MultipartFile[] imUploadFiles;

	public String getImDbTableName() {
		return imDbTableName;
	}

	public String getImseq() {
		return imseq;
	}

	public void setImseq(String imseq) {
		this.imseq = imseq;
	}

	public String getImpath() {
		return impath;
	}

	public void setImpath(String impath) {
		this.impath = impath;
	}

	public String getImfilename() {
		return imfilename;
	}

	public void setImfilename(String imfilename) {
		this.imfilename = imfilename;
	}

	public String getImext() {
		return imext;
	}

	public void setImext(String imext) {
		this.imext = imext;
	}

	public long getImsize() {
		return imsize;
	}

	public void setImsize(long imsize) {
		this.imsize = imsize;
	}

	public String getRseq() {
		return rseq;
	}

	public void setRseq(String rseq) {
		this.rseq = rseq;
	}

	public MultipartFile[] getImUploadFiles() {
		return imUploadFiles;
	}

	public void setImUploadFiles(MultipartFile[] imUploadFiles) {
		this.imUploadFiles = imUploadFiles;
	}

	public void setImDbTableName(String imDbTableName) {
		this.imDbTableName = imDbTableName;
	}


	
	
}
