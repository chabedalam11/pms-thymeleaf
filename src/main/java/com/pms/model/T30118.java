package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t30118")
public class T30118 {
	@Id
	@Column(name = "t_vendor_code")
	private String tvendorcode;
	private Date t_upd_date;
	private String t_upd_user;
	private Date t_last_po_date;
	private String t_last_po_no;
	private Date t_last_rc_date;
	private Date t_last_rj_date;
	private String t_late_days_avg; 
	private String t_lead_time_avg;
	private String t_po;
	private String t_po_lines;
	private String t_rj_avg_pct;
	private String t_vendor_active_flag_y;
	private String t_vendor_addr_1;
	private String t_vendor_addr_2;
	private String t_vendor_addr_3;
	private String t_vendor_addr_4;
	private String t_vendor_contact;
	private String t_lang2_name;
	private String t_vendor_tel_no;
	private String t_vendor_tlfx_no;
	private String t_vendor_tlx_no;
	private String t_lang1_name;
	
	
	
	
	public String getTvendorcode() {
		return tvendorcode;
	}




	public void setTvendorcode(String tvendorcode) {
		this.tvendorcode = tvendorcode;
	}




	public Date getT_upd_date() {
		return t_upd_date;
	}




	public void setT_upd_date(Date t_upd_date) {
		this.t_upd_date = t_upd_date;
	}




	public String getT_upd_user() {
		return t_upd_user;
	}




	public void setT_upd_user(String t_upd_user) {
		this.t_upd_user = t_upd_user;
	}




	public Date getT_last_po_date() {
		return t_last_po_date;
	}




	public void setT_last_po_date(Date t_last_po_date) {
		this.t_last_po_date = t_last_po_date;
	}




	public String getT_last_po_no() {
		return t_last_po_no;
	}




	public void setT_last_po_no(String t_last_po_no) {
		this.t_last_po_no = t_last_po_no;
	}




	public Date getT_last_rc_date() {
		return t_last_rc_date;
	}




	public void setT_last_rc_date(Date t_last_rc_date) {
		this.t_last_rc_date = t_last_rc_date;
	}




	public Date getT_last_rj_date() {
		return t_last_rj_date;
	}




	public void setT_last_rj_date(Date t_last_rj_date) {
		this.t_last_rj_date = t_last_rj_date;
	}




	public String getT_late_days_avg() {
		return t_late_days_avg;
	}




	public void setT_late_days_avg(String t_late_days_avg) {
		this.t_late_days_avg = t_late_days_avg;
	}




	public String getT_lead_time_avg() {
		return t_lead_time_avg;
	}




	public void setT_lead_time_avg(String t_lead_time_avg) {
		this.t_lead_time_avg = t_lead_time_avg;
	}




	public String getT_po() {
		return t_po;
	}




	public void setT_po(String t_po) {
		this.t_po = t_po;
	}




	public String getT_po_lines() {
		return t_po_lines;
	}




	public void setT_po_lines(String t_po_lines) {
		this.t_po_lines = t_po_lines;
	}




	public String getT_rj_avg_pct() {
		return t_rj_avg_pct;
	}




	public void setT_rj_avg_pct(String t_rj_avg_pct) {
		this.t_rj_avg_pct = t_rj_avg_pct;
	}




	public String getT_vendor_active_flag_y() {
		return t_vendor_active_flag_y;
	}




	public void setT_vendor_active_flag_y(String t_vendor_active_flag_y) {
		this.t_vendor_active_flag_y = t_vendor_active_flag_y;
	}




	public String getT_vendor_addr_1() {
		return t_vendor_addr_1;
	}




	public void setT_vendor_addr_1(String t_vendor_addr_1) {
		this.t_vendor_addr_1 = t_vendor_addr_1;
	}




	public String getT_vendor_addr_2() {
		return t_vendor_addr_2;
	}




	public void setT_vendor_addr_2(String t_vendor_addr_2) {
		this.t_vendor_addr_2 = t_vendor_addr_2;
	}




	public String getT_vendor_addr_3() {
		return t_vendor_addr_3;
	}




	public void setT_vendor_addr_3(String t_vendor_addr_3) {
		this.t_vendor_addr_3 = t_vendor_addr_3;
	}




	public String getT_vendor_addr_4() {
		return t_vendor_addr_4;
	}




	public void setT_vendor_addr_4(String t_vendor_addr_4) {
		this.t_vendor_addr_4 = t_vendor_addr_4;
	}




	public String getT_vendor_contact() {
		return t_vendor_contact;
	}




	public void setT_vendor_contact(String t_vendor_contact) {
		this.t_vendor_contact = t_vendor_contact;
	}




	public String getT_lang2_name() {
		return t_lang2_name;
	}




	public void setT_lang2_name(String t_lang2_name) {
		this.t_lang2_name = t_lang2_name;
	}




	public String getT_vendor_tel_no() {
		return t_vendor_tel_no;
	}




	public void setT_vendor_tel_no(String t_vendor_tel_no) {
		this.t_vendor_tel_no = t_vendor_tel_no;
	}




	public String getT_vendor_tlfx_no() {
		return t_vendor_tlfx_no;
	}




	public void setT_vendor_tlfx_no(String t_vendor_tlfx_no) {
		this.t_vendor_tlfx_no = t_vendor_tlfx_no;
	}




	public String getT_vendor_tlx_no() {
		return t_vendor_tlx_no;
	}




	public void setT_vendor_tlx_no(String t_vendor_tlx_no) {
		this.t_vendor_tlx_no = t_vendor_tlx_no;
	}




	public String getT_lang1_name() {
		return t_lang1_name;
	}




	public void setT_lang1_name(String t_lang1_name) {
		this.t_lang1_name = t_lang1_name;
	}




	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return t_lang2_name;
	}
	
	
	
	
}
