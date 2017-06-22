package com.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.pms.model.T30005;

import java.lang.String;
import java.util.List;

@Repository("t30005Repository")
public interface T30005Repository extends JpaRepository<T30005, Long> {
	 
	T30005 findByTtradecode(String ttradecode);
	 
	 @Query("FROM T30005 WHERE t_gen_code = :t_gen_code")
	 public List<T30005> findByT_gen_code(@Param("t_gen_code") String t_gen_code);
	 
	 
	 @Query("SELECT max(CAST(ttradecode AS integer)) FROM  T30005")
	 String getMaxTtradecode();
}
