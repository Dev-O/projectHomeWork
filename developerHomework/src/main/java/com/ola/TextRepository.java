package com.ola;

import java.util.List;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;



	public interface TextRepository extends CrudRepository<Text, Long> {

		  /**
		   * This method will find an texts instance in the database by its username.
		   * Note that this method is not implemented and its working code will be
		   * automagically generated from its signature by Spring Data JPA.
		   */
		
		 public List<Text> findByUserName(String UserName);
		 
		 
		 public Iterable<Text> findAll();
		 
		 @Query("SELECT t FROM Text t where t.oid IS NOT NULL")
		 public List<Text> findAllTexts();
		 
		 public Text findByTimePosted(Timestamp timest);
		 
		 
		   
}
