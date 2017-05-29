package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t30005")
public class T30005 {
	@Id
	@Column(name = "t_trade_code")
	private String ttradecode;
	private String t_entry_user;
	private Date   t_entry_date;
	private String t_upd_user;
	private Date t_upd_date;
	private String t_gen_code;
	private String t_manuf_code;
	private String t_lang1_name;
	private String t_lang2_name;
	private String t_active_flag;
	
	
	public String getTtradecode() {
		return ttradecode;
	}
	public void setTtradecode(String ttradecode) {
		this.ttradecode = ttradecode;
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
	public String getT_gen_code() {
		return t_gen_code;
	}
	public void setT_gen_code(String t_gen_code) {
		this.t_gen_code = t_gen_code;
	}
	public String getT_manuf_code() {
		return t_manuf_code;
	}
	public void setT_manuf_code(String t_manuf_code) {
		this.t_manuf_code = t_manuf_code;
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
	public String getT_active_flag() {
		return t_active_flag;
	}
	public void setT_active_flag(String t_active_flag) {
		this.t_active_flag = t_active_flag;
	}
	
	
	
	
}
