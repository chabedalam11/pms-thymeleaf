package com.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Date;

@Entity
@Table(name = "t30006")
public class T30006 {
	@Id
	@Column(name = "t_drug_master_code")
	private String tdrugmastercode;
	private String t_entry_user;
	private Date   t_entry_date;
	private String t_upd_user;
	private Date t_upd_date;
	private String t_trade_code;
	private String t_strength;
	private String t_route_code;
	private String t_drug_form_code;
	private String t_bse_um;
	private String t_moh_item_code;
	private String t_active_flag;
	private String t_moh_price;
	private String t_moh_cost;
	private String t_pack_code;
	private String t_drug_sform_code;
	private String t_phys_state;
	private String t_reg_no;
	private String t_units;
	private String t_drug_spclty_code;
	private String t_upd_reason;
	private String t_user_ip;
	private String t_opd_price;
	private String t_ip_price;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private T30001 t30001;
	@ManyToOne(fetch = FetchType.LAZY)
	private T30002 t30002;
	
	
	public String getTdrugmastercode() {
		return tdrugmastercode;
	}
	public void setTdrugmastercode(String tdrugmastercode) {
		this.tdrugmastercode = tdrugmastercode;
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
	public String getT_trade_code() {
		return t_trade_code;
	}
	public void setT_trade_code(String t_trade_code) {
		this.t_trade_code = t_trade_code;
	}
	public String getT_strength() {
		return t_strength;
	}
	public void setT_strength(String t_strength) {
		this.t_strength = t_strength;
	}
	public String getT_route_code() {
		return t_route_code;
	}
	public void setT_route_code(String t_route_code) {
		this.t_route_code = t_route_code;
	}
	public String getT_drug_form_code() {
		return t_drug_form_code;
	}
	public void setT_drug_form_code(String t_drug_form_code) {
		this.t_drug_form_code = t_drug_form_code;
	}
	public String getT_bse_um() {
		return t_bse_um;
	}
	public void setT_bse_um(String t_bse_um) {
		this.t_bse_um = t_bse_um;
	}
	public String getT_moh_item_code() {
		return t_moh_item_code;
	}
	public void setT_moh_item_code(String t_moh_item_code) {
		this.t_moh_item_code = t_moh_item_code;
	}
	public String getT_active_flag() {
		return t_active_flag;
	}
	public void setT_active_flag(String t_active_flag) {
		this.t_active_flag = t_active_flag;
	}
	public String getT_moh_price() {
		return t_moh_price;
	}
	public void setT_moh_price(String t_moh_price) {
		this.t_moh_price = t_moh_price;
	}
	public String getT_moh_cost() {
		return t_moh_cost;
	}
	public void setT_moh_cost(String t_moh_cost) {
		this.t_moh_cost = t_moh_cost;
	}
	public String getT_pack_code() {
		return t_pack_code;
	}
	public void setT_pack_code(String t_pack_code) {
		this.t_pack_code = t_pack_code;
	}
	public String getT_drug_sform_code() {
		return t_drug_sform_code;
	}
	public void setT_drug_sform_code(String t_drug_sform_code) {
		this.t_drug_sform_code = t_drug_sform_code;
	}
	public String getT_phys_state() {
		return t_phys_state;
	}
	public void setT_phys_state(String t_phys_state) {
		this.t_phys_state = t_phys_state;
	}
	public String getT_reg_no() {
		return t_reg_no;
	}
	public void setT_reg_no(String t_reg_no) {
		this.t_reg_no = t_reg_no;
	}
	public String getT_units() {
		return t_units;
	}
	public void setT_units(String t_units) {
		this.t_units = t_units;
	}
	public String getT_drug_spclty_code() {
		return t_drug_spclty_code;
	}
	public void setT_drug_spclty_code(String t_drug_spclty_code) {
		this.t_drug_spclty_code = t_drug_spclty_code;
	}
	public String getT_upd_reason() {
		return t_upd_reason;
	}
	public void setT_upd_reason(String t_upd_reason) {
		this.t_upd_reason = t_upd_reason;
	}
	public String getT_user_ip() {
		return t_user_ip;
	}
	public void setT_user_ip(String t_user_ip) {
		this.t_user_ip = t_user_ip;
	}
	public String getT_opd_price() {
		return t_opd_price;
	}
	public void setT_opd_price(String t_opd_price) {
		this.t_opd_price = t_opd_price;
	}
	public String getT_ip_price() {
		return t_ip_price;
	}
	public void setT_ip_price(String t_ip_price) {
		this.t_ip_price = t_ip_price;
	}
	
	
	public T30001 getT30001() {
		return t30001;
	}
	public void setT30001(T30001 t30001) {
		this.t30001 = t30001;
	}
	public T30002 getT30002() {
		return t30002;
	}
	public void setT30002(T30002 t30002) {
		this.t30002 = t30002;
	}
	

	
	
	
}
