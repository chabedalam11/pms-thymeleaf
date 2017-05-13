package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t30004")
public class T30004 {
	@Id
	@Column(name = "t_gen_code")
	private String tgencode;
	private String t_entry_user;
	private Date   t_entry_date;
	private String t_upd_user;
	private Date t_upd_date;
	private String t_lang1_name;
	private String t_lang2_nam;
	private String t_drug_therap_cls_code;
	private String t_active_flag;
	private String t_control_drug;
	private String t_drug_use;
	
	
	
	
	public String getTgencode() {
		return tgencode;
	}
	public void setTgencode(String tgencode) {
		this.tgencode = tgencode;
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
	public String getT_lang2_nam() {
		return t_lang2_nam;
	}
	public void setT_lang2_nam(String t_lang2_nam) {
		this.t_lang2_nam = t_lang2_nam;
	}
	public String getT_drug_therap_cls_code() {
		return t_drug_therap_cls_code;
	}
	public void setT_drug_therap_cls_code(String t_drug_therap_cls_code) {
		this.t_drug_therap_cls_code = t_drug_therap_cls_code;
	}
	public String getT_active_flag() {
		return t_active_flag;
	}
	public void setT_active_flag(String t_active_flag) {
		this.t_active_flag = t_active_flag;
	}
	public String getT_control_drug() {
		return t_control_drug;
	}
	public void setT_control_drug(String t_control_drug) {
		this.t_control_drug = t_control_drug;
	}
	public String getT_drug_use() {
		return t_drug_use;
	}
	public void setT_drug_use(String t_drug_use) {
		this.t_drug_use = t_drug_use;
	}
	
	
}
