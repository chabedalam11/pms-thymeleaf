package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.model.T30006;

import java.lang.String;
import java.util.List;

@Repository("t30006Repository")
public interface T30006Repository extends JpaRepository<T30006, Long> {
	
	 T30006 findByTdrugmastercode(String tdrugmastercode);
	 
	 @Query("FROM T30006 WHERE t_trade_code = :t_trade_code")
	 public T30006 findByT_trade_code(@Param("t_trade_code") String t_trade_code);
	 
	 @Query("SELECT max(CAST(tdrugmastercode AS integer)) FROM  T30006")
	 String getMaxTdrugmastercode();
	 
	
	 
	 /*//@Query("SELECT  t30006.t_drug_master_code,t30006.t_units ,t30006.t_strength ,t30006.t_opd_price ,t30006.t_active_flag ,t30001.t_lang2_name ,t30002.t_lang2_name ,t30005.t_lang2_name ,t30036.t_lang2_name FROM t30006 LEFT JOIN t30001 ON  t30006.t_drug_form_code = t30001.t_drug_form_code LEFT JOIN t30002 ON  t30006.t_route_code = t30002.t_drug_route_code LEFT JOIN t30005 ON  t30006.t_trade_code = t30005.t_trade_code LEFT JOIN t30036 ON  t30006.t_bse_um = t30036.t_um;")
	 @Query("SELECT  T30006.tdrugmastercode,T30001.t_lang2_name FROM T30006 LEFT JOIN T30001 ON  T30006.t_drug_form_code = T30001.tdrugformcode")
	 List<ArrayList<String>> getMax2Tdrugmastercode();*/
	 
	 //String Q_GET_ALL_USERS = "SELECT u.tdrugmastercode from T30006 u left join T30001 r on u.t_drug_form_code=r.tdrugformcode";

	 //String Q_GET_ALL_USERS = "select u from T30006 u left join  u.t30001 left join fetch u.t30002";
	 String Q_GET_ALL_USERS = "select u.tdrugmastercode, u.t30001.t_lang2_name from T30006 u left join   u.t30001";
	 @Query(Q_GET_ALL_USERS)
	 List<T30006> getAllT30006();
}
