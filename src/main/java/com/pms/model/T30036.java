package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t30036")
public class T30036 {
	
	@Id
	@Column(name = "t_um")
	private String tum;
	private String t_entry_user;
	private Date   t_entry_date;
	private String t_upd_user;
	private Date t_upd_date;
	private String t_lang1_name;
	private String t_lang2_name;
	private String t_um_short_dscrptn;
	private String t_um_short_desc_arb;
	private String t_um_long_dscrptn;
	
	public String getTum() {
		return tum;
	}
	public void setTum(String tum) {
		this.tum = tum;
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
	public String getT_um_short_dscrptn() {
		return t_um_short_dscrptn;
	}
	public void setT_um_short_dscrptn(String t_um_short_dscrptn) {
		this.t_um_short_dscrptn = t_um_short_dscrptn;
	}
	public String getT_um_short_desc_arb() {
		return t_um_short_desc_arb;
	}
	public void setT_um_short_desc_arb(String t_um_short_desc_arb) {
		this.t_um_short_desc_arb = t_um_short_desc_arb;
	}
	public String getT_um_long_dscrptn() {
		return t_um_long_dscrptn;
	}
	public void setT_um_long_dscrptn(String t_um_long_dscrptn) {
		this.t_um_long_dscrptn = t_um_long_dscrptn;
	}
	
	
	
	
}
