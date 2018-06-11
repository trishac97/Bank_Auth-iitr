package com.bank.model;

import java.io.InputStream;
import java.sql.Blob;

public class UploadDetails {
	 private String acc_no;
	 private String password;
	 private String first_name;
	 private String last_name;
	 private InputStream photo;
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public InputStream getPhoto(InputStream inputStream) {
		return photo;
	}
	public void setPhoto(InputStream inputStream) {
		this.photo = inputStream;
	}
}
