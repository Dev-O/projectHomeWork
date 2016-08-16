package com.ola;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;



	public interface TextRepository extends PagingAndSortingRepository<Text, Long> {

		  /**
		   * This method will find an texts instance in the database by its username.
		   * Note that this method is not implemented and its working code will be
		   * automagically generated from its signature by Spring Data JPA.
		   */
		
		 // public List<Text> findByUserName(String UserName);
		   
}
