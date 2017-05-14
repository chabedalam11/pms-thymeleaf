package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t30007")
public class T30007 {
	@Id
	@Column(name = "t_manufacturer_code")
	private String tmanufacturercode;
	private String t_entry_user;
	private Date   t_entry_date;
	private String t_upd_user;
	private Date t_upd_date;
	private String t_lang1_name;
	private String t_lang2_name;
	private String t_vendor_code;
	
	public String getTmanufacturercode() {
		return tmanufacturercode;
	}
	public void setTmanufacturercode(String tmanufacturercode) {
		this.tmanufacturercode = tmanufacturercode;
	}
	public String getT_entry_user() {
		return t_entry_user;
	}
	public void setT_entry_user(String t_entry_user) {
		this.t_entry_user = t_entry_user;
	}
	public Date getT_entry_date() {
		return t_entry_date;
	}
	public void setT_entry_date(Date t_entry_date) {
		this.t_entry_date = t_entry_date;
	}
	public String getT_upd_user() {
		return t_upd_user;
	}
	public void setT_upd_user(String t_upd_user) {
		this.t_upd_user = t_upd_user;
	}
	public Date getT_upd_date() {
		return t_upd_date;
	}
	public void setT_upd_date(Date t_upd_date) {
		this.t_upd_date = t_upd_date;
	}
	public String getT_lang1_name() {
		return t_lang1_name;
	}
	public void setT_lang1_name(String t_lang1_name) {
		this.t_lang1_name = t_lang1_name;
	}
	public String getT_lang2_name() {
		return t_lang2_name;
	}
	public void setT_lang2_name(String t_lang2_name) {
		this.t_lang2_name = t_lang2_name;
	}
	public String getT_vendor_code() {
		return t_vendor_code;
	}
	public void setT_vendor_code(String t_vendor_code) {
		this.t_vendor_code = t_vendor_code;
	}
	

	
	
	
}
